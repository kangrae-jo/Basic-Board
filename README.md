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

