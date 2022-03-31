package assetManagementAssign.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import assetManagementAssign.entity.User;
import assetManagementAssign.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
				return "created";
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
				return "deleted";
	}
	
	@GetMapping("/users")
	public Map<String, Object> getUsers(@RequestParam int userId) {
		return userService.getUserDetail(userId);
	}
}
