package StudentLibraryManagement.LibraryMangerApplication.Dialect.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EarningCoin")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class EarningCoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int coinId;
    long available;
    long deducted;

    @OneToOne
    @JoinColumn(name="earningCoin")
    PvsCard pvsCard;
}
