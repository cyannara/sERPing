package com.beauty1nside.hr.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenBankingTokenRequestDTO {
    private String client_id;
    private String client_secret;
    private String scope;
    private String grant_type;
}
