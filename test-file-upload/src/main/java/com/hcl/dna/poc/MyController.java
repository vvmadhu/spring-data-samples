package com.hcl.dna.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/test/")
public class MyController {

    @Autowired
    MyRepository myRepository;

    @RequestMapping(path="uploadFile", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        HttpStatus status = HttpStatus.OK;
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        MyEntity myEntity = new MyEntity(1, fileName, file.getBytes());
        myRepository.save(myEntity);
        return new ResponseEntity<String >("OK", status);
    }
    
    //https://stackoverflow.com/questions/60874967/java-spring-content-type-multipart-form-databoundary-charset-utf-8-not-supp
    @RequestMapping(path="uploadFile1", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<String> uploadFile1(@ModelAttribute MyModel myModel) throws IOException {
        HttpStatus status = HttpStatus.OK;
        MyEntity myEntity = new MyEntity(myModel.getFileId(), myModel.getFileName(), myModel.getFile().getBytes());
        System.out.println("myEntity--> "+myEntity);
        myRepository.save(myEntity);
        return new ResponseEntity<String >("OK", status);
    }
}
