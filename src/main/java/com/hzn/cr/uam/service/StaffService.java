package com.hzn.cr.uam.service;

import com.hzn.cr.uam.domain.Staff;
import com.hzn.cr.uam.repository.StaffRepository;
import com.hzn.cr.uam.service.dto.StaffDTO;
import com.hzn.cr.uam.service.mapper.StaffMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Staff}.
 */
public interface StaffService {


    /**
     * Save a staff.
     *
     * @param staffDTO the entity to save.
     * @return the persisted entity.
     */
    public StaffDTO save(StaffDTO staffDTO);

    /**
     * Get all the staff.
     *
     * @return the list of entities.
     */
    public List<StaffDTO> findAll();


    /**
     * Get one staff by id.
     *
     * @param stfUid the id of the entity.
     * @return the entity.
     */
    public Optional<StaffDTO> findOne(Integer stfUid);

    /**
     * Delete the staff by id.
     *
     * @param stfUid the id of the entity.
     */
    public void delete(Integer stfUid) ;
}
