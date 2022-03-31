package assetManagementAssign.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assetManagementAssign.entity.User;
import assetManagementAssign.repository.AssetRepository;
import assetManagementAssign.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AssetRepository assetRepository;

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	public Map<String, Object> getUserDetail(int userId) {
Map<String, Object> res = new HashMap<>(); 
Object []obj=  userRepository.findUserDetails(userId);

	 res.put("user", obj) ;
//	 assetRepository.findAllByUserId(userId);
	
	return res;
	}
	
	

}
