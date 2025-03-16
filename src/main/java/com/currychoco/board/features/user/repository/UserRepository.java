package com.currychoco.board.features.user.repository;

import com.currychoco.board.features.user.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//TODO: DB 및 MyBatis 연동
public class UserRepository {

    private static Map<Long, User> users = new HashMap<>();
    private static long seq = 0;

    public User save(User user) {
        var currentSeq = seq++;
        user.setSeq(currentSeq);
        users.put(currentSeq, user);
        return user;
    }

    public Optional<User> findByIdAndPassword(String id, String password) {
        return users.values().stream()
                .filter(user -> user.getId().equals(id) && user.getPassword().equals(password))
                .findFirst();
    }

    public User findById(Long seq) {
        return users.get(seq);
    }
}
