package com.had.springbootdemo.repository;

import com.had.springbootdemo.entity.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, Long> {

    @Query("select off from OfficeEntity off join fetch off.company company join fetch off.users users where off.id = :officeId")
    Optional<OfficeEntity> findInfoOfficeById(@Param("officeId") Long officeId);

}
