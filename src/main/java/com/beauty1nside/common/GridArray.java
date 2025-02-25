package com.beauty1nside.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
	
	public List<ObjectNode> getNewList(String jsonString) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(jsonString);
		
		// 각각의 배열을 가져옵니다.
        ArrayNode closingArray = (ArrayNode) jsonNode.get("bhf_closing");
        ArrayNode returningArray = (ArrayNode) jsonNode.get("bhf_returning");
        ArrayNode orderArray = (ArrayNode) jsonNode.get("bhf_order");
        
        // 세 배열 중 최대 길이를 구합니다.
        int maxLength = Math.max(closingArray.size(), Math.max(returningArray.size(), orderArray.size()));
        
        List<ObjectNode> result = new ArrayList<>();
        
        for (int i = 0; i < maxLength; i++) {
            // 인덱스 i에 해당하는 병합 객체 생성
            ObjectNode mergedNode = objectMapper.createObjectNode();

            // bhf_closing 배열의 요소 병합 (존재하는 경우)
            if (i < closingArray.size()) {
                JsonNode closingNode = closingArray.get(i);
                if (closingNode.isObject()) {
                    closingNode.fieldNames().forEachRemaining(field -> 
                        mergedNode.set(field, closingNode.get(field))
                    );
                }
            }
            
            // bhf_returning 배열의 요소 병합 (존재하는 경우)
            if (i < returningArray.size()) {
                JsonNode returningNode = returningArray.get(i);
                if (returningNode.isObject()) {
                    returningNode.fieldNames().forEachRemaining(field -> 
                        mergedNode.set(field, returningNode.get(field))
                    );
                }
            }
            
            // bhf_order 배열의 요소 병합 (존재하는 경우)
            if (i < orderArray.size()) {
                JsonNode orderNode = orderArray.get(i);
                if (orderNode.isObject()) {
                    orderNode.fieldNames().forEachRemaining(field -> 
                        mergedNode.set(field, orderNode.get(field))
                    );
                }
            }
            
            result.add(mergedNode);
        }
		
		
		return result;
	}

	
}
