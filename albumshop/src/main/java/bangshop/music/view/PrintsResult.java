package bangshop.music.view;

import bangshop.music.model.dto.AlbumDTO;

import java.util.List;

//view에서 출력하는 것을 대체함
public class PrintsResult {

    public void printAlbumList(List<AlbumDTO> albumList){
        for(AlbumDTO album : albumList ){
            System.out.println(album);
        }
    }

    public void printAlbum(AlbumDTO album) {
        System.out.println(album);
    }

    public void printErrorMessage(String errorCode){

        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "앨범 목록 조회를 실패했습니다. "; break;
            case "selectOne" : errorMessage = "앨범 조회를 실패했습니다."; break;
            case "insert" : errorMessage = "앨범 삽입에 실패했습니다."; break;
            case "update" : errorMessage = "앨범 수정에 실패했습니다."; break;
            case "delete" : errorMessage = "앨범 삭제에 실패했습니다."; break;
            case "updateAlbumStorage" : errorMessage = "입고를 실패하였습니다.(update)"; break;
            case "insertAlbumStorage" : errorMessage = "입고를 실패하였습니다.(insert)"; break;
        }

        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successcode) {

        String successMessage = "";
        switch (successcode) {
            case "insert" : successMessage ="앨범 삽입에 성공하였습니다."; break;
            case "update" : successMessage ="앨범 수정에 성공하였습니다."; break;
            case "delete" : successMessage ="앨범 삭제에 성공하였습니다."; break;
            case "updateAlbumStorage" : successMessage = "입고를 성공하였습니다.(update)"; break;
            case "insertAlbumStorage" : successMessage = "입고를 성공하였습니다.(insert)"; break;
            //insertAlbumStorage

        }
    }
}
