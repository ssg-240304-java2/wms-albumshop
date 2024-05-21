package bangshop.music.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private int orderNo;
    private String orderDate;
    private Integer quantity;
    private Integer totalPrice;
    private String albumNo;
    private String storeName;
    private String albumName;
    private StoreDTO store;

    @Override
    public String toString() {
        return
                "주문번호 : " + orderNo +
                        ", 주문날짜 : " + orderDate +
                        ", 가맹점명 : " + storeName +
                        ", 앨범명 : " + albumName +
                        ", 주문수량 : " + quantity +
                        ", 총 금액 : " + totalPrice;
    }
}
