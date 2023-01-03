package com.CGIEXAM.cgiexam.repository;

import com.CGIEXAM.cgiexam.model.UsersModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

    Optional<UsersModel> findByEmailAndPassword(String email, String password);

    Optional<UsersModel> findFirstByEmail(String email);

}
