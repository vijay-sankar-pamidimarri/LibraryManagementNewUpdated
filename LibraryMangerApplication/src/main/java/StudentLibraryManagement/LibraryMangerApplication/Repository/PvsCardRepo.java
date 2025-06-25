package StudentLibraryManagement.LibraryMangerApplication.Repository;

import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.PvsCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PvsCardRepo extends JpaRepository<PvsCard,Integer> {


    @Query("select PvsCard from PvsCard where pvsCardId=:card_id")
    public PvsCard findByIdPvsCard(@Param("cardid") int card_id);
}
