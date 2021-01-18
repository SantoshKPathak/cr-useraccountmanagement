package com.hzn.cr.uam.repository;

import com.hzn.cr.uam.domain.UsrUser;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the UsrUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsrUserRepository extends JpaRepository<UsrUser, Integer> {

    List<UsrUser> findByUsrId(String userId);
}
