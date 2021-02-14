package com.ovia.api;

import com.ovia.dao.UserDao;
import com.ovia.model.user.User;
import com.ovia.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserResourceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserDao userDao;

    @Test
    public void addNewUser() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        User user = new User("dummy-test");
        when(userDao.save(any(User.class))).thenReturn(user);

        User userToAdd = new User("dummy-test");
        User response = userService.addUser(userToAdd);

        assertThat(response.getName()).isEqualTo("dummy-test");
    }

}
