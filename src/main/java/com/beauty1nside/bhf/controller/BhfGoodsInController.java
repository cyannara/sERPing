package com.beauty1nside.bhf.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;
import com.beauty1nside.bhf.service.BhfGoodsInService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@RestController
@AllArgsConstructor
@RequestMapping("/bhf/rest/*")
public class BhfGoodsInController {
	
	BhfGoodsInService service;
	
	@PostMapping("/goods/in")
    public ResponseEntity<String> goodsIn(@RequestBody List<BhfGoodsInVO> goodsList) {
        int result = service.goodsIn(goodsList);
        return ResponseEntity.ok(result + " rows inserted/updated.");
    }

}
