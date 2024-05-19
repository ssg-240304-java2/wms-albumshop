package bangshop.music.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
    private int orderNo;
    private String orderDate;
    private Integer quantity;
    private Integer totalPrice;
    private String albumNo;
    private StoreDTO store;
}
