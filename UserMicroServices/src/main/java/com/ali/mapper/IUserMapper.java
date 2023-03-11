package com.ali.mapper;

import com.ali.rabbitmq.model.AuthStatusSettings;
import com.ali.rabbitmq.model.MailCreated;
import com.ali.rabbitmq.model.StatusAfterActivateCode;
import com.ali.rabbitmq.model.UserCreated;
import com.ali.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(final UserCreated userCreated);

    @Mapping(source = "id", target = "userid")
    MailCreated toMailCreated(final User user);

    AuthStatusSettings toAuthStatusSettings(final User user);


}
