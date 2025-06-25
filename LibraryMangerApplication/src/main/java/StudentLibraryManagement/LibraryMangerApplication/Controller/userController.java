package StudentLibraryManagement.LibraryMangerApplication.Controller;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.User;
import StudentLibraryManagement.LibraryMangerApplication.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraray-manager")
@Slf4j
public class userController {

    @Autowired
    final private UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String testingLibrary(@RequestParam(required = false,defaultValue = "vijay") String name,@RequestParam("age") int age){
        return name+" Hi Library Manger Working Good";
    }



    @PostMapping("create/user")
    public String CreateUser(@RequestBody User user){

        return userService.createUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        log.info("Enterd into Controller Class and GetALlUSers ethod");
        return userService.getAllUsers();
    }
}
