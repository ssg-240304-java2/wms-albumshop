package bangshop.music.model.dto.stock;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InsertStockRequest {
    private String albumNo;
    private Integer quantity;
}
