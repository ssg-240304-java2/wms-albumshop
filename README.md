# HeadBang- AlbumShop

## 🎼 프로젝트 소개
**앨범 재고 관리 프로그램으로, 창고 관리자는 앨범 입고/출고를 통해 본사창고를 관리하고 
가맹점주는 본사로 앨범을 주문해 매장의 재고를 관리합니다.** 
<br>

## 🕰️ 개발 기간
* 24.05.16일 - 24.05.21일

### 🧑‍🤝‍🧑 멤버구성
 - 팀원1 : 김다빈 - 입고 관리  
 - 팀원2 : 노영록 - 출고 관리 
 - 팀원3 : 송재혁 - 창고 및 가맹점 재고 조회, 주문 내역 조회  
 - 팀원4 : 육슬찬 - 앨범 검색, 앨범 조회, 앨범 주문  
 - 팀원5 : 이창연 - 로그인, 계정 관리, 직원 조회, 지점 조회

### ⚙️ 개발 환경
-  ``` Java 17 ```
- ``` JDK-17.0.10+7 ```
- **IDE** : IntelliJ IDEA Ultimate 2023.3.6
- **SQL Mapper** : MyBatis
  
### 📂폴더구조
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
        |   |       \---main
        |   |           \---bangshop
        |   |               \---music
        |   |                   |   Application.class
        |   |                   |   
        |   |                   +---common
        |   |                   |   |   MyBatisTemplate.class
        |   |                   |   |   
        |   |                   |   +---error
        |   |                   |   |       ErrorCode.class
        |   |                   |   |       ErrorView.class
        |   |                   |   |       
        |   |                   |   \---utils
        |   |                   |           IOUtils.class
        |   |                   |           
        |   |                   +---controller
        |   |                   |       DispatchController.class
        |   |                   |       EmployeeController.class
        |   |                   |       OrderController.class
        |   |                   |       OrderStorageController.class
        |   |                   |       SearchController.class
        |   |                   |       StorageController.class
        |   |                   |       
        |   |                   +---model
        |   |                   |   +---dao
        |   |                   |   |       AlbumStorageMapper.class
        |   |                   |   |       EmployeeMapper.class
        |   |                   |   |       OrderMapper.class
        |   |                   |   |       OrderStorageMapper.class
        |   |                   |   |       SearchMapper.class
        |   |                   |   |       StockInMapper.class
        |   |                   |   |       StockOutMapper.class
        |   |                   |   |       StorageMapper.class
        |   |                   |   |       
        |   |                   |   +---domain
        |   |                   |   |       StockOut.class
        |   |                   |   |       StockOutStatus.class
        |   |                   |   |       
        |   |                   |   +---dto
        |   |                   |   |   |   AlbumDTO.class
        |   |                   |   |   |   AlbumStorageDTO.class
        |   |                   |   |   |   EmployeeDTO.class
        |   |                   |   |   |   OrderDTO.class
        |   |                   |   |   |   Role.class
        |   |                   |   |   |   StockInDTO.class
        |   |                   |   |   |   StockOutAndStorageDTO.class
        |   |                   |   |   |   StorageDTO.class
        |   |                   |   |   |   StoreDTO.class
        |   |                   |   |   |   TrackDTO.class
        |   |                   |   |   |   
        |   |                   |   |   \---stock
        |   |                   |   |           GetStockRequest.class
        |   |                   |   |           InsertStockRequest.class
        |   |                   |   |           
        |   |                   |   \---service
        |   |                   |           DispatchService.class
        |   |                   |           EmployeeService.class
        |   |                   |           OrderService.class
        |   |                   |           OrderStorageService.class
        |   |                   |           SearchService.class
        |   |                   |           StorageService.class
        |   |                   |           
        |   |                   \---view
        |   |                       |   PrintsResult.class
        |   |                       |   
        |   |                       +---menu
        |   |                       |       MainMenu$1.class
        |   |                       |       MainMenu.class
        |   |                       |       MainViewMenu.class
        |   |                       |       StorageAdminMenu.class
        |   |                       |       StorageAdminView$1.class
        |   |                       |       StorageAdminView.class
        |   |                       |       StoreManagerMenu.class
        |   |                       |       StoreManagerView$1.class
        |   |                       |       StoreManagerView.class
        |   |                       |       
        |   |                       \---result
        |   |                               SearchResultView.class
        |   |                               
        |   +---generated
        |   |   \---sources
        |   |       +---annotationProcessor
        |   |       |   \---java
        |   |       |       \---main
        |   |       \---headers
        |   |           \---java
        |   |               \---main
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
        |   |                   sc2-query.xml
        |   |                   storage-mapper.xml
        |   |                   yr-query.xml
        |   |                   
        |   \---tmp
        |       \---compileJava
        |               previous-compilation-data.bin
        |               
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
            |                   sc2-query.xml
            |                   storage-mapper.xml
            |                   yr-query.xml
            |                   
            \---test
                \---java
                    \---bangshop
                        \---music
                            \---controller
                                    cyTest.java
                                    dbTest.java
                                    jhTest.java
                                    scTest.java
                                    yrTest.java
```    


## 📌 주요 기능
### 입고
- 창고관리자는 본사창고에 새로운 앨범을 추가하거나 보유중인 앨범의 수량을 증가시킨다. 

### 출고 
- 창고관리자는 가맹점의 주문을 받아 재고 확인 후 본사창고에서 앨범을 출고한다.

### 앨범 주문
- 가맹점주는 가맹점의 재고를 검색을 통해 앨범당 재고를 확인한다
- 본사로 앨범주문을 통해 가맹점의 재고를 관리한다

### 앨범 재고 관리 
- 가맹점주는 가맹점의 창고를 창고관리자는 본사창고 재고를 확인하여 재고를 관리한다.
- 가맹점은 필요한 앨범을 주문하여 본사창고로부터 입고 받아 재고를 관리한다.
- 본사창고는 앨범을 새로 등록하거나 기존 앨범의 수량을 추가하여 재고를 관리한다.

###  계정 관리
- 관리자는 가맹점주의 계정 정보를 조회한다.
- 관리자는 새로운 가맹점주의 계정을 생성한다.

## 🗣️ 후기 
 - 팀원1 : 김다빈 
 - 팀원2 : 노영록 
 - 팀원3 : 송재혁 
 - 팀원4 : 육슬찬 
 - 팀원5 : 이창연 
