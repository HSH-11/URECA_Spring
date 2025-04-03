package com.mycom.myapp.service;

import java.util.List;
import java.util.Map;

import com.mycom.myapp.dto.EmpDto;

public interface EmpService {
	List<EmpDto> listEmp();
	EmpDto detailEmp(int employeeId);
	int insertEmp(EmpDto empDto);
	int updateEmp(EmpDto empDto);	
	int deleteEmp(int employeeId);
	
	//emp-mapper-2.xml 대응
	List<EmpDto> listEmpLike(String searchWord);
	List<EmpDto> listEmpMap();
	List<EmpDto> listEmpMapWhereIF(Map<String,String> map);
}
