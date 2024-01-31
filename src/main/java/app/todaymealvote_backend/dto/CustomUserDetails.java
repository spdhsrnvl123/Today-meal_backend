package app.todaymealvote_backend.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private UserDTO userData;

    public CustomUserDetails(UserDTO userData){
        this.userData = userData;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //사용자 권한에 대해서 리턴해주는 메소드이다. - 즉 Role값을 리턴하는 메소드이다.

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new SimpleGrantedAuthority(userData.getRole()));

        System.out.println(collection);

        return collection;
    }

    @Override
    public String getPassword() {
        return userData.getPassword();
    }

    @Override
    public String getUsername() {
        return userData.getUser_id();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
