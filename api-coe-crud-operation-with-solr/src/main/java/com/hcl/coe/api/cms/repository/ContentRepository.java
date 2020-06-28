package com.hcl.coe.api.cms.repository;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.coe.api.cms.entity.ContentEntity;

@Repository
public interface ContentRepository extends SolrCrudRepository<ContentEntity, String> {
	
	ContentEntity findByPlanID(String planID);
	
	@Query("issuer:*?0* AND state:*?1* AND productType:*?2* AND docType:*?3* AND language:*?4* AND planID:*?5*")
	List<ContentEntity> findByIssuerStateProductTypeDocTypeLanguagePlanId(String issuer, String state,
			String product, String documentType, String language, String planId);
}
