package bangshop.music.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlbumStorageDTO {
    private Integer albumStorageNo;
    private Integer stock;
    private String albumNo;
    private Integer storageNo;

    public void stockDecrease(int quantity) {
        if (this.stock - quantity < 0) {
            throw new IllegalStateException("재고가 부족합니다.");
        }
        this.stock -= quantity;
    }
}
