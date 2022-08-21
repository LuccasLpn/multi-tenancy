package com.multitenancy.modules.users.mapper;

import com.multitenancy.modules.users.dto.UserPost;
import com.multitenancy.modules.users.dto.UserPut;
import com.multitenancy.modules.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(source = "customerId", target = "customer.id")
    public abstract User toUser(UserPost userPost);

    @Mapping(source = "customerId", target = "customer.id")
    public abstract User toUser(UserPut userPut);
}
