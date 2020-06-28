package com.hcl.coe.api.cms.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.hcl.coe.api.cms.model.AddContentRequest;
import com.hcl.coe.api.cms.model.AddContentResponse;
import com.hcl.coe.api.cms.model.DeleteContentRequest;
import com.hcl.coe.api.cms.model.DeleteContentResponse;
import com.hcl.coe.api.cms.model.GetContentByPlanIdRequest;
import com.hcl.coe.api.cms.model.GetContentByPlanIdResponse;
import com.hcl.coe.api.cms.model.UpdateContentRequest;
import com.hcl.coe.api.cms.model.UpdateContentResponse;
import com.hcl.coe.api.cms.service.IContentService;

@Endpoint
public class ContentEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.cms.api.coe.hcl.com/content-ws";
	
	@Autowired
	private IContentService contentService;	
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContentByPlanIdRequest")
	@ResponsePayload
	public GetContentByPlanIdResponse getContentByPlanIdRequest(@RequestPayload GetContentByPlanIdRequest request) {
		GetContentByPlanIdResponse response = contentService.getContentByPlanId(request);
		return response;
	}	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addContentRequest")
	@ResponsePayload
	public AddContentResponse addContent(@RequestPayload AddContentRequest request) {
		AddContentResponse response = contentService.addContent(request);        
        return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateContentRequest")
	@ResponsePayload
	public UpdateContentResponse updateContent(@RequestPayload UpdateContentRequest request) {
		UpdateContentResponse response = contentService.updateContent(request);        
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteContentRequest")
	@ResponsePayload
	public DeleteContentResponse deleteContent(@RequestPayload DeleteContentRequest request) {
		DeleteContentResponse response = contentService.deleteContent(request);    	
		return response;
	}
	
}
