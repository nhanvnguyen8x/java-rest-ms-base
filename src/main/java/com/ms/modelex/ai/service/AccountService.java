package com.ms.modelex.ai.service;

import com.ms.modelex.ai.api.dto.account.AccountDto;
import com.ms.modelex.ai.exception.BadRequestException;
import com.ms.modelex.ai.domain.Account;
import com.ms.modelex.ai.mapper.AccountMapper;
import com.ms.modelex.ai.repository.AccountRepository;
import com.ms.modelex.ai.service.auth.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final TokenService tokenService;
    private final AccountMapper accountMapper;

    public AccountDto getCurrentLoggedAccount(HttpHeaders httpHeaders) {
        String authorization = httpHeaders.getFirst(HttpHeaders.AUTHORIZATION);

        Long accountId = tokenService.extractAccountId(authorization);
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new BadRequestException("Account not found"));

        return accountMapper.toDto(account);
    }


}
