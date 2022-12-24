package com.example.Javafullstack.Blueprint;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int EmployeeId;
	@Column(nullable=false)
	private String EmployeeName;
	@Column
	private int Salary;
	@Column
	private String EmployeeSec;
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getEmployeeSec() {
		return EmployeeSec;
	}
	public void setEmployeeSec(String employeeSec) {
		EmployeeSec = employeeSec;
	}
	

}
