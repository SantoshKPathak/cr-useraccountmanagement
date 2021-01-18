package com.hzn.cr.uam.web.rest;

import com.hzn.cr.uam.UserAccountManagementApp;
import com.hzn.cr.uam.domain.UsrUser;
import com.hzn.cr.uam.repository.UsrUserRepository;
import com.hzn.cr.uam.service.UsrUserService;
import com.hzn.cr.uam.service.dto.UsrUserDTO;
import com.hzn.cr.uam.service.mapper.UsrUserMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link UsrUserResource} REST controller.
 */
@SpringBootTest(classes = UserAccountManagementApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class UsrUserResourceIT {

    private static final Integer DEFAULT_USR_UID = 1;
    private static final Integer UPDATED_USR_UID = 2;

    private static final Integer DEFAULT_USR_STF_UID = 1;
    private static final Integer UPDATED_USR_STF_UID = 2;

    private static final String DEFAULT_USR_ID = "AAAAAAAAAA";
    private static final String UPDATED_USR_ID = "BBBBBBBBBB";

    private static final String DEFAULT_USR_ACCOUNT_STATUS = "A";
    private static final String UPDATED_USR_ACCOUNT_STATUS = "B";

    private static final LocalDate DEFAULT_USR_DATE_ACCOUNT_EXPIRATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_USR_DATE_ACCOUNT_EXPIRATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_USR_ACCOUNT_LOCKED_YN = "A";
    private static final String UPDATED_USR_ACCOUNT_LOCKED_YN = "B";

    private static final String DEFAULT_USR_RECORD_STATUS = "A";
    private static final String UPDATED_USR_RECORD_STATUS = "B";

    private static final LocalDate DEFAULT_USR_DATE_PASSWORD_EXPIRATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_USR_DATE_PASSWORD_EXPIRATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_USR_USER_TYPE = "A";
    private static final String UPDATED_USR_USER_TYPE = "B";

    private static final LocalDate DEFAULT_USR_RECORD_STATUS_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_USR_RECORD_STATUS_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_USR_CREATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_USR_CREATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_USR_USR_UID_CREATED_BY = 1;
    private static final Integer UPDATED_USR_USR_UID_CREATED_BY = 2;

    private static final Integer DEFAULT_USR_USR_UID_UPDATED_BY = 1;
    private static final Integer UPDATED_USR_USR_UID_UPDATED_BY = 2;

    private static final LocalDate DEFAULT_USR_LAST_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_USR_LAST_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private UsrUserRepository usrUserRepository;

    @Autowired
    private UsrUserMapper usrUserMapper;

    @Autowired
    private UsrUserService usrUserService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUsrUserMockMvc;

    private UsrUser usrUser;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UsrUser createEntity(EntityManager em) {
        UsrUser usrUser = new UsrUser()
            .usrUid(DEFAULT_USR_UID)
            .usrStfUid(DEFAULT_USR_STF_UID)
            .usrId(DEFAULT_USR_ID)
            .usrAccountStatus(DEFAULT_USR_ACCOUNT_STATUS)
            .usrDateAccountExpiration(DEFAULT_USR_DATE_ACCOUNT_EXPIRATION)
            .usrAccountLockedYN(DEFAULT_USR_ACCOUNT_LOCKED_YN)
            .usrRecordStatus(DEFAULT_USR_RECORD_STATUS)
            .usrDatePasswordExpiration(DEFAULT_USR_DATE_PASSWORD_EXPIRATION)
            .usrUserType(DEFAULT_USR_USER_TYPE)
            .usrRecordStatusDate(DEFAULT_USR_RECORD_STATUS_DATE)
            .usrCreateDate(DEFAULT_USR_CREATE_DATE)
            .usrUsrUidCreatedBy(DEFAULT_USR_USR_UID_CREATED_BY)
            .usrUsrUidUpdatedBy(DEFAULT_USR_USR_UID_UPDATED_BY)
            .usrLastUpdateDate(DEFAULT_USR_LAST_UPDATE_DATE);
        return usrUser;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UsrUser createUpdatedEntity(EntityManager em) {
        UsrUser usrUser = new UsrUser()
            .usrUid(UPDATED_USR_UID)
            .usrStfUid(UPDATED_USR_STF_UID)
            .usrId(UPDATED_USR_ID)
            .usrAccountStatus(UPDATED_USR_ACCOUNT_STATUS)
            .usrDateAccountExpiration(UPDATED_USR_DATE_ACCOUNT_EXPIRATION)
            .usrAccountLockedYN(UPDATED_USR_ACCOUNT_LOCKED_YN)
            .usrRecordStatus(UPDATED_USR_RECORD_STATUS)
            .usrDatePasswordExpiration(UPDATED_USR_DATE_PASSWORD_EXPIRATION)
            .usrUserType(UPDATED_USR_USER_TYPE)
            .usrRecordStatusDate(UPDATED_USR_RECORD_STATUS_DATE)
            .usrCreateDate(UPDATED_USR_CREATE_DATE)
            .usrUsrUidCreatedBy(UPDATED_USR_USR_UID_CREATED_BY)
            .usrUsrUidUpdatedBy(UPDATED_USR_USR_UID_UPDATED_BY)
            .usrLastUpdateDate(UPDATED_USR_LAST_UPDATE_DATE);
        return usrUser;
    }

    @BeforeEach
    public void initTest() {
        usrUser = createEntity(em);
    }

    @Test
    @Transactional
    public void createUsrUser() throws Exception {
        int databaseSizeBeforeCreate = usrUserRepository.findAll().size();
        // Create the UsrUser
        UsrUserDTO usrUserDTO = usrUserMapper.toDto(usrUser);
        restUsrUserMockMvc.perform(post("/api/usr-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(usrUserDTO)))
            .andExpect(status().isCreated());

        // Validate the UsrUser in the database
        List<UsrUser> usrUserList = usrUserRepository.findAll();
        assertThat(usrUserList).hasSize(databaseSizeBeforeCreate + 1);
        UsrUser testUsrUser = usrUserList.get(usrUserList.size() - 1);
        assertThat(testUsrUser.getUsrUid()).isEqualTo(DEFAULT_USR_UID);
        assertThat(testUsrUser.getUsrStfUid()).isEqualTo(DEFAULT_USR_STF_UID);
        assertThat(testUsrUser.getUsrId()).isEqualTo(DEFAULT_USR_ID);
        assertThat(testUsrUser.getUsrAccountStatus()).isEqualTo(DEFAULT_USR_ACCOUNT_STATUS);
        assertThat(testUsrUser.getUsrDateAccountExpiration()).isEqualTo(DEFAULT_USR_DATE_ACCOUNT_EXPIRATION);
        assertThat(testUsrUser.getUsrAccountLockedYN()).isEqualTo(DEFAULT_USR_ACCOUNT_LOCKED_YN);
        assertThat(testUsrUser.getUsrRecordStatus()).isEqualTo(DEFAULT_USR_RECORD_STATUS);
        assertThat(testUsrUser.getUsrDatePasswordExpiration()).isEqualTo(DEFAULT_USR_DATE_PASSWORD_EXPIRATION);
        assertThat(testUsrUser.getUsrUserType()).isEqualTo(DEFAULT_USR_USER_TYPE);
        assertThat(testUsrUser.getUsrRecordStatusDate()).isEqualTo(DEFAULT_USR_RECORD_STATUS_DATE);
        assertThat(testUsrUser.getUsrCreateDate()).isEqualTo(DEFAULT_USR_CREATE_DATE);
        assertThat(testUsrUser.getUsrUsrUidCreatedBy()).isEqualTo(DEFAULT_USR_USR_UID_CREATED_BY);
        assertThat(testUsrUser.getUsrUsrUidUpdatedBy()).isEqualTo(DEFAULT_USR_USR_UID_UPDATED_BY);
        assertThat(testUsrUser.getUsrLastUpdateDate()).isEqualTo(DEFAULT_USR_LAST_UPDATE_DATE);
    }

    @Test
    @Transactional
    public void createUsrUserWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = usrUserRepository.findAll().size();

        // Create the UsrUser with an existing ID
        usrUser.setUsrUid(1);
        UsrUserDTO usrUserDTO = usrUserMapper.toDto(usrUser);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUsrUserMockMvc.perform(post("/api/usr-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(usrUserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the UsrUser in the database
        List<UsrUser> usrUserList = usrUserRepository.findAll();
        assertThat(usrUserList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkUsrUidIsRequired() throws Exception {
        int databaseSizeBeforeTest = usrUserRepository.findAll().size();
        // set the field null
        usrUser.setUsrUid(null);

        // Create the UsrUser, which fails.
        UsrUserDTO usrUserDTO = usrUserMapper.toDto(usrUser);


        restUsrUserMockMvc.perform(post("/api/usr-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(usrUserDTO)))
            .andExpect(status().isBadRequest());

        List<UsrUser> usrUserList = usrUserRepository.findAll();
        assertThat(usrUserList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllUsrUsers() throws Exception {
        // Initialize the database
        usrUserRepository.saveAndFlush(usrUser);

        // Get all the usrUserList
        restUsrUserMockMvc.perform(get("/api/usr-users?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].usrUid").value(hasItem(DEFAULT_USR_UID)))
            .andExpect(jsonPath("$.[*].usrStfUid").value(hasItem(DEFAULT_USR_STF_UID)))
            .andExpect(jsonPath("$.[*].usrId").value(hasItem(DEFAULT_USR_ID)))
            .andExpect(jsonPath("$.[*].usrAccountStatus").value(hasItem(DEFAULT_USR_ACCOUNT_STATUS)))
            .andExpect(jsonPath("$.[*].usrDateAccountExpiration").value(hasItem(DEFAULT_USR_DATE_ACCOUNT_EXPIRATION.toString())))
            .andExpect(jsonPath("$.[*].usrAccountLockedYN").value(hasItem(DEFAULT_USR_ACCOUNT_LOCKED_YN)))
            .andExpect(jsonPath("$.[*].usrRecordStatus").value(hasItem(DEFAULT_USR_RECORD_STATUS)))
            .andExpect(jsonPath("$.[*].usrDatePasswordExpiration").value(hasItem(DEFAULT_USR_DATE_PASSWORD_EXPIRATION.toString())))
            .andExpect(jsonPath("$.[*].usrUserType").value(hasItem(DEFAULT_USR_USER_TYPE)))
            .andExpect(jsonPath("$.[*].usrRecordStatusDate").value(hasItem(DEFAULT_USR_RECORD_STATUS_DATE.toString())))
            .andExpect(jsonPath("$.[*].usrCreateDate").value(hasItem(DEFAULT_USR_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].usrUsrUidCreatedBy").value(hasItem(DEFAULT_USR_USR_UID_CREATED_BY)))
            .andExpect(jsonPath("$.[*].usrUsrUidUpdatedBy").value(hasItem(DEFAULT_USR_USR_UID_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].usrLastUpdateDate").value(hasItem(DEFAULT_USR_LAST_UPDATE_DATE.toString())));
    }

    @Test
    @Transactional
    public void getUsrUser() throws Exception {
        // Initialize the database
        usrUserRepository.saveAndFlush(usrUser);

        // Get the usrUser
        restUsrUserMockMvc.perform(get("/api/usr-users/{uid}", usrUser.getUsrUid()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.usrUid").value(DEFAULT_USR_UID))
            .andExpect(jsonPath("$.usrStfUid").value(DEFAULT_USR_STF_UID))
            .andExpect(jsonPath("$.usrId").value(DEFAULT_USR_ID))
            .andExpect(jsonPath("$.usrAccountStatus").value(DEFAULT_USR_ACCOUNT_STATUS))
            .andExpect(jsonPath("$.usrDateAccountExpiration").value(DEFAULT_USR_DATE_ACCOUNT_EXPIRATION.toString()))
            .andExpect(jsonPath("$.usrAccountLockedYN").value(DEFAULT_USR_ACCOUNT_LOCKED_YN))
            .andExpect(jsonPath("$.usrRecordStatus").value(DEFAULT_USR_RECORD_STATUS))
            .andExpect(jsonPath("$.usrDatePasswordExpiration").value(DEFAULT_USR_DATE_PASSWORD_EXPIRATION.toString()))
            .andExpect(jsonPath("$.usrUserType").value(DEFAULT_USR_USER_TYPE))
            .andExpect(jsonPath("$.usrRecordStatusDate").value(DEFAULT_USR_RECORD_STATUS_DATE.toString()))
            .andExpect(jsonPath("$.usrCreateDate").value(DEFAULT_USR_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.usrUsrUidCreatedBy").value(DEFAULT_USR_USR_UID_CREATED_BY))
            .andExpect(jsonPath("$.usrUsrUidUpdatedBy").value(DEFAULT_USR_USR_UID_UPDATED_BY))
            .andExpect(jsonPath("$.usrLastUpdateDate").value(DEFAULT_USR_LAST_UPDATE_DATE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingUsrUser() throws Exception {
        // Get the usrUser
        restUsrUserMockMvc.perform(get("/api/usr-users/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUsrUser() throws Exception {
        // Initialize the database
        usrUserRepository.saveAndFlush(usrUser);

        int databaseSizeBeforeUpdate = usrUserRepository.findAll().size();

        // Update the usrUser
        UsrUser updatedUsrUser = usrUserRepository.findById(usrUser.getUsrUid()).get();
        // Disconnect from session so that the updates on updatedUsrUser are not directly saved in db
        em.detach(updatedUsrUser);
        updatedUsrUser
            .usrUid(UPDATED_USR_UID)
            .usrStfUid(UPDATED_USR_STF_UID)
            .usrId(UPDATED_USR_ID)
            .usrAccountStatus(UPDATED_USR_ACCOUNT_STATUS)
            .usrDateAccountExpiration(UPDATED_USR_DATE_ACCOUNT_EXPIRATION)
            .usrAccountLockedYN(UPDATED_USR_ACCOUNT_LOCKED_YN)
            .usrRecordStatus(UPDATED_USR_RECORD_STATUS)
            .usrDatePasswordExpiration(UPDATED_USR_DATE_PASSWORD_EXPIRATION)
            .usrUserType(UPDATED_USR_USER_TYPE)
            .usrRecordStatusDate(UPDATED_USR_RECORD_STATUS_DATE)
            .usrCreateDate(UPDATED_USR_CREATE_DATE)
            .usrUsrUidCreatedBy(UPDATED_USR_USR_UID_CREATED_BY)
            .usrUsrUidUpdatedBy(UPDATED_USR_USR_UID_UPDATED_BY)
            .usrLastUpdateDate(UPDATED_USR_LAST_UPDATE_DATE);
        UsrUserDTO usrUserDTO = usrUserMapper.toDto(updatedUsrUser);

        restUsrUserMockMvc.perform(put("/api/usr-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(usrUserDTO)))
            .andExpect(status().isOk());

        // Validate the UsrUser in the database
        List<UsrUser> usrUserList = usrUserRepository.findAll();
        assertThat(usrUserList).hasSize(databaseSizeBeforeUpdate);
        UsrUser testUsrUser = usrUserList.get(usrUserList.size() - 1);
        assertThat(testUsrUser.getUsrUid()).isEqualTo(UPDATED_USR_UID);
        assertThat(testUsrUser.getUsrStfUid()).isEqualTo(UPDATED_USR_STF_UID);
        assertThat(testUsrUser.getUsrId()).isEqualTo(UPDATED_USR_ID);
        assertThat(testUsrUser.getUsrAccountStatus()).isEqualTo(UPDATED_USR_ACCOUNT_STATUS);
        assertThat(testUsrUser.getUsrDateAccountExpiration()).isEqualTo(UPDATED_USR_DATE_ACCOUNT_EXPIRATION);
        assertThat(testUsrUser.getUsrAccountLockedYN()).isEqualTo(UPDATED_USR_ACCOUNT_LOCKED_YN);
        assertThat(testUsrUser.getUsrRecordStatus()).isEqualTo(UPDATED_USR_RECORD_STATUS);
        assertThat(testUsrUser.getUsrDatePasswordExpiration()).isEqualTo(UPDATED_USR_DATE_PASSWORD_EXPIRATION);
        assertThat(testUsrUser.getUsrUserType()).isEqualTo(UPDATED_USR_USER_TYPE);
        assertThat(testUsrUser.getUsrRecordStatusDate()).isEqualTo(UPDATED_USR_RECORD_STATUS_DATE);
        assertThat(testUsrUser.getUsrCreateDate()).isEqualTo(UPDATED_USR_CREATE_DATE);
        assertThat(testUsrUser.getUsrUsrUidCreatedBy()).isEqualTo(UPDATED_USR_USR_UID_CREATED_BY);
        assertThat(testUsrUser.getUsrUsrUidUpdatedBy()).isEqualTo(UPDATED_USR_USR_UID_UPDATED_BY);
        assertThat(testUsrUser.getUsrLastUpdateDate()).isEqualTo(UPDATED_USR_LAST_UPDATE_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingUsrUser() throws Exception {
        int databaseSizeBeforeUpdate = usrUserRepository.findAll().size();

        // Create the UsrUser
        UsrUserDTO usrUserDTO = usrUserMapper.toDto(usrUser);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUsrUserMockMvc.perform(put("/api/usr-users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(usrUserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the UsrUser in the database
        List<UsrUser> usrUserList = usrUserRepository.findAll();
        assertThat(usrUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteUsrUser() throws Exception {
        // Initialize the database
        usrUserRepository.saveAndFlush(usrUser);

        int databaseSizeBeforeDelete = usrUserRepository.findAll().size();

        // Delete the usrUser
        restUsrUserMockMvc.perform(delete("/api/usr-users/{uid}", usrUser.getUsrUid())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<UsrUser> usrUserList = usrUserRepository.findAll();
        assertThat(usrUserList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
