package com.test.MKYKCensusApp.data.repository;


import com.test.MKYKCensusApp.data.entity.MKYKGeographicArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface MKYKGeographicAreaRepository extends CrudRepository<MKYKGeographicArea, Integer>{
    List<MKYKGeographicArea> findByLevel(int level);
    List<MKYKGeographicArea> findByName(String name);
    List<MKYKGeographicArea> findByNameLike(String name);
}
