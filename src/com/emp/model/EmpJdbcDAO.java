package com.emp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

public class EmpJdbcDAO implements EmpDAO_interface {
	private JdbcTemplate jdbcTemplate;
	
	private final  String GETALL_STMT =  "select * from emp";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(EmpVO empVO) {
		jdbcTemplate.update("INSERT INTO emp(ename)VALUES (?)",new Object[]{empVO.getEname()});
	}

	@Override
	public void update(EmpVO empVO) {
		System.out.println(empVO+" step2 ");
		jdbcTemplate.update("update emp set ename=? where eid =?",new Object[]{empVO.getEname(),empVO.getEid()});
		
	}

	@Override
	public void delete(Integer eid) {
		  int rows = jdbcTemplate.update("delete from emp where eid =?", new Object[]{eid},new int[]{Types.BIGINT});
		  System.out.println(rows + " row(s) deleted.");		
	}

	@Override
	public EmpVO findByPrimaryKey(Integer eid) {
		EmpVO empVO = new EmpVO();
		jdbcTemplate.query("SELECT * FROM emp WHERE eid = ?",  
                new Object[] {eid},  
                new RowCallbackHandler() {  
                    public void processRow(ResultSet rs) throws SQLException {  
                    	empVO.setEid(rs.getInt("eid"));  
                    	empVO.setEname(rs.getString("ename"));  

                    }  
                });  
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		jdbcTemplate.query(GETALL_STMT, new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException{
				EmpVO empVO = new EmpVO();
				empVO.setEid(rs.getInt("eid"));
				empVO.setEname(rs.getString("ename"));
				list.add(empVO);
			}
		});		
		return list;
	}



}
