package StudentLibraryManagement.LibraryMangerApplication.Converter;

import StudentLibraryManagement.LibraryMangerApplication.DTO.bookDTO;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.Book;

public class bookConverter {
    public static Book book(bookDTO bookdto){
        return Book.builder()
                .bookName(bookdto.getBookName())
                .noOfPages(100)
                .activeLink(bookdto.getActiveLink())
                .authorName(bookdto.getAuthorName())
                .title(bookdto.getTitle())
                .catgeory(bookdto.getTitle())
                .build();
    }
}
