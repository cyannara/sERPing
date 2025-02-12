package com.beauty1nside.hr.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.hr.dto.EmployeeDTO;
import com.beauty1nside.hr.mapper.EmployeeMapper;
import com.beauty1nside.hr.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class EmployeeServiceImpl implements EmployeeService{
	
		private final EmployeeMapper employeeMapper;

		@Override
		@Transactional
		public List<EmployeeDTO> getAllEmployees() {
			return employeeMapper.getAllEmployees();
		}

		@Override
		@Transactional
		public EmployeeDTO getEmployeeById(Long employeeNum) {
			return employeeMapper.getEmployeeById(employeeNum);
		}

		@Override
		public void insertEmployee(EmployeeDTO employee) {
			employeeMapper.insertEmployee(employee);
			
		}

		@Override
		public void updateEmployee(EmployeeDTO employee) {
			employeeMapper.updateEmployee(employee);
			
		}

		@Override
		public void deleteEmployee(Long employeeNum) {
			employeeMapper.deleteEmployee(employeeNum);
			
		}
		

}
