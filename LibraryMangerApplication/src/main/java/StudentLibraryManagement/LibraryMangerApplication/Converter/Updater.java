package StudentLibraryManagement.LibraryMangerApplication.Converter;

import StudentLibraryManagement.LibraryMangerApplication.DTO.bookDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Updater {
    bookDTO bookDTo;
    int id;
}
