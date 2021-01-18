package com.hzn.cr.uam.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.hzn.cr.uam.domain.Staff} entity.
 */
public class StaffDTO implements Serializable {

    @NotNull
    private Integer uid;

    private String status;

    private String nameKey;

    private String firstName;

    private String middleName;

    private String lastName;

    private Integer usrUidCreatedBy;

    private LocalDate createDate;

    private Integer usrUidUpdatedBy;

    private LocalDate lastUpdateDate;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUsrUidCreatedBy() {
        return usrUidCreatedBy;
    }

    public void setUsrUidCreatedBy(Integer usrUidCreatedBy) {
        this.usrUidCreatedBy = usrUidCreatedBy;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Integer getUsrUidUpdatedBy() {
        return usrUidUpdatedBy;
    }

    public void setUsrUidUpdatedBy(Integer usrUidUpdatedBy) {
        this.usrUidUpdatedBy = usrUidUpdatedBy;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StaffDTO)) {
            return false;
        }

        return uid != null && uid.equals(((StaffDTO) o).uid);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StaffDTO{" +

            ", uid=" + getUid() +
            ", status='" + getStatus() + "'" +
            ", nameKey='" + getNameKey() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", middleName='" + getMiddleName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", usrUidCreatedBy=" + getUsrUidCreatedBy() +
            ", createDate='" + getCreateDate() + "'" +
            ", usrUidUpdatedBy=" + getUsrUidUpdatedBy() +
            ", lastUpdateDate='" + getLastUpdateDate() + "'" +
            "}";
    }
}
