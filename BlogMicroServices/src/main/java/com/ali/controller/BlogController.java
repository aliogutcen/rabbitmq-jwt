package com.ali.controller;

import com.ali.dto.request.CreateBlogText;
import com.ali.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ali.constant.EndPoints.BLOG;
import static com.ali.constant.EndPoints.CREATE;

@RestController
@RequiredArgsConstructor
@RequestMapping(BLOG)
public class BlogController {
    private final BlogService blogService;
    @PostMapping(CREATE)
    public ResponseEntity<?> createBlog(@RequestBody CreateBlogText createBlogText) {
        return ResponseEntity.ok(blogService.createBlog(createBlogText));
    }
}
