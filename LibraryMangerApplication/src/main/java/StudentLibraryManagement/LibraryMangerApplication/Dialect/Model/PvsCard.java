package StudentLibraryManagement.LibraryMangerApplication.Dialect.Model;

import StudentLibraryManagement.LibraryMangerApplication.Enum.countryEnum.pvsCard;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PvsCard")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PvsCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int pvsCardId;
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    String nameOnCard;


//    relationships
    @OneToOne
    @JoinColumn(name = "userid")
    User user;


    @OneToMany(mappedBy = "pvsCard",cascade = CascadeType.ALL)
    List<Book> book;

    @OneToOne(mappedBy = "pvsCard",cascade = CascadeType.ALL)
    EarningCoin earningCoin;

}
