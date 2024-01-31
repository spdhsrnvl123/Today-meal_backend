package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.UserDAO;
import app.todaymealvote_backend.dto.CustomUserDetails;
import app.todaymealvote_backend.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username);

        UserDTO userData = (UserDTO) userDAO.userFindOne(username);


        if(userData != null){
            System.out.println(userData);
            return new CustomUserDetails(userData);
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
