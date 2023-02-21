package com.metalearning.content.service;

import com.metalearning.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

public interface CourseCategoryService {

    List<CourseCategoryTreeDto>  queryTreeNodes(String id);
}
