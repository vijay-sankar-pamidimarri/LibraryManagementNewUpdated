package StudentLibraryManagement.LibraryMangerApplication.Controller;

import StudentLibraryManagement.LibraryMangerApplication.Converter.Updater;
import StudentLibraryManagement.LibraryMangerApplication.DTO.bookDTO;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.Book;
import StudentLibraryManagement.LibraryMangerApplication.Services.BookSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Library-Manger-Book")
@Slf4j
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
    public ResponseEntity<Book> createBook(@RequestBody  bookDTO bookDTO){
        log.info("This is From rthr Controller class  :" +bookDTO.getBookName()+"   "+bookDTO.getActiveLink());
        Book book= bookSevice.createBook(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.OK);
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
    @PostMapping("/deleteById")
    public ResponseEntity<Book> deleteById(@RequestBody Map<String,Integer> map){
        return bookSevice.deleteBookById(map.get("id"));
    }

    @PutMapping("/updateById")
    public ResponseEntity<Book> updateById(@RequestBody Updater update){
        log.info("This is from Update class " +update.getBookDTo());

        return bookSevice.updateById(update.getBookDTo(), update.getId());
    }
        @GetMapping("/run")
        public String test(){
        return "App is Running";
        }

        @GetMapping("/frontend")
        public String frontend(){
           return "This IS From Spring Boot";
        }

}
