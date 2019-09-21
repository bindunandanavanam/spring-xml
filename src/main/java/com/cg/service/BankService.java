package com.cg.service;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;

import com.cg.model.CustomerDetails;

public interface BankService {
	public CustomerDetails setInfo();
	public CustomerDetails register(CustomerDetails cd);
	public int login(CustomerDetails c);
	public ArrayList<CustomerDetails> getAll();
}
