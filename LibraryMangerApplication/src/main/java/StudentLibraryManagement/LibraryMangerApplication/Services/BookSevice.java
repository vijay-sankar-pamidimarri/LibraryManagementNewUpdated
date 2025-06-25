package StudentLibraryManagement.LibraryMangerApplication.Services;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.Book;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.PvsCard;
import StudentLibraryManagement.LibraryMangerApplication.Repository.BookRepo;
import StudentLibraryManagement.LibraryMangerApplication.Repository.PvsCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookSevice {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    EarningCoinService earningCoinService;

    public int checkBookISExisted(Book book){
        return bookRepo.checkBookIsExisted(book.getBookId(),book.getBookName());
    }


//    --this is for the updtng the or adding the book into the book table
    @Autowired
    PvsCardRepo pvsCardRepo;
    public String AddingBook(int card_id,Book book){
        PvsCard pvsCard=pvsCardRepo.findByIdPvsCard(card_id);
        if(pvsCard==null){
            return "Please Provide Valid Card_id";
        }
        book.setPvsCard(pvsCard);
        bookRepo.save(book);
        return  "Book Saved Sucessfully";
    }

//    Providing the link to the ser to acess the bokk details


    public String sharingTheLink(int book_id){
        Book book=bookRepo.findByIdBookId(book_id);
        return book.getActiveLink();
    }

    public boolean canIRent(boolean value){
        return value;
    }


//    This is for the processing of the payment
    public String payMentProcessing(PvsCard pvsCard,Book book,String transaction_Type){

        String result=earningCoinService.doTransformation(pvsCard.getUser().getUserId(),bookRepo.findByIdBookId((int) book.getBookId()).getPvsCard().getUser().getUserId(),transaction_Type);

        return "Payment is Sucess";
    }
}
