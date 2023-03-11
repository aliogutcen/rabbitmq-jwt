package com.ali.mapper;

import com.ali.dto.request.ActivatedCode;
import com.ali.rabbitmq.model.MailCreated;
import com.ali.rabbitmq.model.StatusAfterActivateCode;
import com.ali.repository.entity.Mail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMailMapper {

    IMailMapper INSTANCE = Mappers.getMapper(IMailMapper.class);

    Mail toMail(final MailCreated mailCreated);

    Mail toActivatedMail(final ActivatedCode activatedCode);

    StatusAfterActivateCode toStatusAfterActivateCode(final Mail mail);
}
