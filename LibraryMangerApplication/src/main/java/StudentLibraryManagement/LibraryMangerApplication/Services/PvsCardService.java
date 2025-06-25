package StudentLibraryManagement.LibraryMangerApplication.Services;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.User;
import StudentLibraryManagement.LibraryMangerApplication.Repository.EarningCoinRepo;
import StudentLibraryManagement.LibraryMangerApplication.Repository.PvsCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PvsCardService {
    @Autowired
    PvsCardRepo pvsCardRepo;
    public void createPvsCard(User user){
        return;
    }


}
