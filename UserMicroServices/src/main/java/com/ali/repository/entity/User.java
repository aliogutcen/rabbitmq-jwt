package com.ali.repository.entity;

import com.ali.repository.enums.ERole;
import com.ali.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long authid;
    @Column(unique = true)
    String username;
    @Column(unique = true)
    String mail;
    @Enumerated(EnumType.STRING)
    ERole erole;
    @Enumerated(EnumType.STRING)
    EStatus estatus;

    String age;

    String location;

    String aboutme;


}
