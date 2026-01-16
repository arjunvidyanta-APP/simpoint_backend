package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.TopicCategoryResponse;
import com.simpoint_enterprice.simpoint.Model.TopicCategory;
import com.simpoint_enterprice.simpoint.Repository.TopicRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.TopicCategoryService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TopicCategoryServiceImpl implements TopicCategoryService {

    @Autowired
    TopicRepository topicRepository;

    // mapper
    private TopicCategoryResponse MaptoTopic(TopicCategory topicCategory){
        TopicCategoryResponse response = new TopicCategoryResponse();

        response.setId(topicCategory.getId());
        response.setTopicName(topicCategory.getTopicName());
        response.setTopicDescription(topicCategory.getTopicDescription());
        response.setShortCode(topicCategory.getShortCode());

        // map subcategory name
        if (topicCategory.getSubCategory() != null) {
            response.setSubCategoryName(
                    topicCategory.getSubCategory().getSubcategoryName()
            );

            // map category name
            if (topicCategory.getSubCategory().getCategory() != null) {
                response.setCategoryName(
                        topicCategory.getSubCategory().getCategory().getCategoryName()
                );
            }
        }

        return response;
    }

    @Override
    public List<TopicCategoryResponse> getAllTopicCategory() {
        log.info("Fetch all Topic category");
         List<TopicCategory>topics=topicRepository.findAll();
         log.info("Total topic found:{}",topics.size());
        return topics.stream().map(this::MaptoTopic)
                .toList();
    }

    @Override
    public TopicCategoryResponse getById(Long id) {
        log.info("Fetch topic by id: {}",id);
        TopicCategory topicCategory=topicRepository.findById(id)
                .orElseThrow(()->{
                    log.error("Topic Category not found with id: {}",id);
                    return new ResourceNotFoundException(
                            "Topic not found with id:" +id

                    );
                });
        log.info("topic found with id:{}",id);

        return MaptoTopic(topicCategory);
    }

//    @Override
//    public List<TopicCategory> getAllTopicCategory() {
//        return topicRepository.findAll();
//    }
//
//    @Override
//    public TopicCategory getById(Long id) {
//        return topicRepository.getById(id);
//    }
}
