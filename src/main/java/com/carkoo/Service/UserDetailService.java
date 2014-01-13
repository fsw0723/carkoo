package com.carkoo.Service;

import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.carkoo.model.User user = new MongoUseImpl().findByUsername(s);
        System.out.println(user.getPassword());
        List authorities = new ArrayList();
        authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }
}
