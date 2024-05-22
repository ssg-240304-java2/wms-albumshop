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
wms-albumshop
    ├─.github
    │  └─ISSUE_TEMPLATE
    └─albumshop
        ├─.gradle
        │  ├─8.4
        │  │  ├─checksums
        │  │  ├─dependencies-accessors
        │  │  ├─executionHistory
        │  │  ├─fileChanges
        │  │  ├─fileHashes
        │  │  └─vcsMetadata
        │  ├─buildOutputCleanup
        │  └─vcs-1
        ├─.idea
        ├─build
        │  ├─classes
        │  │  └─java
        │  │      ├─main
        │  │      │  └─bangshop
        │  │      │      └─music
        │  │      │          ├─common
        │  │      │          │  ├─error
        │  │      │          │  └─utils
        │  │      │          ├─controller
        │  │      │          ├─model
        │  │      │          │  ├─dao
        │  │      │          │  ├─domain
        │  │      │          │  ├─dto
        │  │      │          │  │  └─stock
        │  │      │          │  └─service
        │  │      │          └─view
        │  │      │              ├─menu
        │  │      │              └─result
        │  │      └─test
        │  │          └─bangshop
        │  │              └─music
        │  │                  └─controller
        │  ├─generated
        │  │  └─sources
        │  │      ├─annotationProcessor
        │  │      │  └─java
        │  │      │      ├─main
        │  │      │      └─test
        │  │      └─headers
        │  │          └─java
        │  │              ├─main
        │  │              └─test
        │  ├─reports
        │  │  └─tests
        │  │      └─test
        │  │          ├─classes
        │  │          ├─css
        │  │          ├─js
        │  │          └─packages
        │  ├─resources
        │  │  └─main
        │  │      ├─config
        │  │      └─sql
        │  │          └─mapper
        │  ├─test-results
        │  │  └─test
        │  │      └─binary
        │  └─tmp
        │      ├─compileJava
        │      ├─compileTestJava
        │      │  └─compileTransaction
        │      │      ├─backup-dir
        │      │      └─stash-dir
        │      └─test
        ├─gradle
        │  └─wrapper
        └─src
            ├─main
            │  ├─java
            │  │  └─bangshop
            │  │      └─music
            │  │          ├─common
            │  │          │  ├─error
            │  │          │  └─utils
            │  │          ├─controller
            │  │          ├─model
            │  │          │  ├─dao
            │  │          │  ├─domain
            │  │          │  ├─dto
            │  │          │  │  └─stock
            │  │          │  └─service
            │  │          └─view
            │  │              ├─menu
            │  │              └─result
            │  └─resources
            │      ├─config
            │      └─sql
            │          └─mapper
            └─test
                └─java
                    └─bangshop
                        └─music
                            └─controller
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

여기다 쓰시면 돼요

- 팀원2 : 노영록

여기다 쓰시면 돼요

- 팀원3 : 송재혁

여기다 쓰시면 돼요

- 팀원4 : 육슬찬

여기다 쓰시면 돼요

- 팀원5 : 이창연   
  
데이터베이스에 대한 지식이 부족해서 DB 모델링을 하는데 너무 많은 시간을 사용했습니다. 계속해서 모델이 바뀌면서 ERD도 여러 번 다시 그려야 했습니다.
하지만 그 덕분에  DA#을 이전보다 능숙하게 사용할 수 있게 되었고 다음에 다시 DB 모델링을 한다면 좀 더 수월하게 할 수 있을 것 같습니다.

또한 MyBatis를 처음 써봐서 두려움이 컸습니다. 예를 들어 테이블의 레코드를 삭제하는 과정에서 외래키 참조 관계에 의해 삭제되지 않는 문제와 같이
몇 번의 문제가 있었는데 팀원들과 함께 해결해나가면서 많은 것을 배울 수 있었습니다.

그리고 깃허브에서 마일스톤과 이슈를 등록하거나 코드 병합 과정에서 빈번한 충돌을 해결하면서 깃도 능숙하게 다룰 수 있게 되었습니다.

이번 팀 프로젝트를 통해 제가 부족한 점이 무엇인지 어느정도 느낄 수 있었습니다.
