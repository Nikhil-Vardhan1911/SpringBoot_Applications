package com.cruds.Service;

import java.util.List;
import com.cruds.dto.Users;

public interface UserService {

	List<Users> getAllUsers();
	String addUser(Users user);
	Users getUserById(int id);
	String deleteUserById(int id);
	Users updateUser(Users user, int id);
}
