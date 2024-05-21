package bangshop.music.model.dto;


import java.util.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter

@ToString
public class AlbumDTO {
    private String albumNo;
    private String albumName;
    private String singer;
    private Date releaseDate;
    private int price;

    public AlbumDTO(String albumNo, String albumName, String singer, Date releaseDate, int price) {
        this.albumNo = albumNo;
        this.albumName = albumName;
        this.singer = singer;
        this.releaseDate = releaseDate;
        this.price = price;
    }
}
