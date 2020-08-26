package com.deltadental.coe.api.cms.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.deltadental.coe.api.cms.model.Content;

@Component
public class ContentTransformer {
	public List<Content> transformMySql(List<com.deltadental.coe.api.cms.mysql.entity.ContentEntity> contentEnitites) {
		List<Content> contentModel = new ArrayList<Content>();
		for (com.deltadental.coe.api.cms.mysql.entity.ContentEntity contentEntity : contentEnitites) {
			contentModel.add(new Content(contentEntity.getPlanID(), contentEntity.getIssuer(), contentEntity.getState(),
					contentEntity.getProductType(), contentEntity.getLanguage(), contentEntity.getDocType(),
					contentEntity.getContent()));
		}
		return contentModel;
	}
	
	public List<Content> transformSqlServer(List<com.deltadental.coe.api.cms.sqlserver.entity.ContentEntity> contentEnitites) {
		List<Content> contentModel = new ArrayList<Content>();
		for (com.deltadental.coe.api.cms.sqlserver.entity.ContentEntity contentEntity : contentEnitites) {
			contentModel.add(new Content(contentEntity.getPlanID(), contentEntity.getIssuer(), contentEntity.getState(),
					contentEntity.getProductType(), contentEntity.getLanguage(), contentEntity.getDocType(),
					contentEntity.getContent()));
		}
		return contentModel;
	}

	public com.deltadental.coe.api.cms.mysql.entity.ContentEntity transform(Content content) {
		com.deltadental.coe.api.cms.mysql.entity.ContentEntity ContentEntity = new com.deltadental.coe.api.cms.mysql.entity.ContentEntity(content.getPlanID(), content.getIssuer(), content.getState(),
				content.getProductType(), content.getLanguage(), content.getDocType(), content.getContent());
		return ContentEntity;
	}
}
