package com.mycom.myapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.dto.EmpDto;

@Mapper
public interface EmpDao {
	
	// emp-mapper.xml 대응
	List<EmpDto> listEmp();
	EmpDto detailEmp(int employeeId);
	int insertEmp(EmpDto empDto);
	int updateEmp(EmpDto empDto);	
	int deleteEmp(int employeeId);
	
	// emp-mapper-2.xml 대응
	List<EmpDto> listEmpLike(String searchWord);
	List<EmpDto> listEmpMap();
	List<EmpDto> listEmpWhereIf(Map<String,String> map); // emp-mapper-2의 resultMap의 id가 empMap의 타입이 EmpDto이다
}
