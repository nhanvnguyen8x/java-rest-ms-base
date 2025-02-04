package com.ms.modelex.ai.controller;

import com.ms.modelex.ai.api.dto.account.AccountDto;
import com.ms.modelex.ai.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/current")
    public ResponseEntity<AccountDto> getCurrentUserLogin(@RequestHeader HttpHeaders headers) {
        AccountDto accountDto = accountService.getCurrentLoggedAccount(headers);
        return ResponseEntity.ok(accountDto);
    }
}
