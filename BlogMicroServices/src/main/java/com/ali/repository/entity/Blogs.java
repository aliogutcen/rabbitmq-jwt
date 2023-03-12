package com.ali.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "blogs")
public class Blogs extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userid;
    String title;
    String image;
    @Builder.Default
    LocalDate createTime= LocalDate.now();
    @Column(length = 2048)
    String content;


}
