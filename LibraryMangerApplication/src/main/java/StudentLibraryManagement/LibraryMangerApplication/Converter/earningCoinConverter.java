package StudentLibraryManagement.LibraryMangerApplication.Converter;

import StudentLibraryManagement.LibraryMangerApplication.DTO.earningCoinDTO;
import StudentLibraryManagement.LibraryMangerApplication.Dialect.Model.EarningCoin;

public class earningCoinConverter {
    public static EarningCoin earningCoin(earningCoinDTO earningCoinDTO){
        return EarningCoin.builder()
                .available(earningCoinDTO.getAvailable())
                .deducted(earningCoinDTO.getDeducted())
                .build();
    }
}
