package com.api.pw.projsw.msg;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MessageRepository extends JpaRepository<Message, Long> {
    
}