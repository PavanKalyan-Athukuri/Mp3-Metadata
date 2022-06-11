package com.phenom.Extractmetadatamp3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component("autowiredSongsRepository")
public interface SongsRepository extends JpaRepository<Songs, String> {

}