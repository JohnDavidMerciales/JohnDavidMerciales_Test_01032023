package com.CGIEXAM.cgiexam.service;

import com.CGIEXAM.cgiexam.model.UsersModel;
import com.CGIEXAM.cgiexam.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String login, String password, String email){
        if(email == null && password == null && login == null) {
            return null;
        }else {
            if(usersRepository.findFirstByEmail(email).isPresent()){
                System.out.println("Users already exist");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return usersRepository.save(usersModel);
        }
    }

    public UsersModel authenticate(String email, String password){
        return usersRepository.findByEmailAndPassword(email, password).orElse( null);
    }
}
