package jdbc_pool_c3p0_study.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_pool_c3p0_study.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	
	//일반적으로 insert하면 return 타입이 숫자 => 성공 0 실패 1
	int insertDepartment(Department department) throws SQLException;
	
	//삭제
	int deleteDepartment(Department department) throws SQLException;
	
	//변경
	int updateDepartment(Department department) throws SQLException;
	
	//deptNo로 검색
	Department selectDepartmentByNo(Department department) throws SQLException;
}
