package bangshop.music.controller;

import bangshop.music.model.dao.StockInMapper;
import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.dto.stock.InsertStockRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.Date;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;


public class dbTest{
    private SqlSession sqlSession;
    StockInMapper mapper;
    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.mapper = this.sqlSession.getMapper(StockInMapper.class);
    }

    @AfterEach
    void tearDown() {
//        this.sqlSession.commit(); // 생략해도 Sqlsession해제시 자동커밋된다.
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    //CRUD
    @DisplayName("앨범추가")
    @Test
    void insertAlbum(){
        String albumNo = "ALBUM_NO2";
        String albumName = "ALBUM_NAME";
        String singer = "ALBUM_SINGER";
        Date release_date = Date.valueOf( "2023-05-07" );
        int price = 50000 ;
        AlbumDTO album = new AlbumDTO(albumNo, albumName,singer,release_date,price);
        //when
        Integer result = mapper.insertAlbum(album);
        //Then
        assertThat(result);
    }

    @DisplayName("앨범창고에 해당 앨범 존재 여부 확인")
    @Test
    void isExistAlbumInStorage() {
        String album_no = "ALBUM_NO3";
        boolean result = mapper.isExistAlbumInStorage(album_no);

        assertThat(result).isEqualTo(false);
    }


    @DisplayName("앨범창고에 새로운 앨범 입고")
    @Test
    void insertAlbumStorage() {
        int stock = 500;
        String album_no = "ALBUM_NO3";

        InsertStockRequest request = new InsertStockRequest(album_no,stock);
        int result = mapper.insertAlbumStorage(request.getAlbumNo(), request.getQuantity());

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("입고내역 추가")
    @Test
    void createStock() {
        String albumNo = "ALBUM_NO3";
        int quantity = 450;

        InsertStockRequest request = new InsertStockRequest(albumNo, quantity);

        int result = mapper.createStock(request.getAlbumNo(), request.getQuantity());

        assertThat(result).isEqualTo("true");
    }





}