package bangshop.music.controller;

import bangshop.music.model.dao.StockInMapper;
import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.dto.stock.InsertStockRequest;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class dbTest {
    private SqlSession sqlSession;
    private StockInMapper mapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.mapper = this.sqlSession.getMapper(StockInMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    // CRUD
    @DisplayName("앨범추가")
    @Test
    void insertAlbum() {
        String albumNo = "ALBUM_NO2";
        String albumName = "ALBUM_NAME";
        String singer = "ALBUM_SINGER";
        Date releaseDate = Date.valueOf("2023-05-07");
        int price = 50000;
        AlbumDTO album = new AlbumDTO(albumNo, albumName, singer, releaseDate, price);

        // When
        Integer result = mapper.insertAlbum(album);

        // Then
        assertThat(result).isEqualTo(1); // Expecting the result to be 1 if the insert was successful
    }

    @DisplayName("앨범창고에 해당 앨범 존재 여부 확인")
    @Test
    void isExistAlbumInStorage() {
        String albumNo = "ALBUM_NO3";
        boolean result = mapper.isExistAlbumInStorage(albumNo);

        assertThat(result).isFalse();
    }

    @DisplayName("앨범창고에 새로운 앨범 입고")
    @Test
    void insertAlbumStorage() {
        int stock = 500;
        String albumNo = "ALBUM_NO3";

        // First, insert the album into the album table
        AlbumDTO album = new AlbumDTO(albumNo, "ALBUM_NAME", "ALBUM_SINGER", Date.valueOf("2023-05-07"), 50000);
        mapper.insertAlbum(album);

        // Then, insert the stock into the stock_in table
        InsertStockRequest request = new InsertStockRequest(albumNo, stock);
        int result = mapper.insertAlbumStorage(request.getAlbumNo(), request.getQuantity());

        assertThat(result).isEqualTo(1); // Expecting the result to be 1 if the insert was successful
    }

    @DisplayName("입고내역 추가")
    @Test
    void createStock() {
        String albumNo = "ALBUM_NO3";
        int quantity = 450;

        // First, insert the album into the album table
        AlbumDTO album = new AlbumDTO(albumNo, "ALBUM_NAME", "ALBUM_SINGER", Date.valueOf("2023-05-07"), 50000);
        mapper.insertAlbum(album);

        // Then, create the stock
        InsertStockRequest request = new InsertStockRequest(albumNo, quantity);
        int result = mapper.createStock(request.getAlbumNo(), request.getQuantity());

        assertThat(result).isEqualTo(1);
    }
}
