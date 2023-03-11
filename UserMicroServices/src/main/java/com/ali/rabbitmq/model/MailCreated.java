package com.ali.rabbitmq.model;

import com.ali.repository.enums.EStatus;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MailCreated implements Serializable {

    Long userid;

    EStatus estatus;

    String mail;
}
