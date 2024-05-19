package bangshop.music.model.dto.stock;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetStockRequest {
    private String albumNo;
    private Long storageNo;
}
