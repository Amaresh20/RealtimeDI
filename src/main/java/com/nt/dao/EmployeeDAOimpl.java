package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.nt.bo.EmployeeBO;
//@Component
public class EmployeeDAOimpl implements IEmployeeDAO {
	private static final String EMP_INSERT_QUERY="INSERT INTO REALTIMEDI_SPRING_EMPLOYEE VALUES(SP_ENO_SEQ.NEXTVAL,?,?,?,?,?)";
	private DataSource ds;
	

	public EmployeeDAOimpl(DataSource ds) {
		System.out.println("EmployeeDAOimpl:1-param constructor");
		this.ds = ds;
	}
	
	@Override
	public int insertEmployee(EmployeeBO bo) throws Exception {
         System.out.println("EmployeeDAOimpl.insertEmployee()");
		int result=0;
		try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(EMP_INSERT_QUERY)){
				
				
				ps.setString(1,bo.getEname());
				ps.setString(2,bo.getDesg());
				ps.setFloat(3,bo.getBasicSalary());
				ps.setFloat(4,bo.getGrossSalary());
				ps.setFloat(5,bo.getNetSalary());
				result=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

/*
	@Override
	public int insertEmployee(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(EMP_INSERT_QUERY);
			ps.setString(1,bo.getEname());
			ps.setString(2,bo.getDesg());
			ps.setFloat(3,bo.getBasicSalary());
			ps.setFloat(4,bo.getGrossSalary());
			ps.setFloat(5,bo.getNetSalary());
			result=ps.executeUpdate();
;		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		finally{
			
		try {
			if(ps!=null)
				ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	return result;
	
	}*/

}
