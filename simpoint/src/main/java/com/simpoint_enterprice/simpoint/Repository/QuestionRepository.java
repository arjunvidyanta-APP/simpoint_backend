package com.simpoint_enterprice.simpoint.Repository;

import com.simpoint_enterprice.simpoint.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
