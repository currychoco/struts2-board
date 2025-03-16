package com.currychoco.board.features.user.service;

import com.currychoco.board.features.user.domain.User;
import com.currychoco.board.features.user.repository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public User signup(String id, String password, String nickname) {

        User user = User.builder()
                .id(id)
                .password(hashPassword(password))
                .nickname(nickname)
                .build();

        return userRepository.save(user);
    }

    public boolean login(String id, String password) {
        return userRepository.findByIdAndPassword(id, hashPassword(password)).isPresent();
    }

    public User getUser(Long seq) {
        return userRepository.findById(seq);
    }

    private String hashPassword(String password) {
        try {
            return Arrays.toString(MessageDigest.getInstance("SHA-256").digest(password.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
