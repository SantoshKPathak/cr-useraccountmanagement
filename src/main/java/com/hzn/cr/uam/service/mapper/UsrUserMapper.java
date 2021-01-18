package com.hzn.cr.uam.service.mapper;


import com.hzn.cr.uam.domain.*;
import com.hzn.cr.uam.service.dto.UsrUserDTO;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for the entity {@link UsrUser} and its DTO {@link UsrUserDTO}.
 */
@Mapper(componentModel = "spring", uses = {StaffMapper.class})
public interface UsrUserMapper extends EntityMapper<UsrUserDTO, UsrUser> {

    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);
//    @Mapping(source = "staff.id", target = "staffId")
//    UsrUserDTO toDto(UsrUser usrUser);

//    @Mapping(source = "staffId", target = "staff")
//    UsrUser toEntity(UsrUserDTO usrUserDTO);

    default UsrUser fromUsrUid(Integer usrUid) {
        if (usrUid == null) {
            return null;
        }
        UsrUser usrUser = new UsrUser();
        usrUser.setUsrUid(usrUid);
        return usrUser;
    }
}
