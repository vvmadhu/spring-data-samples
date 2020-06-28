package com.hcl.coe.api.cms.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="cms")
public class ContentEntity implements Serializable { 
	
	@Id
	@Column//(name="planID")
	private String planid;
	
	@Column//(name="issuer")
	private String issuer;
	
	@Column//(name="state")
	private String state;
	
	@Column//(name="productType")
	private String producttype;
	
	@Column//(name="language")
	private String language;
	
	@Column//(name="docType")
	private String doctype;
	
	@Column//(name="content")
	private String content;
	
	public ContentEntity() {
		
	}

	public ContentEntity(String planid, String issuer, String state, String producttype, String language,
			String doctype, String content) {
		super();
		this.planid = planid;
		this.issuer = issuer;
		this.state = state;
		this.producttype = producttype;
		this.language = language;
		this.doctype = doctype;
		this.content = content;
	}

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
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

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ContentEntity [planid=" + planid + ", issuer=" + issuer + ", state=" + state + ", producttype="
				+ producttype + ", language=" + language + ", doctype=" + doctype + ", content=" + content + "]";
	}

} 