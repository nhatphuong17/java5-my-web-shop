package com.nhatpoly.NhatAssignment5.service;



import com.nhatpoly.NhatAssignment5.model.User;
import com.nhatpoly.NhatAssignment5.reponseitory.UserReponseitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service

public class UserServiceImpl implements UserService{
    @Autowired
    private UserReponseitory userRepository;
@Override
public List<User> findAllUsers(){
    return (List<User>) userRepository.findAll();
}
    @Override
    public void saveUser(User user) {

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {

        return userRepository.findById(id).get();
    }
}
