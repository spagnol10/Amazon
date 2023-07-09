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
        return service.registerAndUpdate(user, "register");
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {
        return service.registerAndUpdate(user, "update");
    }

    @GetMapping("/list")
    public Iterable<User> listAllUser(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
