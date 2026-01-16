package com.simpoint_enterprice.simpoint.Repository;

import com.simpoint_enterprice.simpoint.Model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AssessmentRepository extends JpaRepository<Assessment,Long>{
    @Query("""
    SELECT DISTINCT a FROM Assessment a
    LEFT JOIN FETCH a.questionLinks ql
    LEFT JOIN FETCH ql.question q
    WHERE a.assessmentId = :assessmentId
""")
    Optional<Assessment> findAssessmentWithQuestions(Long assessmentId);

}
