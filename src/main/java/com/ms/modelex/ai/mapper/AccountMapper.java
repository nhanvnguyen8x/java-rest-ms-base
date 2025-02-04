package com.ms.modelex.ai.mapper;

import com.ms.modelex.ai.api.dto.account.AccountDto;
import com.ms.modelex.ai.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDto toDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .username(account.getUsername())
                .email(account.getEmail())
                .fullName(account.getFullName())
                .build();
    }
}
