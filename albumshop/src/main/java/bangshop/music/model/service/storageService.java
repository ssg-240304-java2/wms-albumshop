package bangshop.music.model.service;

import bangshop.music.model.dao.Mapper;
import bangshop.music.model.dto.StockInDTO;
import bangshop.music.model.dto.stock.GetStockRequest;
import bangshop.music.model.dto.stock.InsertStockRequest;
import bangshop.music.view.PrintsResult;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class storageService {

    private Mapper mapper;
    private PrintsResult printsResult;

    public storageService() {
        printsResult = new PrintsResult();
    }



    public void insertStock(InsertStockRequest request) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(Mapper.class);

        // 1. 사용자가 요청한 앨범 번호가 앨범에 있는지 체크 -> 잘못된 번호입니다! 에러던지기
        if(!mapper.isExistAlbum(request.getAlbumNo())){
            System.out.println("잘못된 앨범 번호입니다! ");
            throw new RuntimeException("No Album");

        }

        // 2. 해당 스토리지에 앨범 기록 체크
        if (mapper.isExistAlbumInStorage(request.getAlbumNo())) {
            int result = mapper.updateAlbumStorage(request.getAlbumNo(), request.getQuantity());
            if (result > 0 ) {
                String message = printsResult.printSuccessMessage("updateAlbumStorage");
                System.out.println("message = " + message);
                sqlSession.commit();
            } else {
                String message = printsResult.printErrorMessage("updateAlbumStorage");
                System.out.println("message = " + message);
                sqlSession.rollback();
            }
        } else {
            int result = mapper.insertAlbumStorage(request.getAlbumNo(), request.getQuantity());
            if (result > 0 ) {
                String message = printsResult.printSuccessMessage("insertAlbumStorage");
                System.out.println("message = " + message);
                sqlSession.commit();
            } else {
                String message =  printsResult.printErrorMessage("insertAlbumStorage");
                System.out.println("message = " + message);
                sqlSession.rollback();
            }

        }

        // 3. 입고를 넣어준다.
        int result = mapper.createStock(request.getAlbumNo(), request.getQuantity());
        if (result > 0) {
            String message =  printsResult.printSuccessMessage("insertStockIn");
            System.out.println("message = " + message);
            sqlSession.commit();
        } else {
            String message = printsResult.printErrorMessage("insertStockIn");
            System.out.println("message = " + message);
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    //입고내역 조회
    public List<StockInDTO> getStockList(StockInDTO request) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(Mapper.class);

        List<StockInDTO> result = mapper.getStockList(request);

        if(result != null && result.size() > 0) {
            for(StockInDTO stockIn : result){
                System.out.println(stockIn);
            }
        } else {
            System.out.println("조회결과가 존재하지 않습니다.");
        }

        sqlSession.close();

        return result;
    }
}
