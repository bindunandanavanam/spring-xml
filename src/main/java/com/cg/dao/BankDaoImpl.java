package com.cg.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.model.CustomerDetails;

@Repository
@Component
public class BankDaoImpl implements BankDao {

	public ArrayList<CustomerDetails> custList;
	public CustomerDetails setInfo() {
		CustomerDetails customer = new CustomerDetails();
		customer.setFirstName("Bindu");
		customer.setLastName("N");
		customer.setEmailId("nvn@gmail.com");
		customer.setAadharNo("123412341234");
		customer.setMobileNo("1234567890");
		customer.setPancardNo(1234);
		customer.setPassword("123");
		customer.setAddress("Hyd");
		customer.setBalance(0);
		customer.setAccountNo(101);
		custList = new ArrayList<CustomerDetails>();
		custList.add(customer);
		return customer;
	}

	public CustomerDetails register(CustomerDetails cd) {
		custList.add(cd);
		return cd;
	}

	public int login(CustomerDetails c) {
		// TODO Auto-generated method stub
		int accNo = 0;
		System.out.println(c.getAccountNo());
		for (CustomerDetails customerDetails : custList) {
			if(customerDetails.getAccountNo() == c.getAccountNo() && customerDetails.getPassword().equals(c.getPassword())) {
				accNo = c.getAccountNo();
			}
		}
		return accNo;
	}

	public ArrayList<CustomerDetails> getAll() {
		// TODO Auto-generated method stub
		return custList;
	}
}
