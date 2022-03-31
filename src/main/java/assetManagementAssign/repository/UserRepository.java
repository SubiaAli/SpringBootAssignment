package assetManagementAssign.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import assetManagementAssign.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
@Query(nativeQuery = true, value = "select * from users where id =:userId")
	Object[] findUserDetails(int userId);



}
