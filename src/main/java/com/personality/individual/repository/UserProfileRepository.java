package com.personality.individual.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.personality.individual.Entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	
	//UserProfile findById(Long id);
	
}