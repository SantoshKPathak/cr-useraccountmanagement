package com.hzn.cr.uam.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Staff.
 */
@Entity
@Table(name = "stf_staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "stf_uid", nullable = false)
    private Integer uid;

    @Column(name = "stf_status")
    private String status;

    @Column(name = "stf_name_key")
    private String nameKey;

    @Column(name = "stf_first_name")
    private String firstName;

    @Column(name = "stf_middle_name")
    private String middleName;

    @Column(name = "stf_last_name")
    private String lastName;

    @Column(name = "stf_usr_uid_created_by")
    private Integer usrUidCreatedBy;

    @Column(name = "stf_create_date")
    private LocalDate createDate;

    @Column(name = "stf_usr_uid_updated_by")
    private Integer usrUidUpdatedBy;

    @Column(name = "stf_last_update_date")
    private LocalDate lastUpdateDate;

//    @OneToMany(mappedBy = "staff")
//    private Set<UsrUser> users = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Integer getUid() {
        return uid;
    }

    public Staff uid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public Staff status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameKey() {
        return nameKey;
    }

    public Staff nameKey(String nameKey) {
        this.nameKey = nameKey;
        return this;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public Staff firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Staff middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Staff lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUsrUidCreatedBy() {
        return usrUidCreatedBy;
    }

    public Staff usrUidCreatedBy(Integer usrUidCreatedBy) {
        this.usrUidCreatedBy = usrUidCreatedBy;
        return this;
    }

    public void setUsrUidCreatedBy(Integer usrUidCreatedBy) {
        this.usrUidCreatedBy = usrUidCreatedBy;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Staff createDate(LocalDate createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Integer getUsrUidUpdatedBy() {
        return usrUidUpdatedBy;
    }

    public Staff usrUidUpdatedBy(Integer usrUidUpdatedBy) {
        this.usrUidUpdatedBy = usrUidUpdatedBy;
        return this;
    }

    public void setUsrUidUpdatedBy(Integer usrUidUpdatedBy) {
        this.usrUidUpdatedBy = usrUidUpdatedBy;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Staff lastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

//    public Set<UsrUser> getUsers() {
//        return users;
//    }
//
//    public Staff users(Set<UsrUser> usrUsers) {
//        this.users = usrUsers;
//        return this;
//    }
//
//    public Staff addUsers(UsrUser usrUser) {
//        this.users.add(usrUser);
//        //usrUser.setStaff(this);
//        return this;
//    }
//
//    public Staff removeUsers(UsrUser usrUser) {
//        this.users.remove(usrUser);
//        //usrUser.setStaff(null);
//        return this;
//    }

//    public void setUsers(Set<UsrUser> usrUsers) {
//        this.users = usrUsers;
//    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        return uid != null && uid.equals(((Staff) o).uid);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Staff{" +
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
