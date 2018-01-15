package com.emp.model;

import java.sql.Date;
import java.util.List;
public class EmpVO implements java.io.Serializable{
	private Integer eid;
	private String ename;
	private EmpDAO_interface dao;
	
	public EmpVO() {
		super();
	}
	
	public EmpVO(Integer eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	public EmpDAO_interface getDao() {
		return dao;
	}
	public void setDao(EmpDAO_interface dao) {
		this.dao = dao;
	}

	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public List<EmpVO> getAll(){
		return dao.getAll();
	}
	
	public String toString(){
		String str = this.getEid()+","+this.getEname();
		return str;		
	}
	
	

}
