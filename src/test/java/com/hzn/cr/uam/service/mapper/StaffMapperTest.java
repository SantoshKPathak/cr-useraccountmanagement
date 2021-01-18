package com.hzn.cr.uam.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StaffMapperTest {

    private StaffMapper staffMapper;

    @BeforeEach
    public void setUp() {
        staffMapper = new StaffMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Integer id = 1;
        assertThat(staffMapper.fromUid(id).getUid()).isEqualTo(id);
        assertThat(staffMapper.fromUid(null)).isNull();
    }
}
