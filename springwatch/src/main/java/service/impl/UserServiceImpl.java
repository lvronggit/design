package service.impl;

import org.springframework.stereotype.Service;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {
    public void getUser() {
        System.out.println("getuser");
    }
}
