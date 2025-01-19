# 🖥️ Basic Board Project

간단한 게시판을 만들며 배우는 개발

## 👤 Entity

- Datebase와의 매핑, 영속성 관리 역할
- Persistence Layer에 위치
- 매핑된 모든 field를 포함
- ORM 프레임워크에 종속적
- DB 변경 시 영향 받음

## 📖 DTO (Data Transfer Object)

- 계층 간 데이터 전달
- 서비스 / 컨트롤러 계층
- 필요한 데이터만 (민감한 정보 제외)
- 프레임워크와 독립적
- 외부로 노출되는 구조를 독립적으로 유지 가능

## DAO (Data Access Object)

- DB와 App간의 상호작용을 추상화하는 디자인 패턴
- CRUD 작업 관리
- 영속성 계층에 접근하는 기능을 모듈화
- 비지니스 로직과 DB로직 분리
- Spring에서는 JpaRepository로 구현가능
- `extends JpaRepository<Board, Long>`는 Board 엔티티의 ID(primary key)가 Long 타입임을 나타냄

## ☕️ Service

- 실제 비지니스 로직 처리
- Controller와 Repository 사이의 중재자 역할
- 트랜잭션 관리 (@Transactional을 통해 관리 가능)
- DTO와 Entity 변환 (외부와 교환하기 위해 Entity를 DTO로 또는 그 반대로)


