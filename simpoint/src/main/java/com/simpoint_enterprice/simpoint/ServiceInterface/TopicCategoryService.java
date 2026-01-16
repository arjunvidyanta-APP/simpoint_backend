package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.TopicCategoryResponse;
import com.simpoint_enterprice.simpoint.Model.TopicCategory;

import java.util.List;

public interface TopicCategoryService {
//    List<TopicCategory> getAllTopicCategory();
//
//    TopicCategory getById(Long id);
    List<TopicCategoryResponse>getAllTopicCategory();
    TopicCategoryResponse getById(Long id);
}
