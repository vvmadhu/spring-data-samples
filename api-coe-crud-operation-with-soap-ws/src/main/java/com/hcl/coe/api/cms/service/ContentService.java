package com.hcl.coe.api.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.coe.api.cms.entity.ContentEntity;
import com.hcl.coe.api.cms.model.AddContentRequest;
import com.hcl.coe.api.cms.model.AddContentResponse;
import com.hcl.coe.api.cms.model.ContentType;
import com.hcl.coe.api.cms.model.DeleteContentRequest;
import com.hcl.coe.api.cms.model.DeleteContentResponse;
import com.hcl.coe.api.cms.model.GetContentByPlanIdRequest;
import com.hcl.coe.api.cms.model.GetContentByPlanIdResponse;
import com.hcl.coe.api.cms.model.ObjectFactory;
import com.hcl.coe.api.cms.model.UpdateContentRequest;
import com.hcl.coe.api.cms.model.UpdateContentResponse;
import com.hcl.coe.api.cms.repository.ContentRepository;
import com.hcl.coe.api.cms.transformer.ContentTransformer;

@Service
public class ContentService implements IContentService {

	@Autowired
	private ContentRepository contentRepository;

	@Autowired
	private ContentTransformer contentTransformer;
	
	@Autowired
	ObjectFactory objectFactory;

	@Override
	public GetContentByPlanIdResponse getContentByPlanId(GetContentByPlanIdRequest request) {
		String planId = request.getPlanId();
		ContentEntity content = contentRepository.findOne(planId);
		GetContentByPlanIdResponse response = contentTransformer.transform(content);
		return response;
	}	

	@Override
	public AddContentResponse addContent(AddContentRequest request) {
		
		AddContentResponse response = objectFactory.createAddContentResponse();		
		ContentEntity contentEntity = contentTransformer.transform(request);
		contentRepository.save(contentEntity);
		response.setStatus("Content Added");
		return response;   
	}

	@Override
	public UpdateContentResponse updateContent(UpdateContentRequest request) {
		UpdateContentResponse response = objectFactory.createUpdateContentResponse();
		ContentType contentType = request.getContent();
		ContentEntity contentEntity = contentTransformer.transform(request);
		contentRepository.save(contentEntity);
		response.setStatus("Content Updated");
		return response;
	}

	@Override
	public DeleteContentResponse deleteContent(DeleteContentRequest request) {
		String planId = request.getPlanId();
		contentRepository.delete(planId);
		DeleteContentResponse response = objectFactory.createDeleteContentResponse();
		response.setStatus("Content Removed");
		return response;
	}
}
