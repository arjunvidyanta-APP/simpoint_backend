package com.simpoint_enterprice.simpoint.Repository;


import com.simpoint_enterprice.simpoint.Model.ModuleContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleContentRepository extends JpaRepository<ModuleContent,Long>{
    /**
     * Fetch all LESSON contents of a module in correct order
     */
    @Query("""
        SELECT mc FROM ModuleContent mc
        JOIN FETCH mc.lesson
        WHERE mc.module.id = :moduleId
        AND mc.contentType = 'lesson'
        ORDER BY mc.menuOrder
    """)
    List<ModuleContent> findLessonsByModuleId(@Param("moduleId") Long moduleId);
}
