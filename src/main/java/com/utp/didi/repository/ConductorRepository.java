package com.utp.didi.repository;

import com.utp.didi.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor,Long> {
}
