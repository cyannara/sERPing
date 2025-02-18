package com.beauty1nside.accnut.mapper;

import java.util.List;

import com.beauty1nside.accnut.dto.IncidentalCostDTO;
import com.beauty1nside.accnut.dto.IncidentalCostSearchDTO;

public interface IncidentalCostMapper {
	IncidentalCostDTO info(String incidentalCostCode);
	List<IncidentalCostDTO> list(IncidentalCostSearchDTO dto);
	int count(IncidentalCostSearchDTO dto);
}
