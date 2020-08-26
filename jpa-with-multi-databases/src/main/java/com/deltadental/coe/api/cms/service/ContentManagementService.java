package com.deltadental.coe.api.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltadental.coe.api.cms.model.Content;
import com.deltadental.coe.api.cms.mysql.repository.MySqlContentRepository;
import com.deltadental.coe.api.cms.sqlserver.repository.SqlServerContentRepository;
import com.deltadental.coe.api.cms.transformer.ContentTransformer;

@Service
public class ContentManagementService {

	@Autowired
	MySqlContentRepository mySqlContentRepository;
	
	@Autowired
	SqlServerContentRepository sqlServerContentRepository;

	@Autowired
	ContentTransformer contentTransformer;

	Logger logger = LoggerFactory.getLogger(ContentManagementService.class);

	public List<Content> getContent(String planID, String issuer, String state, String product, String documentType,
			String language) {
		List<Content> content = null;
		List<com.deltadental.coe.api.cms.mysql.entity.ContentEntity> mySqlContentEntity = null;
		List<com.deltadental.coe.api.cms.sqlserver.entity.ContentEntity> sqlServerContentEntity = null;
		
		if (null != issuer && null != state && null != product && null != documentType && null != language) {
			mySqlContentEntity = mySqlContentRepository.findByIssuerStateProductTypeDocTypeLanguagePlanId(issuer, state, product, documentType, language, planID);
			sqlServerContentEntity = sqlServerContentRepository.findByIssuerStateProductTypeDocTypeLanguagePlanId(issuer, state, product, documentType, language, planID);
			
		} else {
			mySqlContentEntity = new ArrayList<com.deltadental.coe.api.cms.mysql.entity.ContentEntity>(1);
			mySqlContentEntity.add(mySqlContentRepository.findByPlanID(planID));
			
			sqlServerContentEntity = new ArrayList<com.deltadental.coe.api.cms.sqlserver.entity.ContentEntity>(1);
			sqlServerContentEntity.add(sqlServerContentRepository.findByPlanID(planID));
		}
		
		if (null != mySqlContentEntity) {
			content = contentTransformer.transformMySql(mySqlContentEntity);
		}
		
		if (null != sqlServerContentEntity) {
			if (content != null)
			content.addAll(contentTransformer.transformSqlServer(sqlServerContentEntity));
		}

		return content;
	}

	public String addContent(Content content) {
		com.deltadental.coe.api.cms.mysql.entity.ContentEntity contentEntity = contentTransformer.transform(content);
		mySqlContentRepository.save(contentEntity);
		return "Content Added";
	}

	public String updateContents(Content content) {
		com.deltadental.coe.api.cms.mysql.entity.ContentEntity contentEntity = contentTransformer.transform(content);
		mySqlContentRepository.save(contentEntity);
		return "Content Updated";
	}

	public String deleteContents(String planID) {
		mySqlContentRepository.delete(mySqlContentRepository.findByPlanID(planID));
		return "Content Deleted";
	}
}
