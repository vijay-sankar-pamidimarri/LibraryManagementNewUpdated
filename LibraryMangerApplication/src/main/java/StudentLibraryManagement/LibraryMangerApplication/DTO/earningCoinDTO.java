package StudentLibraryManagement.LibraryMangerApplication.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class earningCoinDTO {
    long available;
    long deducted;
}
