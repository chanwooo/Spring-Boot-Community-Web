package com.web.controller;

import com.web.service.BoardService;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.web.domain.Board;

import java.time.LocalDateTime;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Controller
@RequestMapping("/board")
public class BoardController {
    //@See https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-spring-beans-and-dependency-injection.html
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping({"", "/"})
    public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "/board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "/board/list";
    }


}
