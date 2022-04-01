package com.mylearning.spring.data.jpa.learning.repository;

import com.mylearning.spring.data.jpa.learning.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
