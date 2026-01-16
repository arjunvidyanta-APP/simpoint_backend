package com.simpoint_enterprice.simpoint.Repository;

import com.simpoint_enterprice.simpoint.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("""
    SELECT c FROM Course c
    LEFT JOIN FETCH c.topicCategory tc
    LEFT JOIN FETCH tc.subCategory sc
    LEFT JOIN FETCH sc.category cat
    LEFT JOIN FETCH c.createdBy
    LEFT JOIN FETCH c.lastEditedBy
""")
    List<Course> findAllWithRelations();
    /**
     * Fetch single course with modules (detail page)
     */
    @Query("""
        SELECT DISTINCT c FROM Course c
        LEFT JOIN FETCH c.modules m
        WHERE c.id = :courseId
        ORDER BY m.menuOrder
    """)
    Optional<Course> findByIdWithModules(Long courseId);


}
