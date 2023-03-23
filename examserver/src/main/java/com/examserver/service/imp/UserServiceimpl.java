package com.examserver.service.imp;

import com.examserver.model.User;
import com.examserver.model.UserRole;
import com.examserver.repo.RoleRepository;
import com.examserver.repo.UserRepository;
import com.examserver.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceimpl implements UserService {

    @Autowired //(required = false)
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already there !!");
            throw new Exception("User Already present !!");
        }else
        {
            //user create
            for(UserRole ur:userRoles)
            {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }


        return local;
    }

    //get user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);

    }
}
