package StudentLibraryManagement.LibraryMangerApplication.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class bookDTO {

    String bookName;

    @JsonProperty("ActiveLink")  //
    String ActiveLink;

    String authorName;
    String title;
    String catgeory;
}
