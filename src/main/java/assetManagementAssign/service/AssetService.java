package assetManagementAssign.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assetManagementAssign.entity.Asset;
import assetManagementAssign.entity.Category;
import assetManagementAssign.entity.User;
import assetManagementAssign.repository.AssetRepository;
import assetManagementAssign.repository.CategoryRepository;
import assetManagementAssign.repository.UserRepository;
@Service 
public class AssetService {

	
	@Autowired
	private AssetRepository assetRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	public void addAsset(Asset asset) {
		int cid = asset.getCategory().getId();
		Category c= categoryRepository.findById(cid).get();
		asset.setCategory(c);
		assetRepository.save(asset);
		
		
	}
	public void updateAsset(Asset asset) {
		Optional<Asset> ast = assetRepository.findById(asset.getId());
		if(ast.isPresent()) {
			Asset existing = ast.get();
			if(asset.getName() != null) {
				existing.setName(asset.getName());
			}
			if(asset.getPurchaseDate() != null) {
				existing.setPurchaseDate(asset.getPurchaseDate());
			}
			if(asset.getAssignmentStatus() != null) {
				existing.setAssignmentStatus(asset.getAssignmentStatus());
			}
			assetRepository.save(existing);

		}
		
	}
	public void deleteAsset(Asset asset) {
		assetRepository.delete(asset);
	}
	public Asset getAssetByName(Long name) {
		Asset asset = assetRepository.getByName(name);
		return asset;
	}
	public List<Asset> getAllAssets() {
		return assetRepository.findAll() ;
	}
	public String assignAsset(int assetId, int userId) {
	Asset asset = assetRepository.getById(assetId);
	if(asset.getUser() != null) {
		return "already assigned";
	}
	else {
	User user = userRepository.getById(userId);
	asset.setUser(user);
	assetRepository.save(asset);
	}
		return "successfully assigned";
	}
	public String deleteAssetFromUser(Asset asset) {
		Asset existing = assetRepository.getById(asset.getId());
		User user = userRepository.getById(asset.getUser().getId());
		if(existing.getUser().getId()==user.getId()) {
			existing.setUser(null);
			assetRepository.save(existing);
			return "succesfully removed!";
		}
		else {
			return "failed";
		}
		
	
	}

}
