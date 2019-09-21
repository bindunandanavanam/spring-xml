package com.cg.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cg.model.CustomerDetails;
import com.cg.model.TransactionDetails;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	int transId = 101;
	ArrayList<TransactionDetails> transList = new ArrayList<TransactionDetails>();
	@Autowired
	BankDaoImpl bankDao;
	public int deposit(int accNo, int amt) {
		// TODO Auto-generated method stub
		int amount = 0;
		System.out.println(accNo);
		for (CustomerDetails customerDetails : bankDao.custList) {
			if(customerDetails.getAccountNo() == accNo) {
				 amount = customerDetails.getBalance()+amt;
				customerDetails.setBalance(amount);
			}
		}
		return amount;
	}

	public int withdraw(int accNo,int amt) {
		// TODO Auto-generated method stub
		int amount = 0;
		for (CustomerDetails customerDetails : bankDao.custList) {
			if(customerDetails.getAccountNo() == accNo) {
				if(customerDetails.getBalance()>amt) {
					amount = customerDetails.getBalance()-amt;
					customerDetails.setBalance(amount);
				}
				else {
					System.out.println("No");
				}
			}
		}
		return amount;
	}

	public int showBalance(int accNo) {
		// TODO Auto-generated method stub
		int amount = 0;
		for (CustomerDetails customerDetails : bankDao.custList) {
			if(customerDetails.getAccountNo() == accNo) {
				amount = customerDetails.getBalance();
			}
		}
		return amount;
	}

	public TransactionDetails fundTransfer(int accNo, TransactionDetails transaction) {
		// TODO Auto-generated method stub
		int amount = 0;
		for (CustomerDetails customerDetails : bankDao.custList) {
			if(customerDetails.getAccountNo() == accNo) {
				for (CustomerDetails customerDetails1 : bankDao.custList) {
					if(customerDetails1.getAccountNo() == transaction.getToAcc()) {
						if(customerDetails.getBalance()>transaction.getAmt()) {
							transaction.setFromAcc(accNo);
							transaction.setTransactionId(transId);
							transId++;
							amount = customerDetails.getBalance()-transaction.getAmt();
							customerDetails.setBalance(amount);
							 
							customerDetails1.setBalance(customerDetails1.getBalance()+transaction.getAmt());
							transList.add(transaction);
						}
					}
				}
			}
		}
		return transaction;
	}

	public ArrayList<TransactionDetails> getAllTransaction() {
		// TODO Auto-generated method stub
		return transList;
	}

	
}
