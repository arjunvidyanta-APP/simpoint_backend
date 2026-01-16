package com.simpoint_enterprice.simpoint.Repository;

import com.simpoint_enterprice.simpoint.Model.TopicCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<TopicCategory,Long> {
    Optional<TopicCategory> findByShortCode(String shortCode);
    List<TopicCategory> findAllByShortCodeContainingIgnoreCase(String shortCode);
}
