package com.cruds.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.Exceptionhandler.UserNotFoundException;
import com.cruds.Repository.UserRepository;
import com.cruds.dto.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll(); 
	}

	@Override
	public String addUser(Users user) {
		userRepository.save(user);
		return "User added sucessfully";
	}

	@Override
	public Users getUserById(int id) {
		Users user = userRepository.findById(id).
				orElseThrow(()-> new UserNotFoundException("user id not found"));
		return user;
	}

	@Override
	public String deleteUserById(int id) {
		
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException("user id not found");
		}
		return "user deleted sucessfully";
	}

	@Override
	public Users updateUser(Users user, int id) {
		
		Users UpdatedUser = userRepository.findById(id).
				orElseThrow(()-> new UserNotFoundException("user id not found"));
		
		UpdatedUser.setName(user.getName());
		UpdatedUser.setEmail(user.getEmail());
		UpdatedUser.setCourse(user.getCourse());
		
		return userRepository.save(UpdatedUser);
	}

	
}
