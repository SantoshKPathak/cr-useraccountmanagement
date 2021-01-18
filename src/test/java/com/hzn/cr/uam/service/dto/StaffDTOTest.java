package com.hzn.cr.uam.service.dto;

import com.hzn.cr.uam.web.rest.TestUtil;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class StaffDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StaffDTO.class);
        StaffDTO staffDTO1 = new StaffDTO();
        staffDTO1.setUid(1);
        StaffDTO staffDTO2 = new StaffDTO();
        assertThat(staffDTO1).isNotEqualTo(staffDTO2);
        staffDTO2.setUid(staffDTO1.getUid());
        assertThat(staffDTO1).isEqualTo(staffDTO2);
        staffDTO2.setUid(2);
        assertThat(staffDTO1).isNotEqualTo(staffDTO2);
        staffDTO1.setUid(null);
        assertThat(staffDTO1).isNotEqualTo(staffDTO2);
    }
}
