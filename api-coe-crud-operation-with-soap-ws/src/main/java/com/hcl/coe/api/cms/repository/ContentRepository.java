package com.hcl.coe.api.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.coe.api.cms.entity.ContentEntity;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, String>  {
	//ContentEntity findByPlanid(String planid);
}