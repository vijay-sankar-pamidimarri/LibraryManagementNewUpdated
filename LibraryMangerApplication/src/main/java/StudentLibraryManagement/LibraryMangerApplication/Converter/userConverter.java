package StudentLibraryManagement.LibraryMangerApplication.Converter;

import StudentLibraryManagement.LibraryMangerApplication.DTO.userDTO;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.User;

public class userConverter {
    public static User user(userDTO userdto){
        return User.builder()
                .userName(userdto.getName())
                .mail(userdto.getMail())
                .country(userdto.getCountry())
                .Description(userdto.getDescription())
                .mobilenum(userdto.getMobile())
               .build();
    }

}
