package com.hzn.cr.uam.web.rest;

import com.hzn.cr.uam.service.UserAccountManagementService;
import com.hzn.cr.uam.service.dto.UsrUserDTO;
import com.hzn.cr.uam.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.hzn.cr.uam.domain.UsrUser}.
 */
@RestController
@RequestMapping("/api")
public class UserAccountManagementResource {

    private final Logger log = LoggerFactory.getLogger(UserAccountManagementResource.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private static final String CR_ENTITY_NAME = "User";

    private final UserAccountManagementService userAccountManagementService;

    public UserAccountManagementResource(UserAccountManagementService userAccountManagementService) {
        this.userAccountManagementService = userAccountManagementService;
    }

    /**
     * {@code PUT  /cr-user/activate} : Activates an existing User account if expired.
     *
     * @param usrUserDTO the usrUserDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated usrUserDTO,
     */
    @PutMapping("/cr-user/activate")
    public ResponseEntity<UsrUserDTO> activateUser(@Valid @RequestBody UsrUserDTO usrUserDTO){
        log.debug("REST request to activate CR User : {}", usrUserDTO);

        if (usrUserDTO.getUsrId() == null) {
            throw new BadRequestAlertException("Invalid usrId", CR_ENTITY_NAME, "usrId null");
        }
        List<UsrUserDTO> dbUsrList = userAccountManagementService.findUsersByUserId(usrUserDTO.getUsrId());

        if(null==dbUsrList || dbUsrList.size()==0){
            return ResponseUtil.wrapOrNotFound(Optional.of(usrUserDTO),
                HeaderUtil.createFailureAlert(applicationName, false, CR_ENTITY_NAME,usrUserDTO.getUsrId(),String.format("Failure!! UserId %s not found in CR.",usrUserDTO.getUsrId())));
        }
        UsrUserDTO existingStaff = userAccountManagementService.getStaffAccountType(dbUsrList);

        if(userAccountManagementService.isUserAccountActive(existingStaff)){
            return ResponseUtil.wrapOrNotFound(Optional.of(usrUserDTO),
                HeaderUtil.createAlert(applicationName, String.format("UserId %s is already active.",usrUserDTO.getUsrId()),usrUserDTO.getUsrId()));
        }

        if(userAccountManagementService.isUserAccountDisabled(existingStaff)){
            return ResponseUtil.wrapOrNotFound(Optional.of(usrUserDTO),
                HeaderUtil.createFailureAlert(applicationName, false,CR_ENTITY_NAME,usrUserDTO.getUsrId(),String.format("UserId %s is disabled.Please submit ACM to get access.",usrUserDTO.getUsrId())));
        }

        UsrUserDTO result = userAccountManagementService.activateUser(existingStaff);

        return ResponseUtil.wrapOrNotFound(Optional.of(result),
            HeaderUtil.createAlert(applicationName, String.format("Success! Expired UserId %s is now activated.",result.getUsrId()),result.getUsrId()));
    }
}
