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
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO userData = userDAO.infoId(username);


        if(userData != null){
            // 비밀번호 암호화
            if (!userData.getPassword().startsWith("$2a$")) {
                String encryptedPassword = bCryptPasswordEncoder.encode(userData.getPassword());
                userData.setPassword(encryptedPassword);
            }

            return new CustomUserDetails(userData);
        }

        return null;

    }
}
