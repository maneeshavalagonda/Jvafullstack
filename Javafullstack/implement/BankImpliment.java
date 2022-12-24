package com.example.Javafullstack.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Javafullstack.Blueprint.Bank;
import com.example.Javafullstack.Repository.BankInterface;
import com.example.Javafullstack.Service.BankService;

@Service
public  class BankImpliment implements BankService{
	private BankInterface employeeInt;//non primitative type obj attribute

	public BankImpliment(BankInterface employeeInt) {

		this.employeeInt = employeeInt;
	}

		public List<Bank> fetchAllEmployee(){

			return employeeInt.findAll();//select * from learners_table
		}
         @Override//for redable purpose
			public Bank saveEmployee(Bank obj) {//Restaurents-Salary//insert-read
				return employeeInt.save(obj);  //insert query 
			}

			//get , find --> fetch only 1 rec on the basis id provided
			//findall
			
			public Object viewEmployefromDB() {
				
				return employeeInt;
			}
			public Bank getEmployeeById(int id) {
				return	employeeInt.findById(id).get();
				}
				

			public void deleteEmployeeByid(int id) {
				employeeInt.deleteById(id);
				
			}
			

}