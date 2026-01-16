package com.simpoint_enterprice.simpoint.Repository;

import com.simpoint_enterprice.simpoint.Model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Modules,Long> {

    List<Modules> findByCourseIdOrderByMenuOrderAsc(Long courseId);
}
