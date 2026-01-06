package com.personality.individual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personality.individual.Entity.UserProfile;
import com.personality.individual.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    @Override
    public UserProfile saveUser(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
}