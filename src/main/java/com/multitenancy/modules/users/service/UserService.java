package com.multitenancy.modules.users.service;

import com.multitenancy.modules.customer.entity.Customer;
import com.multitenancy.modules.customer.repository.CustomerRepository;
import com.multitenancy.modules.users.dto.UserDtoLogin;
import com.multitenancy.modules.users.dto.UserPost;
import com.multitenancy.modules.users.entity.User;
import com.multitenancy.modules.users.mapper.UserMapper;
import com.multitenancy.modules.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final CustomerRepository customerRepository;

    public User save(UserPost userPost){
        userPost.setPassword(encoder.encode(userPost.getPassword()));
        User user = UserMapper.INSTANCE.toUser(userPost);
        Customer customer = customerRepository.findById(user.getCustomer().getId()).orElseThrow(() -> new RuntimeException("Customer Not Found"));
        user.setInsert(new Date());
        user.setUpdate(new Date());
        user.setSchema(customer.getName());
        return repository.save(user);
    }


    public Boolean findByUser(UserDtoLogin user){
        User findByEmail = Optional.ofNullable(repository.findByEmail(user.getEmail()))
                .orElseThrow(() -> new UsernameNotFoundException("Email Not Found " + user.getEmail()));
        return encoder.matches(user.getPassword(), findByEmail.getPassword());
    }

    public User findByEmail(String email){
        return Optional.ofNullable(repository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException("Email Not Found " + email));
    }
}
