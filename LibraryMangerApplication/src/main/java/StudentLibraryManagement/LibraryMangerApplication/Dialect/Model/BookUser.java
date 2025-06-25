package StudentLibraryManagement.LibraryMangerApplication.Dialect.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BookUser")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookUser {
    @Id
    int bookid;
    long userid;
}
