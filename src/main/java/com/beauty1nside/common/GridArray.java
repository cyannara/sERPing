package com.beauty1nside.common;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GridArray {
	
	public Object getArray(int page, int count, Object datas) throws JsonMappingException, JsonProcessingException {
		String str = """
				{
				  "result": true,
				  "data": {
				    "contents": [],
				    "pagination": {
				      "page": 1,
				      "totalCount": 100
				    }
				  }
				}
								""";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(str, Map.class);
		Map<String, Object> data = (Map) map.get("data");
		Map<String, Object> pagination = (Map) data.get("pagination");
		
		// 페이징처리
		pagination.put("page", page);
		pagination.put("totalCount", count);
	
		data.put("contents", datas);
		return map;
	
	}
	
	public JsonNode getJson(String jsonString) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(jsonString);
		
		return jsonNode;
	}
	
}
