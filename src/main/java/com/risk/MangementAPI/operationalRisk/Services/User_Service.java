/*

package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.Model.Role;
import com.risk.MangementAPI.operationalRisk.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class User_Service  implements CommandLineRunner {

        @Autowired
        private User_Repository userRepository;
        @Autowired
        private RoleRepository roleRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) throws Exception {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            Role userPrimeRole = new Role();
            userPrimeRole.setname("ROLE_USERPRIME");

            roleRepository.save(adminRole);
            roleRepository.save(userRole);
            roleRepository.save(userPrimeRole);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.getRoles().add(adminRole);
            userRepository.save(admin);

            User user = new User();
            user.setusername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.getRoles().add(userRole);
            userRepository.save(user);

            User userPrime = new User();
            userPrime.setusername("userprime");
            userPrime.setPassword(passwordEncoder.encode("userprime"));
            userPrime.getRoles().add(userPrimeRole);
            userRepository.save(userPrime);
        }
    }

}

*/
