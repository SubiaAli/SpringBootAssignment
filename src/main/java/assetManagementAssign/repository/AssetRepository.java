package assetManagementAssign.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import assetManagementAssign.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

//	void addAsset(Asset asset);
//
//	void updateAsset(Asset asset);
//
//	void deleteAsset(Asset asset);
//
//	List<Asset> getAllAssets();

	Asset getByName(Long name);
@Query(nativeQuery = true , value = "select * from asset where userId =: userId")
	List<Object[]> findAllByUserId(int userId);


	

}
