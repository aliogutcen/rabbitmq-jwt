package com.ali.repository;

import com.ali.repository.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMailRepository  extends JpaRepository<Mail,Long> {

    Optional<Mail> findOptionalByMailAndCode(String mail,String code);
}
