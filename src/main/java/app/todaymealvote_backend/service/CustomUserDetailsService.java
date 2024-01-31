package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.UserDAO;
import app.todaymealvote_backend.dto.CustomUserDetails;
import app.todaymealvote_backend.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO userData = (UserDTO) userDAO.userFindOne(username);


        if(userData != null){
            System.out.println(userData);
            return new CustomUserDetails(userData);
        }

        return null;
    }
}
