package com.hcl.coe.api.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hcl.coe.api.cms.entity.ContentEntity;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, String> {
	
	ContentEntity findByPlanID(String planID);
	
	@Query("select cms from cms cms "
			+ "where cms.issuer like ?1% and cms.state like ?2% and cms.productType like ?3% and cms.docType like ?4% and "
			+ "cms.language like ?5% and cms.planID like ?6%")
	List<ContentEntity> findByIssuerStateProductTypeDocTypeLanguagePlanId(String issuer, String state,
			String product, String documentType, String language, String planId);
}