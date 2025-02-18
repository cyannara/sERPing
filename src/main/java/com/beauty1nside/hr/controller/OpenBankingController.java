package com.beauty1nside.hr.controller;

import com.beauty1nside.hr.dto.OpenBankingTokenResponseDTO;
import com.beauty1nside.hr.service.OpenBankingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openbanking")
public class OpenBankingController {
    
    private final OpenBankingService openBankingService;

    public OpenBankingController(OpenBankingService openBankingService) {
        this.openBankingService = openBankingService;
    }

    @GetMapping("/token")
    public OpenBankingTokenResponseDTO getToken() {
        return openBankingService.getAccessToken();
    }
}
