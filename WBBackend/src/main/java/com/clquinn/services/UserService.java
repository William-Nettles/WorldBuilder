package com.clquinn.services;

import com.clquinn.daos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDAO userDAO;

   @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


}
