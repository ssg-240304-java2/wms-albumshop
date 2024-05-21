package bangshop.music.controller;

import bangshop.music.model.dao.SearchMapper;
import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.dto.OrderDTO;
import bangshop.music.model.service.SearchService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.mockStatic;
import bangshop.music.common.MyBatisTemplate;
import org.junit.jupiter.api.DisplayName;

public class scTest {

    @Mock
    private SqlSession sqlSession;

    @Mock
    private SearchMapper searchMapper;

    @InjectMocks
    private SearchService searchService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(sqlSession.getMapper(SearchMapper.class)).thenReturn(searchMapper);

    }

    private Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("앨범을 앨범명으로 검색하는 테스트")
    @Test
    public void testSearchAlbumByTitle() {
        AlbumDTO album1 = new AlbumDTO("1737365431", "Midas Touch - Single", "Kiss of Life", parseDate("2024-04-03"), 46000);
        when(searchMapper.searchAlbumByTitle("Midas Touch")).thenReturn(Arrays.asList(album1));

        try (MockedStatic<MyBatisTemplate> mockedStatic = mockStatic(MyBatisTemplate.class)) {
            mockedStatic.when(MyBatisTemplate::getSqlSession).thenReturn(sqlSession);

            List<AlbumDTO> albums = searchService.searchAlbumByTitle("Midas Touch");
            assertEquals(1, albums.size());
            assertEquals("Midas Touch - Single", albums.get(0).getAlbumName());
        }
    }

    @DisplayName("앨범을 앨범번호로 검색하는 테스트")
    @Test
    public void testSearchAlbumByNo() {
        AlbumDTO album1 = new AlbumDTO("1737365431", "Midas Touch - Single", "Kiss of Life", parseDate("2024-04-03"), 46000);
        when(searchMapper.searchAlbumByNo("1737365431")).thenReturn(Arrays.asList(album1));

        try (MockedStatic<MyBatisTemplate> mockedStatic = mockStatic(MyBatisTemplate.class)) {
            mockedStatic.when(MyBatisTemplate::getSqlSession).thenReturn(sqlSession);

            List<AlbumDTO> albums = searchService.searchAlbumByNo("1737365431");
            assertEquals(1, albums.size());
            assertEquals("1737365431", albums.get(0).getAlbumNo());
        }
    }

    @DisplayName("앨범을 가수로 검색하는 테스트")
    @Test
    public void testSearchAlbumBySinger() {
        AlbumDTO album1 = new AlbumDTO("1737365431", "Midas Touch - Single", "Kiss of Life", parseDate("2024-04-03"), 46000);
        AlbumDTO album2 = new AlbumDTO("1734501146", "SUPER REAL ME - EP2", "아일릿", parseDate("2024-03-25"), 17000);
        when(searchMapper.searchAlbumBySinger("Kiss of Life")).thenReturn(Arrays.asList(album1));

        try (MockedStatic<MyBatisTemplate> mockedStatic = mockStatic(MyBatisTemplate.class)) {
            mockedStatic.when(MyBatisTemplate::getSqlSession).thenReturn(sqlSession);

            List<AlbumDTO> albums = searchService.searchAlbumBySinger("Kiss of Life");
            assertEquals(1, albums.size());
            assertEquals("Kiss of Life", albums.get(0).getSinger());
        }
    }

    @DisplayName("앨범을 목록에서 검색하는 테스트")
    @Test
    public void testSearchAllAlbum() {
        AlbumDTO album1 = new AlbumDTO("1737365431", "Midas Touch - Single", "Kiss of Life", parseDate("2024-04-03"), 46000);
        AlbumDTO album2 = new AlbumDTO("1734501146", "SUPER REAL ME - EP2", "아일릿", parseDate("2024-03-25"), 17000);
        when(searchMapper.searchAllAlbum()).thenReturn(Arrays.asList(album1, album2));

        try (MockedStatic<MyBatisTemplate> mockedStatic = mockStatic(MyBatisTemplate.class)) {
            mockedStatic.when(MyBatisTemplate::getSqlSession).thenReturn(sqlSession);

            List<AlbumDTO> albums = searchService.searchAllAlbum();
            assertEquals(2, albums.size());
        }
    }
}
