package com.hcl.coe.api.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.coe.api.cms.entity.ContentEntity;
import com.hcl.coe.api.cms.model.Content;
import com.hcl.coe.api.cms.repository.ContentRepository;
import com.hcl.coe.api.cms.transformer.ContentTransformer;

@Service
public class ContentManagementService {

	@Autowired
	ContentRepository contentRepository;

	@Autowired
	ContentTransformer contentTransformer;

	Logger logger = LoggerFactory.getLogger(ContentManagementService.class);

	public List<Content> getContent(String planID, String issuer, String state, String product, String documentType,
			String language) {
		List<Content> content = null;
		List<ContentEntity> contentEntity = null;
		
		if (null != issuer && null != state && null != product && null != documentType && null != language)
			contentEntity = contentRepository.findByIssuerStateProductTypeDocTypeLanguagePlanId(issuer, state, product, documentType, language, planID);
		else {
			contentEntity = new ArrayList<ContentEntity>(1);
			contentEntity.add(contentRepository.findByPlanID(planID));
		}
		
		if (null != contentEntity) {
			content = contentTransformer.transform(contentEntity);
		}

		return content;
	}

	public String addContent(Content content) {
		ContentEntity contentEntity = contentTransformer.transform(content);
		contentRepository.save(contentEntity);
		return "Content Added";
	}

	public String updateContents(Content content) {
		ContentEntity contentEntity = contentTransformer.transform(content);
		contentRepository.save(contentEntity);
		return "Content Updated";
	}

	public String deleteContents(String planID) {
		contentRepository.delete(contentRepository.findByPlanID(planID));
		return "Content Deleted";
	}
}
