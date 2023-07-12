package br.com.well.api.amazon.service;

import br.com.well.api.amazon.model.User;
import br.com.well.api.amazon.model.enums.Response;
import br.com.well.api.amazon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final Response userMessageService;

    public ResponseEntity<?> registerAndUpdate(User user, String action) {
        if (user.getName().isEmpty()) {
            userMessageService.setMessage("User name is required");
            return new ResponseEntity<>(userMessageService, HttpStatus.BAD_REQUEST);
        } else if (user.getPassword().isEmpty()) {
            userMessageService.setMessage("User password type is required");
            return new ResponseEntity<>(userMessageService, HttpStatus.BAD_REQUEST);
        } else {
            if (action.equals("register")){
                return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
            }
        }
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public ResponseEntity<?> delete(Long id) {
        userRepository.deleteById(id);
        userMessageService.setMessage("User deleted");
        return new ResponseEntity<>(userMessageService,HttpStatus.OK);
    }
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return  user.get();
    }
}
