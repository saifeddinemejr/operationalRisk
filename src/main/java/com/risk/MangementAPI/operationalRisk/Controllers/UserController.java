package com.risk.MangementAPI.operationalRisk.Controllers;

import com.risk.MangementAPI.operationalRisk.Model.User;
import com.risk.MangementAPI.operationalRisk.Repositories.User_Repository;
import com.risk.MangementAPI.operationalRisk.Services.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private User_Repository userRepository;
    @Autowired
    private User_Service userService;


    @PostMapping("/verify")
    @CrossOrigin
    public ResponseEntity<User> verifyUser(@RequestBody User user) {
        System.out.println("email +" +  user.getEmail().toString());
        Optional<User> existingUser = userRepository.findUserByEmail(user.getEmail());
        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        User user1 = existingUser.get();
        if (user.getPassword().equals(user1.getPassword())) {
            return ResponseEntity.ok(user1);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
