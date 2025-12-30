package com.simpoint_enterprice.simpoint.Repository;

import com.simpoint_enterprice.simpoint.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
