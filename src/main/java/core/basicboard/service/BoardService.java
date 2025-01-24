package core.basicboard.service;

import core.basicboard.dao.BoardDAO;
import core.basicboard.dto.BoardDTO;
import core.basicboard.entity.Board;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    // 게시글 목록 조회
    public List<BoardDTO> getBoardList() {
        List<Board> boards = boardDAO.findAll();
        return boards.stream()
                .map(board -> new BoardDTO(board.getId(), board.getTitle(), board.getContent(), board.getAuthor()))
                .collect(Collectors.toList());
    }

    // 게시글 상세 조회
    public BoardDTO getBoardById(Long id) {
        Board board = findBoardById(id);
        return new BoardDTO(board.getId(), board.getTitle(), board.getContent(), board.getAuthor());
    }

    // 게시글 작성
    @Transactional
    public void saveBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setId(boardDTO.getId());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setAuthor(boardDTO.getAuthor());
        board.setCreatedDate(LocalDateTime.now());

        boardDAO.save(board);
    }

    // 게시글 수정
    @Transactional
    public void updateBoard(Long id, BoardDTO boardDTO) {
        Board board = findBoardById(id);
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setUpdateDate(LocalDateTime.now());

        boardDAO.save(board);
    }

    // 게시글 삭제
    @Transactional
    public void deleteBoard(Long id) {
        boardDAO.deleteById(id);
    }

    private Board findBoardById(Long id) {
        return boardDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("[ERROR]: Invalid board ID"));
    }

}
