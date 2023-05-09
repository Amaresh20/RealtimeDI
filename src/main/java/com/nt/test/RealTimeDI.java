package com.nt.test;




import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class RealTimeDI {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
        MainController controller=factory.getBean("controller",MainController.class);
        Scanner sc=new Scanner(System.in);
        System.out.println("enter employee name");
        String name=sc.next();
        System.out.println("enter employee desg");
        String desg=sc.next();
        System.out.println("enter employee basic salary");
        String basicSalary=sc.next();
        EmployeeVO vo=new EmployeeVO();
        vo.setEname(name);
        vo.setDesg(desg);
        vo.setBasicSalary(basicSalary);
        try {
        	String result=controller.processEmployee(vo);
        	System.out.println(result);
        }
        catch(SQLException se) {
        	se.printStackTrace();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
	}

}
