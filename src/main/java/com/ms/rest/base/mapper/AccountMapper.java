package com.ms.rest.base.mapper;

import com.ms.rest.base.api.dto.account.AccountDto;
import com.ms.rest.base.domain.Account;
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
