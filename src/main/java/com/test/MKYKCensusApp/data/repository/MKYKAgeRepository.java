package com.test.MKYKCensusApp.data.repository;

import com.test.MKYKCensusApp.data.entity.MKYKAge;
import com.test.MKYKCensusApp.data.entity.MKYKGeographicArea;
import com.test.MKYKCensusApp.data.entity.MKYKUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface MKYKAgeRepository extends CrudRepository<MKYKAge, Integer> {
    @Query("select a from MKYKAge a where a.geo.alternativeCode = :altCode")
    List<MKYKAge> findByGeographicAreaAltCode(@Param("altCode")int altCode);

//    @Query("select a from MKYKAge a where u.geo.geographicAreaID = :geographicAreaID")
//    MKYKAge searchByGeoAreaID(@Param("id") String username);
}
