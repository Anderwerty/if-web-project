package org.example.injector;

import org.example.repository.InMemoryUserRepository;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContextHolder {
    private ApplicationContextHolder(){

    }

    private static final UserRepository USER_REPOSITORY = new InMemoryUserRepository();
    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY);

    //....

    private static final Map<Class<?>, Object> CLASS_TO_INSTANCE = new HashMap<>();

    static {
        CLASS_TO_INSTANCE.put(UserRepository.class, USER_REPOSITORY);
        CLASS_TO_INSTANCE.put(UserService.class, USER_SERVICE);
    }


    public static <T> T getInstance(Class<T> aClass) {
        Object instance = CLASS_TO_INSTANCE.get(aClass);
        //
        if (instance == null) {
            throw new RuntimeException();// hre use custom exception, InstanceNotExistException
        }

        return (T) instance;
    }

}
