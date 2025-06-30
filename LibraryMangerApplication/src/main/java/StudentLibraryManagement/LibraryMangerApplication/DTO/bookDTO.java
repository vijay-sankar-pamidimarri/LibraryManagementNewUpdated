package StudentLibraryManagement.LibraryMangerApplication.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class bookDTO {
    int bookid;
    String bookName;
    String ActiveLink;
    String authorName;
    String title;
    String catgeory;
}
