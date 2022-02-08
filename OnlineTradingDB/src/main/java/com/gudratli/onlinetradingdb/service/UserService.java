package com.gudratli.onlinetradingdb.service;

import com.gudratli.onlinetradingdb.entity.User;
import com.gudratli.onlinetradingdb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    public List<User> getAll ()
    {
        return userRepository.findAll();
    }

    public User getById (Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getByName (String name)
    {
        return userRepository.findByNameContaining(name);
    }

    public User update (User user)
    {
        return userRepository.save(user);
    }

    public User add (User user)
    {
        return userRepository.save(user);
    }

    public void remove (User user)
    {
        userRepository.delete(user);
    }
}