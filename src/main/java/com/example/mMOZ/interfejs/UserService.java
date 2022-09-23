package com.example.mMOZ.interfejs;

import com.example.mMOZ.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}
