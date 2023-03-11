package com.ali.mapper;

import com.ali.dto.request.AuthRegisterRequestDto;
import com.ali.rabbitmq.model.UserCreated;
import com.ali.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {

    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth toAuthRegisterDto(final AuthRegisterRequestDto authRegisterDto);

    @Mapping(source = "id",target = "authid")
    UserCreated toUserCreated(final Auth auth);
}
