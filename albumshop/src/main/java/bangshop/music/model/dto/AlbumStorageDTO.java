package bangshop.music.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumStorageDTO {
    private Integer albumStorageNo;
    private Integer stock;
    private String albumNo;
    private Integer storageNo;
    private Integer employeeNo;
    private String storeName;
    private String albumName;
    public void stockDecrease(int quantity) {
        if (this.stock - quantity < 0) {
            throw new IllegalStateException("재고가 부족합니다.");
        }
        this.stock -= quantity;
    }

    @Override
    public String toString() {
        return
                "앨범명 : '" + albumName + '\'' +
                        ", 재고수량  : " + stock;
    }
}
