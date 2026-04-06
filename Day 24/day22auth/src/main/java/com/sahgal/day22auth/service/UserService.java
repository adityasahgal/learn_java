package com.sahgal.day22auth.service;

import com.sahgal.day22auth.entity.User;
import com.sahgal.day22auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User login(String email, String password) {
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

    // GET all users
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // GET by ID
    public User getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // CREATE user (reuse register logic)
    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    // UPDATE user
    public User updateUser(Long id, User user) {
        User existing = getUserById(id);

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());

        // password update optional
        if (user.getPassword() != null) {
            existing.setPassword(encoder.encode(user.getPassword()));
        }

        existing.setRole(user.getRole());

        return repo.save(existing);
    }

    // DELETE user
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}