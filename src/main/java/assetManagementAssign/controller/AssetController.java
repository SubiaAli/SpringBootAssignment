package assetManagementAssign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import assetManagementAssign.entity.Asset;
import assetManagementAssign.service.AssetService;

@Controller
public class AssetController {

	@Autowired
	private AssetService assetService;

	@PostMapping("/asset")
	public String addAsset(@RequestBody Asset asset) {
		assetService.addAsset(asset);
				return "created";
	}
	
	@PutMapping("/asset/{id}")
	public String updateAsset(@RequestBody Asset asset) {
		assetService.updateAsset(asset);
				return "updated";
	}

	
	@DeleteMapping("/asset/{id}")
	public String deleteAsset(@RequestBody Asset asset) {
		assetService.deleteAsset(asset);
				return "deleted";
	}
	
	@GetMapping("/assets")
	public List<Asset> getAssets() {
		return assetService.getAllAssets();
	}
	@GetMapping("/asset/{name}")
	public Asset getAssetByName(@PathVariable("name") Long name) {
		Asset asset = assetService.getAssetByName(name);
		return asset;
	}
	
	@GetMapping("/assign/asset")
	public String assignAsset(@RequestParam int assetId ,@RequestParam int userId) {
		return assetService.assignAsset(assetId , userId);
	}
	@DeleteMapping("/delete/user")
		public String deleteAssetFromUser(@RequestBody Asset asset) {
		return	assetService.deleteAssetFromUser(asset);
		
		}
	
}
