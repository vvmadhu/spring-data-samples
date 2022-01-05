package com.hcl.dna.poc;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Component
public class MyModel {
    private Integer fileId;
    private String fileName;
    MultipartFile file;
}
