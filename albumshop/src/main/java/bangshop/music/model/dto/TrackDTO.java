package bangshop.music.model.dto;

import java.util.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrackDTO {
    private String trackNo;
    private Date trackName;
    private String url;
    private String albumNo;
}
