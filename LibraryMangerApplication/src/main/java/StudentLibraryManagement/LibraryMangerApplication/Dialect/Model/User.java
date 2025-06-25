package StudentLibraryManagement.LibraryMangerApplication.Dialect.Model;

import StudentLibraryManagement.LibraryMangerApplication.Enum.countryEnum.country;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO   )
   int userId;
    @Column(nullable = false)
    String userName;
    @Column(nullable = true,unique = true)
    String mail;
    @Column(nullable = false,unique = true)
    String mobilenum;
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    String country;
    String Description;

//    RelationsShips

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    PvsCard pvsCard;

    public  String getmobilenum(){
        return mobilenum;
    }

    public String getUserName() {
        return userName;
    }


}
