package com.ali.mapper;

import com.ali.dto.request.CreateBlogText;
import com.ali.repository.entity.Blogs;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBlogMapper {

    IBlogMapper INSTANCE = Mappers.getMapper(IBlogMapper.class);

    Blogs toBlogs(final CreateBlogText createBlogText);
}
