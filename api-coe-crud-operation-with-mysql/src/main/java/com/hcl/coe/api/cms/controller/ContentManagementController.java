package com.hcl.coe.api.cms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.coe.api.cms.model.Content;
import com.hcl.coe.api.cms.service.ContentManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/content", produces = "application/json")
@Api(value = "/content")
public class ContentManagementController {

	Logger logger = LoggerFactory.getLogger(ContentManagementController.class);

	@Autowired
	private ContentManagementService contentManagementService;

	@ApiOperation(value = "getContents", notes = "", response = List.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully searched for Results", response = List.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Exception.class) })
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Content>> getContents(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "plan id") @RequestParam(name = "planID") String planID,
			@ApiParam(value = "issuer") @RequestParam(name = "issuer", required = false) String issuer, 
			@ApiParam(value = "state") @RequestParam(name = "state", required = false) String state,
			@ApiParam(value = "product type") @RequestParam(name = "product", required = false) String product, 
			@ApiParam(value = "dpeocument type") @RequestParam(name = "documentType", required = false) String documentType, 
			@ApiParam(value = "language") @RequestParam(name = "language", required = false) String language) {

		List<Content> content = null;
		content = contentManagementService.getContent(planID, issuer, state, product, documentType, language);
		return new ResponseEntity<List<Content>>(content, HttpStatus.OK);
	}
	
	@ApiOperation(value = "addContents", notes = "Add content to MongoDB", response = String.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully added content", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Exception.class) })
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addContents(@RequestHeader HttpHeaders headers, @RequestBody Content content) {
		String response = contentManagementService.addContent(content);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "updateContents", notes = "Update content to MongoDB", response = String.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully updated content", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Exception.class) })
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateContents(@RequestHeader HttpHeaders headers, @RequestBody Content content) {
		String response = contentManagementService.updateContents(content);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "deleteContents", notes = "Update content to MongoDB", response = String.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully updated content", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Exception.class) })
	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteContents(@RequestHeader HttpHeaders headers, 
			@ApiParam(value = "plan id") @RequestParam(name = "planID") String planID) {
		String response = contentManagementService.deleteContents(planID);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
