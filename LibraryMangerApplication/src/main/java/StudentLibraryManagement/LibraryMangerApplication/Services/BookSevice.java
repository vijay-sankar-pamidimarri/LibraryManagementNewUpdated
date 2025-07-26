package StudentLibraryManagement.LibraryMangerApplication.Services;

import StudentLibraryManagement.LibraryMangerApplication.DTO.bookDTO;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.Book;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.PvsCard;
import StudentLibraryManagement.LibraryMangerApplication.Exceptions.bookExceptions;
import StudentLibraryManagement.LibraryMangerApplication.Repository.BookRepo;
import StudentLibraryManagement.LibraryMangerApplication.Repository.PvsCardRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class BookSevice {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    EarningCoinService earningCoinService;

    public int checkBookISExisted(Book book){
        return bookRepo.checkBookIsExisted(book.getBookId(),book.getBookName());
    }

//    --this is for the updtng the or adding the book into the book table
    @Autowired
    PvsCardRepo pvsCardRepo;


    /*
        All these are Create Operations
     */
    public Book createBook(bookDTO bookDTO) {
        Book book= StudentLibraryManagement.LibraryMangerApplication.Converter.bookConverter.book(bookDTO);
        log.info("This is From rthr Controller class  :" +book.getActiveLink());
        Book b =bookRepo.save(book);
        System.out.println(b.getActiveLink()+"  ");
        return b;
    }



    /*
       Reading-this is for the Searching the data

     */

    public Book getBookById(int id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new bookExceptions("Book not found with id: " + id));
    }


    public List<Book> getAll() {
        List<Book> all=bookRepo.findAll();
        if(all.size()==0){
            throw new bookExceptions("No Book Is Found");
        }
        return all;
    }





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


    public ResponseEntity<Book> deleteBookById(int id) {
       Book book=getBookById(id);
       bookRepo.deleteById(id);
       return new ResponseEntity<>(book,HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<Book> updateById(bookDTO bookDTO,int id) {
        log.info("This is from Update class "+bookDTO.getBookName() +"   "+bookDTO.getActiveLink());

        Book book=getBookById(id);
        bookRepo.updateById(bookDTO.getBookName(),bookDTO.getAuthorName(),bookDTO.getTitle(),bookDTO.getCatgeory(),bookDTO.getActiveLink(),id);
        return new ResponseEntity<>(getBookById(id),HttpStatusCode.valueOf(200));
    }
}
