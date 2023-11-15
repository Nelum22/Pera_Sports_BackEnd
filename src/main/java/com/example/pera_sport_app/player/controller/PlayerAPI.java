package com.example.pera_sport_app.player.controller;

import com.example.pera_sport_app.player.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/player")
public class PlayerAPI {
//    @PostMapping(value = "/add")
//    public ResponseDto addTransaction(@RequestBody TransactionAddDto transactionAddDto) {
//        log.info("Request to save transaction details {}", transactionAddDto);
//        return transactionService.addTransaction(transactionAddDto);
//    }
}
