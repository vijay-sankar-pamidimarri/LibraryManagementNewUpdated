package StudentLibraryManagement.LibraryMangerApplication.Controller;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.User;
import StudentLibraryManagement.LibraryMangerApplication.Exceptions.userExceptions;
import StudentLibraryManagement.LibraryMangerApplication.Services.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
//import java.util.logging.Logger;
//@Controller
@RestController
@RequestMapping("Library-manager")
public class userController {

    final private UserService userService;
    private static final Logger logs = LoggerFactory.getLogger(userController.class);

    //    comment is added
    public userController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String testingLibrary(@RequestParam(required = false,defaultValue = "vijay") String name,@RequestParam("age") int age){
        return name+" Hi Library Manger Working Good";
    }



    @PostMapping("create/user")
    public ResponseEntity<String> CreateUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Page<User>> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id){

        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
