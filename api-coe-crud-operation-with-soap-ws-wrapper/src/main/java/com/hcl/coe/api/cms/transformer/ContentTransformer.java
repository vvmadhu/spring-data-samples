package com.hcl.coe.api.cms.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hcl.coe.api.cms.model.Content;
import com.hcl.coe.api.cms.stub.AddContentRequest;
import com.hcl.coe.api.cms.stub.ContentType;
import com.hcl.coe.api.cms.stub.DeleteContentRequest;
import com.hcl.coe.api.cms.stub.GetContentByPlanIdRequest;
import com.hcl.coe.api.cms.stub.GetContentByPlanIdResponse;
import com.hcl.coe.api.cms.stub.ObjectFactory;
import com.hcl.coe.api.cms.stub.UpdateContentRequest;

@Component
public class ContentTransformer {

	@Autowired
	@Qualifier("contentObjectFactory")
	ObjectFactory objectFactory;
		
	public GetContentByPlanIdRequest transform(String planID) {
		GetContentByPlanIdRequest getContentByPlanIdRequest = objectFactory.createGetContentByPlanIdRequest();
		getContentByPlanIdRequest.setPlanId(planID);

		return getContentByPlanIdRequest;
	}

	public List<Content> transform(GetContentByPlanIdResponse response) {
		List<Content> contents = new ArrayList<>();
		ContentType contentType = response.getContent();
		contents.add(new Content(contentType.getPlanId(), contentType.getIssuer(), contentType.getState(),
				contentType.getProductType(), contentType.getLanguage(), contentType.getDocType(),
				contentType.getContent()));

		return contents;
	}

	public AddContentRequest transform(Content content) {
		AddContentRequest addContentRequest = objectFactory.createAddContentRequest();
		ContentType contentType = getContentType(content);
		
		addContentRequest.setContent(contentType);
		return addContentRequest;
	}
	
	public UpdateContentRequest transformUpdate(Content content) {
		UpdateContentRequest updateContentRequest = objectFactory.createUpdateContentRequest();
		ContentType contentType = getContentType(content);
		updateContentRequest.setContent(contentType);
		
		return updateContentRequest;
	}
	
	private ContentType getContentType(Content content) {
		ContentType contentType = objectFactory.createContentType();
		contentType.setContent(content.getContent());
		contentType.setDocType(content.getDocType());
		contentType.setIssuer(content.getIssuer());
		contentType.setLanguage(content.getLanguage());
		contentType.setPlanId(content.getPlanID());
		contentType.setProductType(content.getProductType());
		contentType.setState(content.getState());
		
		return contentType;		
	}

	public DeleteContentRequest transformDelete(String planID) {
		DeleteContentRequest deleteContentRequest = objectFactory.createDeleteContentRequest();
		deleteContentRequest.setPlanId(planID);

		return deleteContentRequest;
	}

}
