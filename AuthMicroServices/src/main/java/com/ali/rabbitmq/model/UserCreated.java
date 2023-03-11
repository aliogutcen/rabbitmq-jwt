package com.ali.rabbitmq.model;

import com.ali.repository.enums.ERole;
import com.ali.repository.enums.EStatus;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreated implements Serializable {

    Long authid;

    String username;

    String mail;

    EStatus estatus;

    ERole erole;
}
