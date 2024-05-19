package bangshop.music.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StoreDTO {
    private int storeNo;
    private String storeName;
    private String storeAddress;
    private int employeeNo;
    private StorageDTO storage;
}
