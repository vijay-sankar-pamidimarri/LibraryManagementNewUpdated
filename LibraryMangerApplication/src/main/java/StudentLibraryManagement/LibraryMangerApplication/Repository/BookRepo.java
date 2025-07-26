package StudentLibraryManagement.LibraryMangerApplication.Repository;

import StudentLibraryManagement.LibraryMangerApplication.DTO.bookDTO;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {


    @Query(value = "select count(b) from Book b where book_id=:bookid or bookname=:bookname", nativeQuery = true)
    public int checkBookIsExisted(@Param("bookid") long bookId, @Param("bookname") String bookName);


    @Query("select Book from Book where bookId=:bookid")
    Book findByIdBookId(@Param("bookid") int bookId);


    //   getting all the books information
    @Query("select Book from Book")
    List<Book> getAllBooks();


    //get all the books order by pages desc;
    @Query("select Book from Book b order by b.noOfPages desc")
    List<Book> getAllBooksInDesc();


    //get all the books order by pages Asc
    @Query("select Book from Book b order by b.noOfPages Asc")
    List<Book> getAllBooksInAsc();


    //delete the book with the bookid
    @Modifying
    @Query(value = "delete from Book where book_id=:book_id", nativeQuery = true)
    int deleteTheBookByBookId(@Param("book_id") int book_id);

    @Modifying
    @Transactional
    @Query(value = "update book set book_name=:bookName,author_name=:authorName,title=:title,catgeory=:catgeory,active_link=:activeLink where book_id=:id",nativeQuery = true)
    int updateById(String bookName, String authorName, String title, String catgeory, String activeLink, int id);

//    @Modifying
//    @Transactional
//    @Query("UPDATE Book b SET b.bookName = :bookName, b.authorName = :authorName, b.title = :title, b.category = :category, b.activeLink = :activeLink WHERE b.bookId = :id")
//    void updateById(@Param("bookName") String bookName,
//                        @Param("authorName") String authorName,
//                        @Param("title") String title,
//                        @Param("category") String category,
//                        @Param("activeLink") String activeLink,
//                        @Param("id") int id);
//

}