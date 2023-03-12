package com.ali.repository;

import com.ali.repository.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface IBlogRepository extends JpaRepository<Blogs,Long> {




}
