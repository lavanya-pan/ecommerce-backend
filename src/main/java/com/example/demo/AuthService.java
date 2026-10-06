package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "Username already exists!";
        }
        User user = new User(username, passwordEncoder.encode(password), "USER");
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return "User not found!";
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid password!";
        }
        return jwtUtil.generateToken(username);
    }
}