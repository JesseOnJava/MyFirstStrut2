package com.emp.model;

import java.util.List;

import org.springframework.beans.factory.BeanFactory; 
import org.springframework.beans.factory.xml.XmlBeanFactory; 
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestAction {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("model-config1-DriverManagerDataSource.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		EmpVO empVO = (EmpVO) factory.getBean("empVO");
		
		EmpService empSvc = new EmpService();
		
		
		EmpVO empVO3 = empSvc.getOneEmp(7004);
		System.out.println(empVO3.getEid()+","+empVO3.getEname());

//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEname("ºë¸Û");
//		empSvc.addEmp(empVO2);
		
//		empSvc.deleteEmp(7018);
		
		EmpVO empVO4 = new EmpVO();
		empVO4.setEid(new Integer(7002));
		empVO4.setEname("¤j²´");
		System.out.println( empVO4+" step1 ");
		empSvc.updateEmp(empVO4);
//		EmpVO reVO =  empSvc.updateEmp(empVO);
//		System.out.println( empSvc.getOneEmp(7002));
		
		List<EmpVO> list =  empSvc.getAll();
		for(int i =0;i<list.size();i++){
			EmpVO emp =  (EmpVO) list.get(i);
//			System.out.println(emp.getEid()+","+emp.getEname());		
			System.out.println(emp);
		}
	}

}
