package com.deltadental.coe.api.cms.sqlserver.entity;

import java.io.Serializable;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="cms")
//@DataSourceDefinition(name="sqlServerDataSource")
public class ContentEntity implements Serializable {

	@Id
	@Column
	private String planID;
	
	@Column
	private String issuer;
	
	@Column
	private String state;
	
	@Column
	private String productType;
	
	@Column
	private String language;
	
	@Column
	private String docType;
	
	@Column
	private String content;
	
	public ContentEntity() {
		
	}
	
	public ContentEntity(String planID, String issuer, String state, String productType, String language,
			String docType, String content) {
		this.planID = planID;
		this.issuer = issuer;
		this.state = state;
		this.productType = productType;
		this.language = language;
		this.docType = docType;
		this.content = content;
	}

	public String getPlanID() {
		return planID;
	}

	public void setPlanID(String planID) {
		this.planID = planID;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}