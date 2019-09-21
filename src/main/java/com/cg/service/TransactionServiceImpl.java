package com.cg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.TransactionDao;
import com.cg.model.CustomerDetails;
import com.cg.model.TransactionDetails;


@Transactional
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionDao trans;

	public int deposit(int accNo, int amt) {
		// TODO Auto-generated method stub
		return trans.deposit(accNo,amt);
	}

	public int withdraw(int accNo,  int amt) {
		// TODO Auto-generated method stub
		return trans.withdraw(accNo,amt);
	}

	public int showBalance(int accNo) {
		// TODO Auto-generated method stub
		return trans.showBalance(accNo);
	}

	public TransactionDetails fundTransfer(int accNo, TransactionDetails transaction) {
		// TODO Auto-generated method stub
		return trans.fundTransfer(accNo, transaction);
	}

	public ArrayList<TransactionDetails> getAllTransaction() {
		// TODO Auto-generated method stub
		return trans.getAllTransaction();
	}
	
	

}
