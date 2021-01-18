package com.hzn.cr.uam.domain;

import com.hzn.cr.uam.web.rest.TestUtil;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class StaffTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Staff.class);
        Staff staff1 = new Staff();
        staff1.setUid(1);
        Staff staff2 = new Staff();
        staff2.setUid(staff1.getUid());
        assertThat(staff1).isEqualTo(staff2);
        staff2.setUid(2);
        assertThat(staff1).isNotEqualTo(staff2);
        staff1.setUid(null);
        assertThat(staff1).isNotEqualTo(staff2);
    }
}
