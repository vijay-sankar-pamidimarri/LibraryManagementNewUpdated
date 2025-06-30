package StudentLibraryManagement.LibraryMangerApplication.Controller;

import StudentLibraryManagement.LibraryMangerApplication.DTO.bookDTO;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.Book;
import StudentLibraryManagement.LibraryMangerApplication.Services.BookSevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Library-Manger-Book")
public class BookController {

    //this most efficient way to create the object only once
    private final BookSevice bookSevice ;
    BookController(BookSevice bookSevice){
        this.bookSevice=bookSevice;
    }
    /*
        There are 4 modules operations on this class
        CRUD -create,Update,Update,Delete
     */

    /*
         Create Operations we would had only one API to Do this
     */
    @PostMapping("/CreateBook")
    public ResponseEntity<String> createBook(bookDTO bookDTO){
        Book book= bookSevice.createBook(bookDTO);
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    /*
        This is for the search operation

     */

    @GetMapping("/search/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        return new ResponseEntity<>(bookSevice.getBookById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(bookSevice.getAll(),HttpStatus.OK);
    }

}
