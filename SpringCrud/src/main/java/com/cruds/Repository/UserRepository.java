package com.cruds.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruds.dto.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	
}
