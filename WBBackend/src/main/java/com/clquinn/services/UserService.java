package com.clquinn.services;

import com.clquinn.daos.UserDAO;
import com.clquinn.models.User;
import com.clquinn.models.dtos.UserLoginDTO;
import com.clquinn.models.dtos.UserOutgoingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

   @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public UserOutgoingDTO createUser(User user) {
        if (user == null) {
            throw new RuntimeException("User cannot be null");
        }
        if (user.getId() == null || user.getUsername() == null || user.getPassword() == null) {
            throw new RuntimeException("User id, username and password cannot be null");
        }
        if (userDAO.findById(user.getId()).isPresent()) {
            throw new RuntimeException("User with id " + user.getId() + " already exists");
        }
        return new UserOutgoingDTO(userDAO.save(user));
   }

    public UserOutgoingDTO loginUser(UserLoginDTO user) {
        if (user == null) {
            throw new RuntimeException("User cannot be null");
        }
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new RuntimeException("Username and password cannot be null");
        }
        User userToLogin = userDAO.findByUsername(user.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        if (userToLogin.getPassword().equals(user.getPassword())) {
            return new UserOutgoingDTO(userToLogin);
        } else {
            throw new RuntimeException("Incorrect password");
        }
   }

    public UserOutgoingDTO getUser(Long id) {
         return userDAO.findById(id).map(UserOutgoingDTO::new).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserOutgoingDTO updateUser(Long id, User user) {
        if (userDAO.existsById(id)) {
            user.setId(id);
            return new UserOutgoingDTO(userDAO.save(user));
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public String deleteUser(Long id) {
        if (userDAO.existsById(id)) {
            userDAO.deleteById(id);
            return "User deleted";
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public UserOutgoingDTO getUserByUsername(String username) {
        return userDAO.findByUsername(username).map(UserOutgoingDTO::new).orElseThrow(() -> new RuntimeException("User not found"));
    }


}
