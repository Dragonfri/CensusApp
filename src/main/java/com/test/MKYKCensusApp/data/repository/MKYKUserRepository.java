package com.test.MKYKCensusApp.data.repository;

import com.test.MKYKCensusApp.data.entity.MKYKUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MKYKUserRepository extends CrudRepository<MKYKUser, Integer> {
    @Query("select u from MKYKUser u where u.username= :name")
    MKYKUser searchByName(@Param("name") String username);
}
