package bangshop.music.model.dto;


import java.util.*;
import lombok.*;

@NoArgsConstructor
@Getter

@ToString
public class AlbumDTO {
    private String albumNo;
    private String albumName;
    private String singer;
    private Date releaseDate;
    private int price;

    public AlbumDTO(String albumNo, String albumName, String singer, Date releaseDate, double price) {
        this.albumNo = albumNo;
        this.albumName = albumName;
        this.singer = singer;
        this.releaseDate = releaseDate;
        this.price = (int) Math.round(price * 1.3) * 1000;
    }
}
