package StudentLibraryManagement.LibraryMangerApplication.Services;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.EarningCoin;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.PvsCard;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.User;
import StudentLibraryManagement.LibraryMangerApplication.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepo userRepo;
    public String createUser(User user) {
        EarningCoin earningCoin=new EarningCoin();

        earningCoin.setCoinId(user.getUserId());
        earningCoin.setDeducted(0);
        earningCoin.setAvailable(3);

        PvsCard pvsCard=new PvsCard();
        pvsCard.setPvsCardId(user.getUserId());
        pvsCard.setNameOnCard(user.getUserName()+" PVS ORG");
        pvsCard.setEarningCoin(earningCoin);


        pvsCard.setUser(user);
        earningCoin.setPvsCard(pvsCard);
        user.setPvsCard(pvsCard);
        pvsCard.setEarningCoin(earningCoin);
        userRepo.save(user);

        return "User Is Created Sucessully";
    }

    public List<User> getAllUsers() {
       log.info("Entered Into The Service Class GetAll users Method");
       return userRepo.getAllUsers();
    }
}
