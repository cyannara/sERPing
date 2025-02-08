package com.beauty1nside.erp.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.beauty1nside.erp.service.MovieDTO;
import com.beauty1nside.erp.service.MovieListDTO;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	//★★★
@AllArgsConstructor
@RequestMapping("/erp/rest/*")
public class MovieController {
	
	//http://localhost:81/erp/rest/20250115
		//영화정보
		@GetMapping("/{thisdate}")
		public MovieListDTO movie(@PathVariable(name="thisdate") String thisdate) {
			//스트링에서 제공하는 다른서버 api 요청
			RestTemplate restTemplate = new RestTemplate();	//다른서버 요청 객체 만듬
			String uri = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt="+thisdate;
			//받아온정보를 JSON으로 변환 
			JsonNode node = restTemplate.getForObject(uri, JsonNode.class);
			
			
			
			MovieListDTO list = new MovieListDTO();
			list.setList(new ArrayList<>());
			
			for(int i=0; i<node.get("boxOfficeResult").get("dailyBoxOfficeList").size(); i++) {
				list.getList().add(MovieDTO.builder()
								.rnum(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("rnum").asLong())
								.rank(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("rank").asLong())
								.rankinten(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("rankInten").asLong())
								.rankoldandnew(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("rankOldAndNew").asText())
								.moviecd(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("movieCd").asLong())
								.movienm(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("movieNm").asText())
								.opendt(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("openDt").asText())
								.salesamt(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("salesAmt").asLong())
								.salesshare(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("salesShare").asDouble())
								.salesinten(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("salesInten").asLong())
								.saleschange(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("salesChange").asDouble())
								.salesacc(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("salesAcc").asLong())
								.audicnt(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("audiCnt").asLong())
								.audiinten(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("audiInten").asLong())
								.audichange(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("audiChange").asDouble())
								.audiacc(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("audiAcc").asLong())
								.scrncnt(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("scrnCnt").asLong())
								.showcnt(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("showCnt").asLong())
								.thisdate(thisdate)
								.build()
						);
				//log.info(node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("rnum").asLong());
			}
			log.info("★★★가공 없이 쓰거나"+node.toString());	// 대신 리턴타입을 리스트 보 해야함
			log.info("★★★가공 해서 쓰거나"+list.toString());
			
			//첫번째영화 이름 가져오기
			//String moviename = node.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText();
			//log.info("movie : " + moviename );
			return list;
		}

}
