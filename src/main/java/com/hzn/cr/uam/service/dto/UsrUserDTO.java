package com.hzn.cr.uam.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.hzn.cr.uam.domain.UsrUser} entity.
 */
public class UsrUserDTO implements Serializable {

    //@NotNull
    private Integer usrUid;

    private Integer usrStfUid;

    @Size(max = 32)
    private String usrId;

    @Size(max = 1)
    private String usrAccountStatus;

    private LocalDate usrDateAccountExpiration;

    @Size(max = 1)
    private String usrAccountLockedYN;

    @Size(max = 1)
    private String usrRecordStatus;

    private LocalDate usrDatePasswordExpiration;

    @Size(max = 1)
    private String usrUserType;

    private LocalDate usrRecordStatusDate;

    private LocalDate usrCreateDate;

    private Integer usrUsrUidCreatedBy;

    private Integer usrUsrUidUpdatedBy;

    private LocalDate usrLastUpdateDate;


    public Integer getUsrUid() {
        return usrUid;
    }

    public void setUsrUid(Integer usrUid) {
        this.usrUid = usrUid;
    }

    public Integer getUsrStfUid() {
        return usrStfUid;
    }

    public void setUsrStfUid(Integer usrStfUid) {
        this.usrStfUid = usrStfUid;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrAccountStatus() {
        return usrAccountStatus;
    }

    public void setUsrAccountStatus(String usrAccountStatus) {
        this.usrAccountStatus = usrAccountStatus;
    }

    public LocalDate getUsrDateAccountExpiration() {
        return usrDateAccountExpiration;
    }

    public void setUsrDateAccountExpiration(LocalDate usrDateAccountExpiration) {
        this.usrDateAccountExpiration = usrDateAccountExpiration;
    }

    public String getUsrAccountLockedYN() {
        return usrAccountLockedYN;
    }

    public void setUsrAccountLockedYN(String usrAccountLockedYN) {
        this.usrAccountLockedYN = usrAccountLockedYN;
    }

    public String getUsrRecordStatus() {
        return usrRecordStatus;
    }

    public void setUsrRecordStatus(String usrRecordStatus) {
        this.usrRecordStatus = usrRecordStatus;
    }

    public LocalDate getUsrDatePasswordExpiration() {
        return usrDatePasswordExpiration;
    }

    public void setUsrDatePasswordExpiration(LocalDate usrDatePasswordExpiration) {
        this.usrDatePasswordExpiration = usrDatePasswordExpiration;
    }

    public String getUsrUserType() {
        return usrUserType;
    }

    public void setUsrUserType(String usrUserType) {
        this.usrUserType = usrUserType;
    }

    public LocalDate getUsrRecordStatusDate() {
        return usrRecordStatusDate;
    }

    public void setUsrRecordStatusDate(LocalDate usrRecordStatusDate) {
        this.usrRecordStatusDate = usrRecordStatusDate;
    }

    public LocalDate getUsrCreateDate() {
        return usrCreateDate;
    }

    public void setUsrCreateDate(LocalDate usrCreateDate) {
        this.usrCreateDate = usrCreateDate;
    }

    public Integer getUsrUsrUidCreatedBy() {
        return usrUsrUidCreatedBy;
    }

    public void setUsrUsrUidCreatedBy(Integer usrUsrUidCreatedBy) {
        this.usrUsrUidCreatedBy = usrUsrUidCreatedBy;
    }

    public Integer getUsrUsrUidUpdatedBy() {
        return usrUsrUidUpdatedBy;
    }

    public void setUsrUsrUidUpdatedBy(Integer usrUsrUidUpdatedBy) {
        this.usrUsrUidUpdatedBy = usrUsrUidUpdatedBy;
    }

    public LocalDate getUsrLastUpdateDate() {
        return usrLastUpdateDate;
    }

    public void setUsrLastUpdateDate(LocalDate usrLastUpdateDate) {
        this.usrLastUpdateDate = usrLastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsrUserDTO)) {
            return false;
        }

        return usrUid != null && usrUid.equals(((UsrUserDTO) o).usrUid);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UsrUserDTO{" +
            " usrUid=" + getUsrUid() +
            ", usrStfUid=" + getUsrStfUid() +
            ", usrId='" + getUsrId() + "'" +
            ", usrAccountStatus='" + getUsrAccountStatus() + "'" +
            ", usrDateAccountExpiration='" + getUsrDateAccountExpiration() + "'" +
            ", usrAccountLockedYN='" + getUsrAccountLockedYN() + "'" +
            ", usrRecordStatus='" + getUsrRecordStatus() + "'" +
            ", usrDatePasswordExpiration='" + getUsrDatePasswordExpiration() + "'" +
            ", usrUserType='" + getUsrUserType() + "'" +
            ", usrRecordStatusDate='" + getUsrRecordStatusDate() + "'" +
            ", usrCreateDate='" + getUsrCreateDate() + "'" +
            ", usrUsrUidCreatedBy=" + getUsrUsrUidCreatedBy() +
            ", usrUsrUidUpdatedBy=" + getUsrUsrUidUpdatedBy() +
            ", usrLastUpdateDate='" + getUsrLastUpdateDate() +
            "}";
    }
}
