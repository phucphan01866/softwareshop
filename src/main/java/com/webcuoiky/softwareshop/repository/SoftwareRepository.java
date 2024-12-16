package com.webcuoiky.softwareshop.repository;

import com.webcuoiky.softwareshop.model.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoftwareRepository extends JpaRepository<Software, Integer> {
    List<Software> findByCategory(String category);

}
