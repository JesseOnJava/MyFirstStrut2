package com.action;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class SayHiAction {
	private EmpVO empVO;	
	public EmpVO getEmpVO() {
		return empVO;
	}

	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}

	public String execute(){
		System.out.println("SayHiAction running!!");
		empVO.setEname(empVO.getEname()+"你好"); 
		return "success";
	}
	
	public String getOne(){
		EmpService empSvc = new EmpService();
		empVO = empSvc.getOneEmp(empVO.getEid());
		return "success";
	}
	
	public String add(){
		System.out.println("SayHiAction running!! add");
		EmpService empSvc = new EmpService();
		empSvc.addEmp(empVO);
		System.out.println("資料庫 insert 成功");	
		return "add";
	}
	
	public String update(){
		System.out.println("SayHiAction running!! update");
		EmpService empSvc = new EmpService();
		empSvc.updateEmp(empVO);
		return "success";
	}
	
	public String delete(){
		System.out.println("SayHiAction running!! delete");
		EmpService empSvc = new EmpService();
		empSvc.deleteEmp(empVO.getEid());
		return "success";		
	}
	
	
}
