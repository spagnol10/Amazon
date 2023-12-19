package br.com.well.api.amazon.adapters.controller;

import br.com.well.api.amazon.core.domain.entities.User;
import br.com.well.api.amazon.presentation.controller.UserController;
import br.com.well.api.amazon.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    private UserController userController;
    private UserService userServiceMock = Mockito.mock(UserService.class);

    @Test
    public void testListAll() {
        User user1 = new User();
        User user2 = new User();
        List<User> users = Arrays.asList(user1, user2);
        when(userServiceMock.findAll()).thenReturn(users);
        ResponseEntity<List<User>> response = userController.listAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    public void testFindById() {
        User user = new User();
        Long id = 1L;
        when(userServiceMock.findById(id)).thenReturn(user);
        ResponseEntity<User> response = userController.findById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testDelete() {
        Long id = 1L;
        when(userServiceMock.delete(id)).thenReturn(ResponseEntity.ok().build());
        ResponseEntity<?> response = userController.delete(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}