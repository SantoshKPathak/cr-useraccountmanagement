package com.hzn.cr.uam.service.impl;

import com.hzn.cr.uam.service.StaffService;
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
@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    private final Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);

    private final StaffRepository staffRepository;

    private final StaffMapper staffMapper;

    public StaffServiceImpl(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    @Override
    public StaffDTO save(StaffDTO staffDTO) {
        log.debug("Request to save Staff : {}", staffDTO);
        Staff staff = staffMapper.toEntity(staffDTO);
        staff = staffRepository.save(staff);
        return staffMapper.toDto(staff);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StaffDTO> findAll() {
        log.debug("Request to get all Staff");
        return staffRepository.findAll().stream()
            .map(staffMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<StaffDTO> findOne(Integer uid) {
        log.debug("Request to get Staff : {}", uid);
        return staffRepository.findById(uid)
            .map(staffMapper::toDto);
    }

    @Override
    public void delete(Integer uid) {
        log.debug("Request to delete Staff : {}", uid);
        staffRepository.deleteById(uid);
    }
}
