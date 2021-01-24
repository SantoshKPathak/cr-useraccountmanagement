package com.hzn.cr.uam.service.impl;

import com.hzn.cr.uam.domain.UsrUser;
import com.hzn.cr.uam.repository.UsrUserRepository;
import com.hzn.cr.uam.service.UsrUserService;
import com.hzn.cr.uam.service.dto.UsrUserDTO;
import com.hzn.cr.uam.service.mapper.UsrUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsrUserServiceImpl implements UsrUserService {
    private final Logger log = LoggerFactory.getLogger(UsrUserServiceImpl.class);

    @Value("${application.api.user-record.lastUpdatedBy}")
    private Integer lastUpdatedBy;

    private final UsrUserRepository usrUserRepository;

    private final UsrUserMapper usrUserMapper;

    public UsrUserServiceImpl(UsrUserRepository usrUserRepository, UsrUserMapper usrUserMapper) {
        this.usrUserRepository = usrUserRepository;
        this.usrUserMapper = usrUserMapper;
    }

    /**
     * Save a usrUser.
     *
     * @param usrUserDTO the entity to save.
     * @return the persisted entity.
     */
    public UsrUserDTO save(UsrUserDTO usrUserDTO) {
        log.debug("Request to save UsrUser : {}", usrUserDTO);
        UsrUser usrUser = usrUserMapper.toEntity(usrUserDTO);
        usrUser = usrUserRepository.save(usrUser);
        return usrUserMapper.toDto(usrUser);
    }

    /**
     * Get all the usrUsers.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<UsrUserDTO> findAll() {
        log.debug("Request to get all Usr_User");
        List<UsrUser> users =  usrUserRepository.findAll();
        log.debug("User list size in DB :{}",users.size());
        log.debug("first User in DB :{},{}",users.get(0).getUsrUid(),users.get(0).getUsrId());
        return users.stream()
            .map(usrUserMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one usrUser by usrUid.
     *
     * @param usrUid the usrUid of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UsrUserDTO> findOne(Integer usrUid) {
        log.debug("Request to get UsrUser : {}", usrUid);
        return usrUserRepository.findById(usrUid)
            .map(usrUserMapper::toDto);
    }

    /**
     * Delete the usrUser by usrUid.
     *
     * @param usrUid the usrUid of the entity.
     */
    public void delete(Integer usrUid) {
        log.debug("Request to delete UsrUser : {}", usrUid);
        usrUserRepository.deleteById(usrUid);
    }
}
