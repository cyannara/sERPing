package com.beauty1nside.accnut.service;

import java.util.List;

import com.beauty1nside.accnut.dto.IncidentalCostDTO;
import com.beauty1nside.accnut.dto.IncidentalCostSearchDTO;

public interface IncidentalCostService {
	IncidentalCostDTO info(String incidentalCostCode);
	List<IncidentalCostDTO> list(IncidentalCostSearchDTO dto);
	int count(IncidentalCostSearchDTO dto);
}
