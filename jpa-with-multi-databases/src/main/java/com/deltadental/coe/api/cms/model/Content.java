package com.deltadental.coe.api.cms.model;

public class Content {
	private String planID;
	private String issuer;
	private String state;
	private String productType;
	private String language;
	private String docType;
	private String content;
	
	public Content() {
		super();
	}

	public Content(String planID, String issuer, String state, String productType, String language, String docType,
			String content) {
		super();
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
