package com.hcl.coe.api.cms.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.coe.api.cms.entity.ContentEntity;
import com.hcl.coe.api.cms.model.AddContentRequest;
import com.hcl.coe.api.cms.model.ContentType;
import com.hcl.coe.api.cms.model.GetContentByPlanIdResponse;
import com.hcl.coe.api.cms.model.ObjectFactory;
import com.hcl.coe.api.cms.model.UpdateContentRequest;

@Component
public class ContentTransformer {
	
	@Autowired
	ObjectFactory objectFactory;

	public ContentEntity transform(AddContentRequest request) {
		ContentType contentType = request.getContent();
		ContentEntity ContentEntity = new ContentEntity(contentType.getPlanId(), contentType.getIssuer(), contentType.getState(),
				contentType.getProductType(), contentType.getLanguage(), contentType.getDocType(), contentType.getContent());
		return ContentEntity;
	}

	public GetContentByPlanIdResponse transform(ContentEntity contentEntity) {
		GetContentByPlanIdResponse response = objectFactory.createGetContentByPlanIdResponse();
		ContentType contentType = objectFactory.createContentType();
		if (null != contentEntity) {
			contentType.setPlanId(contentEntity.getPlanid());
			contentType.setIssuer(contentEntity.getIssuer());
			contentType.setState(contentEntity.getState());
			contentType.setProductType(contentEntity.getProducttype());
			contentType.setLanguage(contentEntity.getLanguage());
			contentType.setDocType(contentEntity.getDoctype());
			contentType.setContent(contentEntity.getContent());
		}
		response.setContent(contentType);
		return response;
	}

	public ContentEntity transform(UpdateContentRequest request) {
		ContentType contentType = request.getContent();
		ContentEntity ContentEntity = new ContentEntity(contentType.getPlanId(), contentType.getIssuer(), contentType.getState(),
				contentType.getProductType(), contentType.getLanguage(), contentType.getDocType(), contentType.getContent());
		return ContentEntity;
	}
}