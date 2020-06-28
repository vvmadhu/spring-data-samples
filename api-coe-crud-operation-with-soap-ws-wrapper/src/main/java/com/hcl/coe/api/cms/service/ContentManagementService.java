package com.hcl.coe.api.cms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.hcl.coe.api.cms.model.Content;
import com.hcl.coe.api.cms.stub.AddContentRequest;
import com.hcl.coe.api.cms.stub.AddContentResponse;
import com.hcl.coe.api.cms.stub.DeleteContentRequest;
import com.hcl.coe.api.cms.stub.DeleteContentResponse;
import com.hcl.coe.api.cms.stub.GetContentByPlanIdRequest;
import com.hcl.coe.api.cms.stub.GetContentByPlanIdResponse;
import com.hcl.coe.api.cms.stub.UpdateContentRequest;
import com.hcl.coe.api.cms.stub.UpdateContentResponse;
import com.hcl.coe.api.cms.transformer.ContentTransformer;

@Service
public class ContentManagementService {

	@Autowired
	@Qualifier("contentWebServiceTemplate")
	private WebServiceTemplate webServiceTemplate;
	
	@Autowired
	ContentTransformer contentTransformer;

	Logger logger = LoggerFactory.getLogger(ContentManagementService.class);

	public List<Content> getContent(String planID) {
		List<Content> content = null;
		
		GetContentByPlanIdRequest getContentByPlanIdRequest = contentTransformer.transform(planID);
		GetContentByPlanIdResponse getContentByPlanIdResponse = (GetContentByPlanIdResponse) webServiceTemplate.marshalSendAndReceive(getContentByPlanIdRequest);
		content = contentTransformer.transform(getContentByPlanIdResponse);
		
		return content;
	}

	public String addContent(Content content) {
		AddContentRequest addContentRequest = contentTransformer.transform(content);
		AddContentResponse addContentResponse = (AddContentResponse) webServiceTemplate.marshalSendAndReceive(addContentRequest);
		
		return addContentResponse.getStatus();
	}

	public String updateContents(Content content) {
		UpdateContentRequest updateContentRequest = contentTransformer.transformUpdate(content);
		UpdateContentResponse updateContentResponse = (UpdateContentResponse) webServiceTemplate.marshalSendAndReceive(updateContentRequest);
		
		return updateContentResponse.getStatus();
	}

	public String deleteContents(String planID) {
		DeleteContentRequest deleteContentRequest = contentTransformer.transformDelete(planID);
		DeleteContentResponse deleteContentResponse = (DeleteContentResponse) webServiceTemplate.marshalSendAndReceive(deleteContentRequest);
		
		return deleteContentResponse.getStatus();
	}
}
