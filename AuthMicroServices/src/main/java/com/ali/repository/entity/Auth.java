package com.ali.repository.entity;

import com.ali.repository.enums.ERole;
import com.ali.repository.enums.EStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Auth extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String username;
    String password;
    @Column(unique = true)
    String mail;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    EStatus estatus=EStatus.PENDING;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    ERole erole=ERole.USER;


}
