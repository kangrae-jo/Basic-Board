package core.basicboard.dao;

import core.basicboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO extends JpaRepository<Board, Long> {
    // 기본 CRUD 메서드를 JpaRepository가 제공함
}
