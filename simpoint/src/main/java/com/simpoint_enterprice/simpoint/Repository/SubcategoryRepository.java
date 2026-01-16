package com.simpoint_enterprice.simpoint.Repository;

import com.simpoint_enterprice.simpoint.Model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<SubCategory,Long> {
    @Query("SELECT DISTINCT s FROM SubCategory s LEFT JOIN FETCH s.topicCategories")
    List<SubCategory> findAllWithTopics();
}
