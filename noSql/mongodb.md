## mongodb local setting

1. mongodb 설치
```
1. 설치 가능한 mongodb검색
➜  ~ brew search mongodb

2. Tap, Brew tap명령은 설치 가능한 software를 확장시켜 준다.
➜  ~ brew tap mongodb/brew

3. Brew tap 후 재 검색하면, 더 많은 설치 가능 항목이 보인다.
➜  ~ brew search mongodb

4. 최신 mongodb4.4 버전 설치
➜  ~ brew install mongodb-community@4.4
```
  - Error: Xcode alone is not sufficient on Big Sur.
  ㄴ Xcode 버전 업데이트
  ➜  ~ xcode-select --install


2. 서버 실행 및 종료
➜  ~ brew services start mongodb-community@4.4
➜  ~ brew services stop mongodb-community@4.4


3. gui를 위한 robo-3t 설치
➜  ~ brew install --cask robo-3t
create connection => localhost

## mongodb 기본개념
- MongoDB는 가장 기본적인 데이터를 Document(문서)라고 부른다
  (MySQL과 같은 RDBMS에서는 row에 해당)
- 이 Document(문서)의 집합을 Collection이라 한다
  (MySQL과 같은 RDBMS에서는 Table(테이블)에 해당)
- 이 Collection의 집합을 DB라고 한다

- Document는 JSON형태의 Key-Value 쌍으로 이루어 진다
- Document에는 _id'가 있는데 RDBMS의 Primary Key와 같은 개념이다
- 기본 포맷
```
{
  id: 'bella.yk'  // field:value
  name: 'bella'   // field:value
  dept: 'cr_dev'  // field:value
}
```


### 특징
- 차이점
  | RDBMS | MongoDB |
  | :---- | :------ |
  |Database|Database|
  |Table(테이블)|Collection|
  |Row(행)|Document|
  |Column(열)|Field|
  |PK|_id|
  |Index|Index|

- 관계가 없는 데이터베이스이기 때문에 빅데이터나 실시간 웹 애플리케이션에 널리 사용된다.

- 스키마가 없다
  - 스키마 :
  db를 구성하는 개체(Entity), 속성(Attribute), 관계(relation) 및 제약조건등을 정의하는 것
  - 스키마가 존재한다 = 구조가 미리 정의 되어 있다.
  - mongodb는 스키마가 사전에 정의되지 않아도 된다. 즉 다양한 필드를 가질 수 있다.
- 다양한 인덱싱을 제공
  - single field indexes : 기본적인 인덱스 타입
  - compound indexes : 복합인덱스
  - multikey indexes : 값이 하나라도 있으면 인덱스에 추가하는 멀티키 인덱스
  - geospatial indexes and queries : 위치기반 인덱스와 쿼리
  - text index : BTree 인덱스가 아닌 해시타입의 인덱스도 가능
- Auto Sharing 가능, 즉 PK 기반으로 여러 서버에 데이터를 나누는 scale-out 가능

### 장/단점
- 장점
  - RDBMS속도보다 100배 이상 빠르다
  - 스키마 관리가 필요없다.
  - json 형태로 저장하기 때문에 직관적이다.
  - 데이터를 읽고 쓰기 빠르다
  - scale-out 구조여서 쉽게 운영 가능하다.
- 단점
  - 복잡한 쿼리를 사용할 수 없다(join이 없다)
  - 메모리 사용량이 크다
  - 정합성이 떨어진다
  - sql을 완전히 이전할 수 없다.
