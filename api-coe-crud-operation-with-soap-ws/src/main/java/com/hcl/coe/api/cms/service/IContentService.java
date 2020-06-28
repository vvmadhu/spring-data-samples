package com.hcl.coe.api.cms.service;

import com.hcl.coe.api.cms.model.AddContentRequest;
import com.hcl.coe.api.cms.model.AddContentResponse;
import com.hcl.coe.api.cms.model.DeleteContentRequest;
import com.hcl.coe.api.cms.model.DeleteContentResponse;
import com.hcl.coe.api.cms.model.GetContentByPlanIdRequest;
import com.hcl.coe.api.cms.model.GetContentByPlanIdResponse;
import com.hcl.coe.api.cms.model.UpdateContentRequest;
import com.hcl.coe.api.cms.model.UpdateContentResponse;

public interface IContentService {
	GetContentByPlanIdResponse getContentByPlanId(GetContentByPlanIdRequest request);
    AddContentResponse addContent(AddContentRequest request);
    UpdateContentResponse updateContent(UpdateContentRequest request);
    DeleteContentResponse deleteContent(DeleteContentRequest request);
}
