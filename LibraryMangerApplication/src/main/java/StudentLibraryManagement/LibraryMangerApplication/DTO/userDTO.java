package StudentLibraryManagement.LibraryMangerApplication.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class userDTO {
    String name;
    String mail;
    String mobile;
    String country;
    String description;

}
