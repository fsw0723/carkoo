package com.carkoo.Service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class UserDetailServiceTest {
    private UserDetailService userDetailService;

    @Before
    public void setUp(){
        userDetailService = new UserDetailService();
        userDetailService.mongoUser = Mockito.mock(MongoUserImpl.class);
    }

    @Test
    public void shouldReturnSpringUser(){
        User userDetail = new User("name", "pass", true, true, true, true, new ArrayList<GrantedAuthority>(){{new GrantedAuthorityImpl("ROLE_USER");}});
        when(userDetailService.mongoUser.findByUsername(anyString())).thenReturn(new com.carkoo.model.User("name", "pass", 1));
        assertEquals(userDetailService.loadUserByUsername("name"), userDetail);
    }

}
