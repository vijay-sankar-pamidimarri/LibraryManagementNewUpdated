package StudentLibraryManagement.LibraryMangerApplication.Dialect.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int bookId;
    String bookName;
    int noOfPages;
    @Column(nullable = false)
    String activeLink;
    @Column(nullable = false)
    String authorName;
    @Column(nullable = false)
    String title;
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    String catgeory;


//    Relationships
     @ManyToOne
     @JoinColumn(name = "pvsCard")
     PvsCard pvsCard;


}
