package com.emp.model;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EmpService {

	private EmpDAO_interface dao;

	public EmpService() {
		//dao = new EmpHibernateDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
//		ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
//		dao =(EmpDAO_interface) context.getBean("empDAO");
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
		dao =(EmpDAO_interface) context.getBean("empJdbcDAO");
	}

	// 未使用
	public EmpVO addEmp(String ename) {

		EmpVO empVO = new EmpVO();

		empVO.setEname(ename);

		dao.insert(empVO);

		return empVO;
	}

	// 預留給 Struts 2 用的
	public void addEmp(EmpVO empVO) {
		dao.insert(empVO);
	}

	public EmpVO updateEmp(Integer eid, String ename, String job,
			java.sql.Date hiredate, Double sal, Double comm, Integer deptno) {

		EmpVO empVO = new EmpVO();

		empVO.setEname(ename);

		dao.update(empVO);

		return dao.findByPrimaryKey(eid);
	}

	// 未使用
	public EmpVO updateEmp(EmpVO empVO) {
		dao.update(empVO);
		return dao.findByPrimaryKey(empVO.getEid());
	}

	public void deleteEmp(Integer eid) {
		dao.delete(eid);
	}

	public EmpVO getOneEmp(Integer eid) {
		return dao.findByPrimaryKey(eid);
	}

	public List<EmpVO> getAll() {
		return dao.getAll();
	}
	
	public static EmpVO jsonDataForUpdate(String filename)
	{
		System.out.println("inside filetostring "+filename);
		EmpVO empVO = new EmpVO();
		 JSONParser parser = new JSONParser(); 
			try { 
				
				Object obj = parser.parse(filename);
				System.out.println("object "+obj);
			JSONObject json = (JSONObject) obj; 
			
			int eid = Integer.parseInt(String.valueOf(json.get("eid"))); 
			empVO.setEid(eid);
//			getOneEmp(eid);			
			
			}
			catch (Exception ex) {  }
		return empVO;
	    
	}
}
