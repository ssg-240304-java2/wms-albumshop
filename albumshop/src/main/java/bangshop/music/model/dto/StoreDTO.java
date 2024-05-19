package bangshop.music.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {
    int storeNo;
    String storeName;
    String storeAddress;
    int employeeNo;
    int storageNo;
    String name;

    @Override
    public String toString() {
        return  "지점명: " + storeName + ", " +
                "주소: " + storeAddress + ", " +
                "점장명: " + name;
    }
}
