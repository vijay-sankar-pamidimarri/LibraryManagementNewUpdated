package StudentLibraryManagement.LibraryMangerApplication.Services;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.EarningCoin;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.PvsCard;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.User;
//import StudentLibraryManagement.LibraryMangerApplication.EmailSender.mailSender;
import StudentLibraryManagement.LibraryMangerApplication.EmailSender.mailSender123;
import StudentLibraryManagement.LibraryMangerApplication.Exceptions.userExceptions;
import StudentLibraryManagement.LibraryMangerApplication.Repository.UserRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import EmailSender;
import java.util.Optional;

@Service
public class UserService {
    final private UserRepo userRepo;
    final private static  Logger logs= LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Autowired
    mailSender123 mailSender123;





    public ResponseEntity<String> createUser(User user) {
        PvsCard pvsCard = new PvsCard();
        pvsCard.setNameOnCard(user.getUserName() + " PVS ORG");

        EarningCoin earningCoin = new EarningCoin();
        earningCoin.setAvailable(3);
        earningCoin.setDeducted(0);
        user.setPvsCard(pvsCard);
        earningCoin.setPvsCard(pvsCard);
        pvsCard.setEarningCoin(earningCoin);
      User u=  userRepo.save(user);
        return new ResponseEntity<>("User Added", HttpStatus.ACCEPTED);
    }



    public ResponseEntity<Page<User>> getAllUsers() {
       logs.info("Entered Into The Service Class GetAll users Method");
        Pageable pageable= PageRequest.of(2,3, Sort.by(Sort.Direction.ASC,"userName"));
        Page<User> p=userRepo.findAll(pageable);
        return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
    }


    public ResponseEntity<User> findById(int userId){
        logs.info("Fetching User Detail...Wait");
       boolean b= mailSender123.IsMailSend("sankerpamidimarri@gmail.com","Nothing","Just Body Matters");
        return new ResponseEntity<>(userRepo.findById(userId).orElseThrow(()->new userExceptions("No User Found Please Try With Another User")),HttpStatus.ACCEPTED);

    }


}
