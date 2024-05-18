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
}
