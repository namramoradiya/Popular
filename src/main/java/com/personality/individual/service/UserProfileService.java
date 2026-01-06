package com.personality.individual.service;

import com.personality.individual.Entity.UserProfile;

public interface UserProfileService {

    UserProfile saveUser(UserProfile userProfile);

    UserProfile getUserById(Long id);
}