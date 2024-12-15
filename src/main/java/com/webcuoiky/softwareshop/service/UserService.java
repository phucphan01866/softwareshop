package com.webcuoiky.softwareshop.service;

import com.webcuoiky.softwareshop.model.User;
import com.webcuoiky.softwareshop.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public boolean register(User user) {
        // Kiểm tra email đã tồn tại chưa
        if (userRepository.existsByEmail(user.getEmail())) {
            return false; // Email đã tồn tại
        }

        System.out.println("Mật khẩu gốc (trước khi mã hóa): " + user.getPassword());
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        System.out.println("Mật khẩu mã hóa (lưu vào DB): " + encodedPassword);
        user.setPassword(encodedPassword);

        // Lưu vào database
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return true;
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email); // Tìm người dùng theo email
        if (user == null) {
            throw new IllegalArgumentException("Tài khoản không tồn tại");
        }

        System.out.println("Mật khẩu trong DB (mã hóa): " + user.getPassword());
        System.out.println("Mật khẩu nhập vào (plain text): " + password);

        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Mật khẩu không chính xác");
        }
        return user;
    }

}
