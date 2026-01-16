package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.SubcategoryResponse;
import com.simpoint_enterprice.simpoint.Dto.TopicCategoryResponse;
import com.simpoint_enterprice.simpoint.Model.SubCategory;
import com.simpoint_enterprice.simpoint.Model.TopicCategory;
import com.simpoint_enterprice.simpoint.Repository.SubcategoryRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.SubCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class subcategoryServiceImpl implements SubCategoryService {


    @Autowired
    SubcategoryRepository subcategoryRepository;


    // Topic Mapper
    // =======================
    private TopicCategoryResponse mapToTopic(TopicCategory topic) {

        TopicCategoryResponse response = new TopicCategoryResponse();
        response.setId(topic.getId());
        response.setTopicName(topic.getTopicName());
        response.setTopicDescription(topic.getTopicDescription());
        response.setShortCode(topic.getShortCode());
        // map subcategory name
        if (topic.getSubCategory() != null) {
            response.setSubCategoryName(
                    topic.getSubCategory().getSubcategoryName()
            );

            // map category name
            if (topic.getSubCategory().getCategory() != null) {
                response.setCategoryName(
                        topic.getSubCategory().getCategory().getCategoryName()
                );
            }
        }

        return response;
    }
//  subcategory Mapper
   private SubcategoryResponse mapToResponse(SubCategory subCategory){
        SubcategoryResponse subcategoryResponse=new SubcategoryResponse();
        subcategoryResponse.setId(subCategory.getId());
        subcategoryResponse.setSubcategoryName(subCategory.getSubcategoryName());
        subcategoryResponse.setSubcategoryDescription(subCategory.getSubcategoryDescription());
      // map name of category
        if(subCategory.getCategory()!=null){
            subcategoryResponse.setCategoryName(subCategory.getCategory().getCategoryName());
        }
        // map list of topic category
       if(subCategory.getTopicCategories()!=null){
           List<TopicCategoryResponse>list=subCategory.getTopicCategories()
                   .stream().map(this::mapToTopic).collect(Collectors.toList());
           subcategoryResponse.setTopicCategories(list);

       }else{
           subcategoryResponse.setTopicCategories(List.of());
       }
        return subcategoryResponse;
//       return new SubcategoryResponse(
//               subCategory.getId(),
//               subCategory.getSubcategoryName(),
//               subCategory.getSubcategoryDescription()
//       );

   }

    @Override
    public List<SubcategoryResponse> getAllSubcategories() {
       log.info("Fetching all categories from DB");
        List<SubCategory> subCategories=subcategoryRepository.findAllWithTopics();
        log.info("Total subcategory found:{}",subCategories.size());
        return  subCategories.stream()
                .map(this::mapToResponse)
                .collect(toList());
    }

    @Override
    public SubcategoryResponse getCategoryById(Long id) {
       log.info("Fetching categories by id:{}",id);
       SubCategory subCategory=subcategoryRepository.findById(id)
               .orElseThrow(()->{
                   log.error("Subcategory not found with id: {}", id);
                   return new RuntimeException(
                           "Subcategory not found with id: " + id
                   );
               });
       log.info("subcategory found with subcategory:{}",id);
        return mapToResponse(subCategory);
    }

//    @Override
//    public List<SubCategory> getAllSubCategories() {
//        return subcategoryRepository.findAll();
//    }
//
//    @Override
//    public SubCategory getCategoryById(Long id) {
//
//        return subcategoryRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No categories found with category id: " + id));
//    }
}
