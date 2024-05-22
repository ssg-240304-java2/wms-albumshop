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

    public AlbumStorageDTO(Integer albumStorageNo, Integer stock, String albumNo, Integer storageNo) {
        this.albumStorageNo = albumStorageNo;
        this.stock = stock;
        this.albumNo = albumNo;
        this.storageNo = storageNo;
    }

    public static AlbumStorageDTO from(OrderDTO order) {
        return new AlbumStorageDTO(
                null,
                order.getQuantity(),
                order.getAlbumNo(),
                order.getStore().getStorageNo()
        );
    }

    public void increaseStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalStateException("재고가 0개 이상이어야 합니다.");
        }
        this.stock += quantity;
    }

    public void decreaseStock(int quantity) {
        if (this.stock - quantity < 0) {
            throw new IllegalStateException("재고 수량이 부족합니다.");
        }
        this.stock -= quantity;
    }

    @Override
    public String toString() {
        return
                "앨범명 : " + albumName  +
                        ", 재고수량  : " + stock;
    }

    public String adminToString() {
        return
                "앨범번호 : " + albumNo +
                ", 앨범명 : " + albumName  +
                        ", 재고수량  : " + stock;
    }
}
