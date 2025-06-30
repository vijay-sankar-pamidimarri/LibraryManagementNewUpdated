package StudentLibraryManagement.LibraryMangerApplication;

import StudentLibraryManagement.LibraryMangerApplication.Exceptions.bookExceptions;
import StudentLibraryManagement.LibraryMangerApplication.Exceptions.userExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GobalControllerAdvice {
    @ExceptionHandler(userExceptions.class)
    public ResponseEntity<String> userException(userExceptions u){
        return new ResponseEntity<>(u.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(bookExceptions.class)
    public ResponseEntity<String> bookException(bookExceptions b){
        return new ResponseEntity<>(b.getMessage(),HttpStatus.NOT_FOUND);
    }
}
