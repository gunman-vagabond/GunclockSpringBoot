package com.gunman.Gunclock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GunclockRepository extends JpaRepository<Gunclock, Long> {

}