package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.Model.User;
import com.risk.MangementAPI.operationalRisk.Repositories.User_Repository;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class User_Service {
    @Autowired
    private User_Repository userRepository ;
    public Optional<User> verifyUser(String email, String password) {
        Optional<User> existingUser = userRepository.findUserByEmail(email);
        if (!existingUser.isPresent()) {
            return Optional.empty();
        }
        User user = existingUser.get();
        if (password.equals(user.getPassword())) {
            return existingUser;
        }
        return Optional.empty();
    }


}
