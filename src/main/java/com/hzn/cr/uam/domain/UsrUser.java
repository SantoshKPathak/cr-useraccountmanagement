package com.hzn.cr.uam.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A UsrUser.
 */
@Entity
@Table(name = "usr_user")
public class UsrUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "usr_uid", nullable = false)
    private Integer usrUid;

    @Column(name = "usr_stf_uid")
    private Integer usrStfUid;

    @Size(max = 32)
    @Column(name = "usr_id", length = 32)
    private String usrId;

    @Size(max = 1)
    @Column(name = "usr_account_status", length = 1)
    private String usrAccountStatus;

    @Column(name = "usr_date_account_expiration")
    private LocalDate usrDateAccountExpiration;

    @Size(max = 1)
    @Column(name = "usr_account_locked_yn", length = 1)
    private String usrAccountLockedYN;

    @Size(max = 1)
    @Column(name = "usr_record_status", length = 1)
    private String usrRecordStatus;

    @Column(name = "usr_date_password_expiration")
    private LocalDate usrDatePasswordExpiration;

    @Size(max = 1)
    @Column(name = "usr_user_type", length = 1)
    private String usrUserType;

    @Column(name = "usr_record_status_date")
    private LocalDate usrRecordStatusDate;

    @Column(name = "usr_create_date")
    private LocalDate usrCreateDate;

    @Column(name = "usr_usr_uid_created_by")
    private Integer usrUsrUidCreatedBy;

    @Column(name = "usr_usr_uid_updated_by")
    private Integer usrUsrUidUpdatedBy;

    @Column(name = "usr_last_update_date")
    private LocalDate usrLastUpdateDate;

//    @ManyToOne
//    @JsonIgnoreProperties(value = "users", allowSetters = true)
//    @JoinColumn(referencedColumnName = "stf_uid")
//    private Staff staff;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getUsrUid() {
        return usrUid;
    }

    public UsrUser usrUid(Integer usrUid) {
        this.usrUid = usrUid;
        return this;
    }

    public void setUsrUid(Integer usrUid) {
        this.usrUid = usrUid;
    }

    public Integer getUsrStfUid() {
        return usrStfUid;
    }

    public UsrUser usrStfUid(Integer usrStfUid) {
        this.usrStfUid = usrStfUid;
        return this;
    }

    public void setUsrStfUid(Integer usrStfUid) {
        this.usrStfUid = usrStfUid;
    }

    public String getUsrId() {
        return usrId;
    }

    public UsrUser usrId(String usrId) {
        this.usrId = usrId;
        return this;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrAccountStatus() {
        return usrAccountStatus;
    }

    public UsrUser usrAccountStatus(String usrAccountStatus) {
        this.usrAccountStatus = usrAccountStatus;
        return this;
    }

    public void setUsrAccountStatus(String usrAccountStatus) {
        this.usrAccountStatus = usrAccountStatus;
    }

    public LocalDate getUsrDateAccountExpiration() {
        return usrDateAccountExpiration;
    }

    public UsrUser usrDateAccountExpiration(LocalDate usrDateAccountExpiration) {
        this.usrDateAccountExpiration = usrDateAccountExpiration;
        return this;
    }

    public void setUsrDateAccountExpiration(LocalDate usrDateAccountExpiration) {
        this.usrDateAccountExpiration = usrDateAccountExpiration;
    }

    public String getUsrAccountLockedYN() {
        return usrAccountLockedYN;
    }

    public UsrUser usrAccountLockedYN(String usrAccountLockedYN) {
        this.usrAccountLockedYN = usrAccountLockedYN;
        return this;
    }

    public void setUsrAccountLockedYN(String usrAccountLockedYN) {
        this.usrAccountLockedYN = usrAccountLockedYN;
    }

    public String getUsrRecordStatus() {
        return usrRecordStatus;
    }

    public UsrUser usrRecordStatus(String usrRecordStatus) {
        this.usrRecordStatus = usrRecordStatus;
        return this;
    }

    public void setUsrRecordStatus(String usrRecordStatus) {
        this.usrRecordStatus = usrRecordStatus;
    }

    public LocalDate getUsrDatePasswordExpiration() {
        return usrDatePasswordExpiration;
    }

    public UsrUser usrDatePasswordExpiration(LocalDate usrDatePasswordExpiration) {
        this.usrDatePasswordExpiration = usrDatePasswordExpiration;
        return this;
    }

    public void setUsrDatePasswordExpiration(LocalDate usrDatePasswordExpiration) {
        this.usrDatePasswordExpiration = usrDatePasswordExpiration;
    }

    public String getUsrUserType() {
        return usrUserType;
    }

    public UsrUser usrUserType(String usrUserType) {
        this.usrUserType = usrUserType;
        return this;
    }

    public void setUsrUserType(String usrUserType) {
        this.usrUserType = usrUserType;
    }

    public LocalDate getUsrRecordStatusDate() {
        return usrRecordStatusDate;
    }

    public UsrUser usrRecordStatusDate(LocalDate usrRecordStatusDate) {
        this.usrRecordStatusDate = usrRecordStatusDate;
        return this;
    }

    public void setUsrRecordStatusDate(LocalDate usrRecordStatusDate) {
        this.usrRecordStatusDate = usrRecordStatusDate;
    }

    public LocalDate getUsrCreateDate() {
        return usrCreateDate;
    }

    public UsrUser usrCreateDate(LocalDate usrCreateDate) {
        this.usrCreateDate = usrCreateDate;
        return this;
    }

    public void setUsrCreateDate(LocalDate usrCreateDate) {
        this.usrCreateDate = usrCreateDate;
    }

    public Integer getUsrUsrUidCreatedBy() {
        return usrUsrUidCreatedBy;
    }

    public UsrUser usrUsrUidCreatedBy(Integer usrUsrUidCreatedBy) {
        this.usrUsrUidCreatedBy = usrUsrUidCreatedBy;
        return this;
    }

    public void setUsrUsrUidCreatedBy(Integer usrUsrUidCreatedBy) {
        this.usrUsrUidCreatedBy = usrUsrUidCreatedBy;
    }

    public Integer getUsrUsrUidUpdatedBy() {
        return usrUsrUidUpdatedBy;
    }

    public UsrUser usrUsrUidUpdatedBy(Integer usrUsrUidUpdatedBy) {
        this.usrUsrUidUpdatedBy = usrUsrUidUpdatedBy;
        return this;
    }

    public void setUsrUsrUidUpdatedBy(Integer usrUsrUidUpdatedBy) {
        this.usrUsrUidUpdatedBy = usrUsrUidUpdatedBy;
    }

    public LocalDate getUsrLastUpdateDate() {
        return usrLastUpdateDate;
    }

    public UsrUser usrLastUpdateDate(LocalDate usrLastUpdateDate) {
        this.usrLastUpdateDate = usrLastUpdateDate;
        return this;
    }

    public void setUsrLastUpdateDate(LocalDate usrLastUpdateDate) {
        this.usrLastUpdateDate = usrLastUpdateDate;
    }

//    public Staff getStaff() {
//        return staff;
//    }
//
//    public UsrUser staff(Staff staff) {
//        this.staff = staff;
//        return this;
//    }

//    public void setStaff(Staff staff) {
//        this.staff = staff;
//    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsrUser)) {
            return false;
        }
        return usrUid != null && usrUid.equals(((UsrUser) o).usrUid);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UsrUser{" +
            ", usrUid=" + getUsrUid() +
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
            ", usrLastUpdateDate='" + getUsrLastUpdateDate() + "'" +
            "}";
    }
}
