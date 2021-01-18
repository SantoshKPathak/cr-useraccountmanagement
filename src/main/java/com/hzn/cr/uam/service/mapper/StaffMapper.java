package com.hzn.cr.uam.service.mapper;


import com.hzn.cr.uam.domain.*;
import com.hzn.cr.uam.service.dto.StaffDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Staff} and its DTO {@link StaffDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StaffMapper extends EntityMapper<StaffDTO, Staff> {

   // @Mapping(target = "users", ignore = true)
   // @Mapping(target = "removeUsers", ignore = true)
    //Staff toEntity(StaffDTO staffDTO);

    default Staff fromUid(Integer uid) {
        if (uid == null) {
            return null;
        }
        Staff staff = new Staff();
        staff.setUid(uid);
        return staff;
    }
}
