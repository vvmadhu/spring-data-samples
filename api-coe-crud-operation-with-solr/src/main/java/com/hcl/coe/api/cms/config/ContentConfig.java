package com.hcl.coe.api.cms.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = "com.hcl.coe.api.cms.repository")
public class ContentConfig {

	@Value("${cms.solr.url}")
	private String cmsUrl;

	@Value("${cms.solr.collection.name}")
	private String cmsCollectionName;
	
	public String getCmsUrl() {
		return cmsUrl;
	}

	public void setCmsUrl(String cmsUrl) {
		this.cmsUrl = cmsUrl;
	}

	public String getCmsCollectionName() {
		return cmsCollectionName;
	}

	public void setCmsCollectionName(String cmsCollectionName) {
		this.cmsCollectionName = cmsCollectionName;
	}
	
	@Bean(name="solrClient")
	public SolrClient solrClient() {
		SolrClient solrClient = new HttpSolrClient(cmsUrl+"/"+cmsCollectionName);
		return solrClient;
	}

	@Bean
	@Autowired
	public SolrTemplate solrTemplate(SolrClient solrClient) {
		return new SolrTemplate(solrClient);
	}
	
}