package StudentLibraryManagement.LibraryMangerApplication.Services;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.EarningCoin;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.User;
import StudentLibraryManagement.LibraryMangerApplication.Repository.EarningCoinRepo;
import StudentLibraryManagement.LibraryMangerApplication.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EarningCoinService {
    @Autowired
    EarningCoinRepo earningCoinRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PvsCardService pvsCardService;
    public void createCoinAccount(User user){
         return;
    }


//    getting the no of coins

    public int getCoinsForThisUser(int card_id){
        return earningCoinRepo.getCoinsForThisUser(card_id);
    }


    //check is eligible to add the ReantThe Book
    public boolean isEligibleToRentBook(int card_id){
        int val=getCoinsForThisUser(card_id);
        if(val>=5){
            return true;
        }
        return false;
    }

    //checking for the is eligible to buy the book
    public boolean isEligibleToBuyBook(int card_id){
        int val=getCoinsForThisUser(card_id);
        if(val>=10){
            return true;
        }
        return false;
    }


//This is for the transaction only for the add.

public String doTransformation(int src_id){
    earningCoinRepo.UpdatingTheCoinOfTheUser(src_id,earningCoinRepo.getCoinsForThisUser(src_id)+1);
    return "Transaction is Done";

}

//This is for the transaction exchanging the coined to src to Target.

 public String doTransformation(int src_id,int tar_id,String Transaction_Type){
        int val=Transaction_Type.equals("Rent")?2:5;

        earningCoinRepo.UpdatingTheCoinOfTheUser(src_id,earningCoinRepo.getCoinsForThisUser(src_id)-val);
        earningCoinRepo.UpdatingTheCoinOfTheUser(tar_id,earningCoinRepo.getCoinsForThisUser(src_id)+val);

        return "Transaction Is Sucess";
 }


}
