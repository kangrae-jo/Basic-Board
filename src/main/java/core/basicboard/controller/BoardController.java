package core.basicboard.controller;

import core.basicboard.dto.BoardDTO;
import core.basicboard.service.BoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 목록 조회
    @GetMapping
    public List<BoardDTO> getBoards() {
        return boardService.getBoardList();
    }

    // 게시글 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable("id") Long id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    // 게시글 작성
    @PostMapping
    public ResponseEntity<String> createBoard(@RequestBody BoardDTO boardDTO) {
        boardService.saveBoard(boardDTO);
        return ResponseEntity.ok("Board created successfully");
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable("id") Long id, @RequestBody BoardDTO boardDTO) {
        boardService.updateBoard(id, boardDTO);
        return ResponseEntity.ok("Board updated successfully");
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("Board deleted successfully");
    }

}
