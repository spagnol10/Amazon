package br.com.well.api.amazon.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.well.api.amazon.user.model.entities.User;
import br.com.well.api.amazon.user.model.enums.ResponseUser;
import br.com.well.api.amazon.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ResponseUser messageUser;

    public ResponseEntity<?> register(User user) {
        if (user.getName().isEmpty()) {
            messageUser.setMessage("User name is required");
            return new ResponseEntity<>(messageUser, HttpStatus.BAD_REQUEST);
        } else if (user.getPassword().isEmpty()) {
            messageUser.setMessage("User password type is required");
            return new ResponseEntity<>(messageUser, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public ResponseEntity<?> update(User user) {
        if (user.getName().isEmpty()) {
            messageUser.setMessage("User name is required");
            return new ResponseEntity<>(messageUser, HttpStatus.BAD_REQUEST);
        } else if (user.getPassword().isEmpty()) {
            messageUser.setMessage("User password type is required");
            return new ResponseEntity<>(messageUser, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        userRepository.deleteById(id);
        messageUser.setMessage("User deleted");
        return new ResponseEntity<>(messageUser, HttpStatus.OK);
    }
}
