# HeadBang- AlbumShop

## 🎼 `프로젝트 소개`
**앨범 재고 관리 프로그램으로, 창고 관리자는 앨범 입고/출고를 통해 본사창고를 관리하고 
가맹점주는 본사로 앨범을 주문해 매장의 재고를 관리합니다.** 
<br>

## 🕰️ `개발 기간`
* 24.05.16일 - 24.05.21일

### 🧑‍🤝‍🧑 `멤버구성`
 - 팀원1 : 김다빈 - 입고 관리  
 - 팀원2 : 노영록 - 출고 관리 
 - 팀원3 : 송재혁 - 창고 및 가맹점 재고 조회, 주문 내역 조회  
 - 팀원4 : 육슬찬 - 앨범 검색, 앨범 조회, 앨범 주문  
 - 팀원5 : 이창연 - 로그인, 계정 관리, 직원 조회, 지점 조회

### ⚙️ `개발 환경`
-  ``` Java 17 ```
- ``` JDK-17.0.10+7 ```
- **IDE** : IntelliJ IDEA Ultimate 2023.3.6
- **SQL Mapper** : MyBatis
  
### 📂 `폴더구조`
``` 
\---wms-albumshop
    |   README.md
    |   
    +---.github
    |   \---ISSUE_TEMPLATE
    |           ?-feature.md
    |           ?-error.md
    |           
    \---albumshop
        |   .gitignore
        |   build.gradle
        |   gradlew
        |   gradlew.bat
        |   settings.gradle
        |   
        +---.gradle
        |   |   file-system.probe
        |   |   
        |   +---8.4
        |   |   |   gc.properties
        |   |   |   
        |   |   +---checksums
        |   |   |       checksums.lock
        |   |   |       md5-checksums.bin
        |   |   |       sha1-checksums.bin
        |   |   |       
        |   |   +---dependencies-accessors
        |   |   |       dependencies-accessors.lock
        |   |   |       gc.properties
        |   |   |       
        |   |   +---executionHistory
        |   |   |       executionHistory.bin
        |   |   |       executionHistory.lock
        |   |   |       
        |   |   +---fileChanges
        |   |   |       last-build.bin
        |   |   |       
        |   |   +---fileHashes
        |   |   |       fileHashes.bin
        |   |   |       fileHashes.lock
        |   |   |       resourceHashesCache.bin
        |   |   |       
        |   |   \---vcsMetadata
        |   +---buildOutputCleanup
        |   |       buildOutputCleanup.lock
        |   |       cache.properties
        |   |       outputFiles.bin
        |   |       
        |   \---vcs-1
        |           gc.properties
        |           
        +---.idea
        |       .gitignore
        |       compiler.xml
        |       gradle.xml
        |       jarRepositories.xml
        |       misc.xml
        |       vcs.xml
        |       workspace.xml
        |       
        +---build
        |   +---classes
        |   |   \---java
        |   |       +---main
        |   |       |   \---bangshop
        |   |       |       \---music
        |   |       |           |   Application.class
        |   |       |           |   
        |   |       |           +---common
        |   |       |           |   |   MyBatisTemplate.class
        |   |       |           |   |   
        |   |       |           |   +---error
        |   |       |           |   |       ErrorCode.class
        |   |       |           |   |       ErrorView.class
        |   |       |           |   |       
        |   |       |           |   \---utils
        |   |       |           |           IOUtils.class
        |   |       |           |           
        |   |       |           +---controller
        |   |       |           |       DispatchController.class
        |   |       |           |       EmployeeController.class
        |   |       |           |       OrderController.class
        |   |       |           |       OrderStorageController.class
        |   |       |           |       SearchController.class
        |   |       |           |       StorageController.class
        |   |       |           |       
        |   |       |           +---model
        |   |       |           |   +---dao
        |   |       |           |   |       AlbumStorageMapper.class
        |   |       |           |   |       EmployeeMapper.class
        |   |       |           |   |       OrderMapper.class
        |   |       |           |   |       OrderStorageMapper.class
        |   |       |           |   |       SearchMapper.class
        |   |       |           |   |       StockInMapper.class
        |   |       |           |   |       StockOutMapper.class
        |   |       |           |   |       StorageMapper.class
        |   |       |           |   |       
        |   |       |           |   +---domain
        |   |       |           |   |       StockOut.class
        |   |       |           |   |       StockOutStatus.class
        |   |       |           |   |       
        |   |       |           |   +---dto
        |   |       |           |   |   |   AlbumDTO.class
        |   |       |           |   |   |   AlbumStorageDTO.class
        |   |       |           |   |   |   EmployeeDTO.class
        |   |       |           |   |   |   OrderDTO.class
        |   |       |           |   |   |   Role.class
        |   |       |           |   |   |   StockInDTO.class
        |   |       |           |   |   |   StockOutAndStorageDTO.class
        |   |       |           |   |   |   StorageDTO.class
        |   |       |           |   |   |   StoreDTO.class
        |   |       |           |   |   |   TrackDTO.class
        |   |       |           |   |   |   
        |   |       |           |   |   \---stock
        |   |       |           |   |           GetStockRequest.class
        |   |       |           |   |           InsertStockRequest.class
        |   |       |           |   |           
        |   |       |           |   \---service
        |   |       |           |           DispatchService.class
        |   |       |           |           EmployeeService.class
        |   |       |           |           OrderService.class
        |   |       |           |           OrderStorageService.class
        |   |       |           |           SearchService.class
        |   |       |           |           StorageService.class
        |   |       |           |           
        |   |       |           \---view
        |   |       |               |   PrintsResult.class
        |   |       |               |   
        |   |       |               +---menu
        |   |       |               |       MainMenu$1.class
        |   |       |               |       MainMenu.class
        |   |       |               |       MainViewMenu.class
        |   |       |               |       StorageAdminMenu.class
        |   |       |               |       StorageAdminView$1.class
        |   |       |               |       StorageAdminView.class
        |   |       |               |       StoreManagerMenu.class
        |   |       |               |       StoreManagerView$1.class
        |   |       |               |       StoreManagerView.class
        |   |       |               |       
        |   |       |               \---result
        |   |       |                       SearchResultView.class
        |   |       |                       
        |   |       \---test
        |   |           \---bangshop
        |   |               \---music
        |   |                   |   MabatisTemplateTest.class
        |   |                   |   
        |   |                   \---controller
        |   |                           cyTest.class
        |   |                           dbTest.class
        |   |                           jhTest.class
        |   |                           scTest.class
        |   |                           yrTest.class
        |   |                           
        |   +---generated
        |   |   \---sources
        |   |       +---annotationProcessor
        |   |       |   \---java
        |   |       |       +---main
        |   |       |       \---test
        |   |       \---headers
        |   |           \---java
        |   |               +---main
        |   |               \---test
        |   +---reports
        |   |   \---tests
        |   |       \---test
        |   |           |   index.html
        |   |           |   
        |   |           +---classes
        |   |           |       bangshop.music.controller.dbTest.html
        |   |           |       
        |   |           +---css
        |   |           |       base-style.css
        |   |           |       style.css
        |   |           |       
        |   |           +---js
        |   |           |       report.js
        |   |           |       
        |   |           \---packages
        |   |                   bangshop.music.controller.html
        |   |                   
        |   +---resources
        |   |   \---main
        |   |       |   mybatis-config.xml
        |   |       |   
        |   |       +---config
        |   |       |       connection-info.properties
        |   |       |       
        |   |       \---sql
        |   |           \---mapper
        |   |                   album-storage-mapper.xml
        |   |                   cy-query.xml
        |   |                   db-query.xml
        |   |                   jh-query.xml
        |   |                   order-mapper.xml
        |   |                   sc-query.xml
        |   |                   storage-mapper.xml
        |   |                   yr-query.xml
        |   |                   
        |   +---test-results
        |   |   \---test
        |   |       |   TEST-bangshop.music.controller.dbTest.xml
        |   |       |   
        |   |       \---binary
        |   |               output.bin
        |   |               output.bin.idx
        |   |               results.bin
        |   |               
        |   \---tmp
        |       +---compileJava
        |       |       previous-compilation-data.bin
        |       |       
        |       +---compileTestJava
        |       |   |   previous-compilation-data.bin
        |       |   |   
        |       |   \---compileTransaction
        |       |       +---backup-dir
        |       |       \---stash-dir
        |       |               dbTest.class.uniqueId0
        |       |               
        |       \---test
        +---gradle
        |   \---wrapper
        |           gradle-wrapper.jar
        |           gradle-wrapper.properties
        |           
        \---src
            +---main
            |   +---java
            |   |   \---bangshop
            |   |       \---music
            |   |           |   Application.java
            |   |           |   
            |   |           +---common
            |   |           |   |   MyBatisTemplate.java
            |   |           |   |   
            |   |           |   +---error
            |   |           |   |       ErrorCode.java
            |   |           |   |       ErrorView.java
            |   |           |   |       
            |   |           |   \---utils
            |   |           |           IOUtils.java
            |   |           |           
            |   |           +---controller
            |   |           |       DispatchController.java
            |   |           |       EmployeeController.java
            |   |           |       OrderController.java
            |   |           |       OrderStorageController.java
            |   |           |       SearchController.java
            |   |           |       StorageController.java
            |   |           |       
            |   |           +---model
            |   |           |   +---dao
            |   |           |   |       AlbumStorageMapper.java
            |   |           |   |       EmployeeMapper.java
            |   |           |   |       OrderMapper.java
            |   |           |   |       OrderStorageMapper.java
            |   |           |   |       SearchMapper.java
            |   |           |   |       StockInMapper.java
            |   |           |   |       StockOutMapper.java
            |   |           |   |       StorageMapper.java
            |   |           |   |       
            |   |           |   +---domain
            |   |           |   |       StockOut.java
            |   |           |   |       StockOutStatus.java
            |   |           |   |       
            |   |           |   +---dto
            |   |           |   |   |   AlbumDTO.java
            |   |           |   |   |   AlbumStorageDTO.java
            |   |           |   |   |   EmployeeDTO.java
            |   |           |   |   |   OrderDTO.java
            |   |           |   |   |   Role.java
            |   |           |   |   |   StockInDTO.java
            |   |           |   |   |   StockOutAndStorageDTO.java
            |   |           |   |   |   StorageDTO.java
            |   |           |   |   |   StoreDTO.java
            |   |           |   |   |   TrackDTO.java
            |   |           |   |   |   
            |   |           |   |   \---stock
            |   |           |   |           GetStockRequest.java
            |   |           |   |           InsertStockRequest.java
            |   |           |   |           
            |   |           |   \---service
            |   |           |           DispatchService.java
            |   |           |           EmployeeService.java
            |   |           |           OrderService.java
            |   |           |           OrderStorageService.java
            |   |           |           SearchService.java
            |   |           |           StorageService.java
            |   |           |           
            |   |           \---view
            |   |               |   PrintsResult.java
            |   |               |   
            |   |               +---menu
            |   |               |       MainMenu.java
            |   |               |       MainViewMenu.java
            |   |               |       StorageAdminMenu.java
            |   |               |       StorageAdminView.java
            |   |               |       StoreManagerMenu.java
            |   |               |       StoreManagerView.java
            |   |               |       
            |   |               \---result
            |   |                       SearchResultView.java
            |   |                       
            |   \---resources
            |       |   mybatis-config.xml
            |       |   
            |       +---config
            |       |       connection-info.properties
            |       |       
            |       \---sql
            |           \---mapper
            |                   album-storage-mapper.xml
            |                   cy-query.xml
            |                   db-query.xml
            |                   jh-query.xml
            |                   order-mapper.xml
            |                   sc-query.xml
            |                   storage-mapper.xml
            |                   yr-query.xml
            |                   
            \---test
                \---java
                    \---bangshop
                        \---music
                            |   MabatisTemplateTest.java
                            |   
                            \---controller
                                    cyTest.java
                                    dbTest.java
                                    jhTest.java
                                    scTest.java
                                    yrTest.java
```    


## 📌 주요 기능
### `입고`
- 창고관리자는 본사창고에 새로운 앨범을 추가하거나 보유중인 앨범의 수량을 증가시킨다. 

### `출고` 
- 창고관리자는 가맹점의 주문을 받아 재고 확인 후 본사창고에서 앨범을 출고한다.

### `앨범 주문`
- 가맹점주는 가맹점의 재고를 검색을 통해 앨범당 재고를 확인한다
- 본사로 앨범주문을 통해 가맹점의 재고를 관리한다

### `앨범 재고 관리` 
- 가맹점주는 가맹점의 창고를 창고관리자는 본사창고 재고를 확인하여 재고를 관리한다.
- 가맹점은 필요한 앨범을 주문하여 본사창고로부터 입고 받아 재고를 관리한다.
- 본사창고는 앨범을 새로 등록하거나 기존 앨범의 수량을 추가하여 재고를 관리한다.

###  `계정 관리`
- 관리자는 가맹점주의 계정 정보를 조회한다.
- 관리자는 새로운 가맹점주의 계정을 생성한다.

## 🗣️ `후기`
- 팀원1 : 김다빈

데이터베이스를 구축하고 설계하는 작업에 생각보다 시간을 많이 썼었던 것 같습니다. 그만큼 중요한 작업이라는 것을 깨달았습니다. 추후 신규 프로젝트 개발을 시작할 때, 프로세스에 필요한 흐름을 구체적으로 작성하는 것에 중점을 두고 구현할 필요성을 느꼈습니다. 또한 팀원들께 많이 배웠고 지식을 공유한 시간이었습니다. 다들 수고하셨습니다!     

- 팀원2 : 노영록
- 초기 데이터베이스 설계의 중요성
     - DB 모델링의 이해도가 부족하여 여러 번 수정을 하게 됐다.
     - 처음 의도했던 바와 다르게 데이터에 문제가 발생해 문제 해결하는데 시간을 많이 사용하다 보니 초기 설계가 개발 시간을 단축할 수 있는 중요한 부분이라고 느꼈다.
- 의사소통의 부재
     - 동일한 단어를 얘기해도 각자 다른 방향을 바라보고 다른 생각을 하는 상황이 있다보니 예상과는 다른 결과가 나왔다. 정확하고 구체적으로 이야기해야 문제없이 진행이 될 것 같다.
- 처음으로 데이터베이스를 연결하다 보니 새로운 오류를 보고 해결하는 데 시간을 많이 사용했다.
- 여러가지 문제들이 발생했지만 이를 통해 조금 더 성장할 수 있었다고 느꼈다.
- 내가 맡은 기능을 구현하는데 급급해서 전체적인 프로젝트에 대한 이해도가 미흡했다.
- 머리 속에 정리가 부족했던 내용들이 팀원들과의 소통을 통해 정리가 되면서 조금 더 개발에 필요한 역량을 채워나가게 됐고 부족한 점을 많이 느껴 큰 동기부여가 됐다.

- 팀원3 : 송재혁
     - 이전 프로젝트하고 이어졌던 부분이였지만 초반에 각자 이해하는 바가 다르고 기능을 정하는 방향에서 다르게 생각하게 되는 부분이 많았습니다.
     - 자꾸 습관처럼 다른 사람의 말을 끝까지 듣는 경청하는 습관이 부족했습니다
     - 몇번 아직 완전히 이해가 안되는 상태에서 하다보니 버그에 많이 만났고 좌절도 많이 했던 거 같습니다. 맡은 기능에서 select문밖에 없었지만 다른 부분도 배우고 해보고싶은 마음이 컷던 거도 사실이였습니다.
     - 항상 프로젝트 하면서 느끼는거지만 프로젝트 하면서 못할거 같던 문제들이 풀리는거를 보면서 서로 협력하고 해결하는 모습으로 많이 보람을 느꼈었고 재미도 있었으며 좌절도 많이 했던거 같습니다.

- 팀원4 : 육슬찬

여기다 쓰시면 돼요

- 팀원5 : 이창연   
  
데이터베이스에 대한 지식이 부족해서 DB 모델링을 하는데 너무 많은 시간을 사용했습니다. 계속해서 모델이 바뀌면서 ERD도 여러 번 다시 그려야 했습니다.
하지만 그 덕분에  DA#을 이전보다 능숙하게 사용할 수 있게 되었고 다음에 다시 DB 모델링을 한다면 좀 더 수월하게 할 수 있을 것 같습니다.

또한 MyBatis를 처음 써봐서 두려움이 컸습니다. 예를 들어 테이블의 레코드를 삭제하는 과정에서 외래키 참조 관계에 의해 삭제되지 않는 문제와 같이
몇 번의 문제가 있었는데 팀원들과 함께 해결해나가면서 많은 것을 배울 수 있었습니다.

그리고 깃허브에서 마일스톤과 이슈를 등록하거나 코드 병합 과정에서 빈번한 충돌을 해결하면서 깃도 능숙하게 다룰 수 있게 되었습니다.

이번 팀 프로젝트를 통해 제가 부족한 점이 무엇인지 어느정도 느낄 수 있었습니다.
