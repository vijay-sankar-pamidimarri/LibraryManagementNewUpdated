package StudentLibraryManagement.LibraryMangerApplication.Repository;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.CoinUser;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCoin extends JpaRepository<CoinUser,Integer> {

//    get the user by the user_id
    @Query("select User from User where userId=:user_id")
    User getUserByUserId(@Param("user_id") int user_id);


//    get all the users
    @Query(value = "select * from user",nativeQuery = true)
    List<User> getAllUsersInDatabase();


    //delete the user by the id
    @Modifying
    @Query(value = "delete user where user_id=:user_id",nativeQuery = true)
    int deleteUserByUserId(@Param("user_id") int user_id);

    @Modifying
    @Query(value = "delete user",nativeQuery = true)
    int deleteAllUsersInTheDatabase();
}
