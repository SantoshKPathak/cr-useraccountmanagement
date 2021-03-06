package com.hzn.cr.uam.service;

import com.hzn.cr.uam.domain.UsrUser;
import com.hzn.cr.uam.repository.UsrUserRepository;
import com.hzn.cr.uam.service.dto.UsrUserDTO;
import com.hzn.cr.uam.service.mapper.UsrUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link UsrUser}.
 */

public interface UsrUserService {
    /**
     * Save a usrUser.
     *
     * @param usrUserDTO the entity to save.
     * @return the persisted entity.
     */
    UsrUserDTO save(UsrUserDTO usrUserDTO);

    /**
     * Get all the usrUsers.
     *
     * @return the list of entities.
     */
    List<UsrUserDTO> findAll();

    /**
     * Get one usrUser by usrUid.
     *
     * @param usrUid the usrUid of the entity.
     * @return the entity.
     */
    Optional<UsrUserDTO> findOne(Integer usrUid);

    /**
     * Delete the usrUser by usrUid.
     *
     * @param usrUid the usrUid of the entity.
     */
    void delete(Integer usrUid);
}
