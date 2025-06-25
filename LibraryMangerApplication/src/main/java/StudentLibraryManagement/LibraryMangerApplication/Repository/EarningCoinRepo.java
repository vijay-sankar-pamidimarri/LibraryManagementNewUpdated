package StudentLibraryManagement.LibraryMangerApplication.Repository;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.EarningCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EarningCoinRepo extends JpaRepository<EarningCoin,Integer> {

    @Modifying
    @Query("select available from EarningCoin where pvsCard.pvsCardId=:card_id")
    int getCoinsForThisUser(@Param("card_id") int card_id);
//    @Query("update table EarningCoin set available")
//    void updateTheCoinsOncard_id(int srcCardId, int tarCardId);

//    updating the coind to the diffrent user from strc to target
    @Modifying
    @Query(value = "update earning_coin e set available=:coins where coin_id=:coin_id",nativeQuery = true)
    int  UpdatingTheCoinOfTheUser(@Param("coin_id") int coin_id,@Param("coins") int coins);



//    This is for getting The Coin Details

    @Modifying
    @Query(value = "select * from earning_coin where coin_id=:coin_id",nativeQuery = true)
    EarningCoin getDetailsOfTheCoin(@Param("coin_id") int coin_id);


//    This is for getting no of coins deducted

    @Modifying
    @Query(value = "select deducted from earning_coin where coin_id=:coin_id",nativeQuery = true)
    int getDetuctedCoins(@Param("coin_id") int coin_id);
}
