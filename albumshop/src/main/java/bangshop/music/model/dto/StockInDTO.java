package bangshop.music.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockInDTO {
    private Integer stockInNo;
    private Integer quantity;
    private Date stockInDate;
    private Integer storageAdminNo;
    private String albumNo;
    private Integer storageNo;

    @Override
    public String toString() {
        return "입고내역 [" +
                "입고번호=" + stockInNo +
                ", 수량=" + quantity +
                ", 입고날짜=" + stockInDate +
                ", 창고관리자 번호=" + storageAdminNo +
                ", 앨범번호='" + albumNo + '\'' +
                ", 창고번호=" + storageNo +
                ']';
    }
}
