package com.hcl.coe.api.cms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.coe.api.cms.entity.ContentEntity;

@Repository
public interface ContentRepository extends MongoRepository<ContentEntity, String> {
	
	ContentEntity findByPlanID(String planID);
	
	@Query(value="{'issuer':'?0','state':'?1','productType':'?2','docType':'?3','language':'?4','planID':'?5'}")
	List<ContentEntity> findByIssuerStateProductTypeDocTypeLanguagePlanId(String issuer, String state,
			String product, String documentType, String language, String planId);
}