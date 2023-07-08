package br.com.well.api.amazon.controller;

import br.com.well.api.amazon.model.User;
import br.com.well.api.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return service.registerAndUpdate(user, "cadastar");
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {
        return service.registerAndUpdate(user, "update");
    }

    @GetMapping("/list")
    public Iterable<User> listAllUser(){
        return service.findAllUser();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
