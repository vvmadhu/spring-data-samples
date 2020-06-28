package com.hcl.coe.api.cms.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hcl.coe.api.cms.entity.ContentEntity;
import com.hcl.coe.api.cms.model.Content;

@Component
public class ContentTransformer {
	public List<Content> transform(List<ContentEntity> contentEnitites) {
		List<Content> contentModel = new ArrayList<Content>();
		for (ContentEntity contentEntity : contentEnitites) {
			if (null != contentEntity)
				contentModel.add(new Content(contentEntity.getPlanID(), contentEntity.getIssuer(), contentEntity.getState(),
						contentEntity.getProductType(), contentEntity.getLanguage(), contentEntity.getDocType(),
						contentEntity.getContent()));
		}
		return contentModel;
	}

	public ContentEntity transform(Content content) {
		ContentEntity ContentEntity = new ContentEntity(content.getPlanID(), content.getIssuer(), content.getState(),
				content.getProductType(), content.getLanguage(), content.getDocType(), content.getContent());
		return ContentEntity;
	}
}
