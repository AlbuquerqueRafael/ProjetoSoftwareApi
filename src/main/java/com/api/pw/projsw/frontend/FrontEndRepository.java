package com.api.pw.projsw.frontend;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FrontEndRepository extends JpaRepository<FrontEnd, Long> {
  
  Optional<FrontEnd> findById(String id);
}