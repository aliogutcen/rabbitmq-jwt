package com.ali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBlogText {

    String title;

    String image;

    String content;

    String token;
}
