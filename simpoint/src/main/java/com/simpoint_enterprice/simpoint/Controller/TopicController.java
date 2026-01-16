package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.TopicCategoryResponse;
import com.simpoint_enterprice.simpoint.Model.SubCategory;
import com.simpoint_enterprice.simpoint.Model.TopicCategory;
import com.simpoint_enterprice.simpoint.ServiceInterface.TopicCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
   TopicCategoryService topicCategoryService;

//    @GetMapping
//    public ResponseEntity<List<TopicCategory>> getAllTopicCategories(){
//        return ResponseEntity.ok(topicCategoryService.getAllTopicCategory());
//    }
//
//    // Get category by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<TopicCategory>getTopicCategoryById(@PathVariable Long id){
//        return ResponseEntity.ok(topicCategoryService.getById(id));
//    }
   @GetMapping
    public ResponseEntity<List<TopicCategoryResponse>>getAllTopicCategories(){
       log.info("Get/Topic -Fetch all Topic");
       List<TopicCategoryResponse> topicCategory=topicCategoryService.getAllTopicCategory();
       return ResponseEntity.ok(topicCategory);
   }
   @GetMapping("/{id}")
    public ResponseEntity<TopicCategoryResponse>getTopicCategoryById(@PathVariable Long id){
       log.info("Get/Topic -Fetch topi with id:{}",id);
       TopicCategoryResponse topicCategoryResponse=topicCategoryService.getById(id);
       return ResponseEntity.ok(topicCategoryResponse);

   }
}
