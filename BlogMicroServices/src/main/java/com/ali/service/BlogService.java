package com.ali.service;

import com.ali.dto.request.CreateBlogText;
import com.ali.mapper.IBlogMapper;
import com.ali.repository.IBlogRepository;
import com.ali.repository.entity.Blogs;
import com.ali.utility.JwtTokenGenerator;
import com.ali.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class BlogService extends ServiceManager<Blogs, Long> {

    private final IBlogRepository blogRepository;
    private final JwtTokenGenerator jwtTokenGenerator;

    public BlogService(IBlogRepository blogRepository, JwtTokenGenerator jwtTokenGenerator) {
        super(blogRepository);
        this.blogRepository = blogRepository;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }


    public Boolean createBlog(CreateBlogText createBlogText) {
        Blogs blogs = IBlogMapper.INSTANCE.toBlogs(createBlogText);
        blogs.setUserid(jwtTokenGenerator.decodeToken(createBlogText.getToken()));
        save(blogs);
        return true;
    }
}
