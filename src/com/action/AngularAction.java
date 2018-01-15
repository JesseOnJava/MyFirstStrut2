package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class AngularAction {
	private int eid;
	private String ename;
	private EmpVO empVO;
	

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public EmpVO getEmpVO() {
		return empVO;
	}

	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}	

	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public String execute() {
		EmpService empSvc = new EmpService();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String jsstr = request.getParameter("value");
//	System.out.println(jsstr);
	System.out.println(eid);
		EmpVO empVO2 = empSvc.getOneEmp(eid);
	System.out.println(empVO2.getEname());
		ename = empVO2.getEname();
		

//		JSONObject jsobj = new JSONObject();
//		JSONParser parser = new JSONParser(); 

//		Object obj = null;
//		try {
//			obj = parser.parse(jsstr);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("object "+obj);
//		JSONObject json = (JSONObject) obj; 
//	
//		int eid = Integer.parseInt(String.valueOf(json.get("eid"))); 
//
//		
//		EmpVO empVO = empSvc.getOneEmp(this.empVO.getEid());
//		this.empVO.setEid(empVO.getEid());
//		this.empVO.setEname(empVO.getEname());
		return "success";
    }
    
//	public boolean getOne() {
//		EmpService empSvc = new EmpService();
//		EmpVO empVO = empSvc.getOneEmp(this.empVO.getEid());
//		if (empVO != null) {
//			HttpServletRequest request = ServletActionContext.getRequest();
//			request.setAttribute("empVO", empVO);
//			return true;
//		} else
//			return false;
//	}

}
