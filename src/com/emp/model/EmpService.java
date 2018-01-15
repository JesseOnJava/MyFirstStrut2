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
		//��1: ���Mmodel-config1-DriverManagerDataSource.xml�]�i�H��
		//��2: �����F�ϥ�Apache DBCP�s�u��,�H�����į�,�ҥH���U��model-config2-JndiObjectFactoryBean.xml����dataSource�]�w�O�ĥ�org.springframework.jndi.JndiObjectFactoryBean
//		ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
//		dao =(EmpDAO_interface) context.getBean("empDAO");
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
		dao =(EmpDAO_interface) context.getBean("empJdbcDAO");
	}

	// ���ϥ�
	public EmpVO addEmp(String ename) {

		EmpVO empVO = new EmpVO();

		empVO.setEname(ename);

		dao.insert(empVO);

		return empVO;
	}

	// �w�d�� Struts 2 �Ϊ�
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

	// ���ϥ�
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
