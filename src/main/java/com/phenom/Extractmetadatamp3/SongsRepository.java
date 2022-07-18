package com.phenom.Extractmetadatamp3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
@Component("autowiredSongsRepository")
public interface SongsRepository extends JpaRepository<Songs, Integer> {
    /*
    @Query("select duration from Songs s where s.duration <= ")
    public List<BigDecimal> getSongs(@Param("duration") BigDecimal duration);*/
}