package com.example.Javafullstack.Service;

import java.util.List;

import com.example.Javafullstack.Blueprint.Bank;

public interface BankService {

	List<Bank> fetchAllEmployee();
	Bank saveEmployee(Bank obj);//Restaurents-Employee

	Bank getEmployeeById(int id);
	 Object viewEmployefromDB();
	 void deleteEmployeeByid(int id);

	
	
	

}


	
	
	




	




