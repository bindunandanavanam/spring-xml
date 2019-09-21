package com.cg.service;

import java.util.ArrayList;

import com.cg.model.CustomerDetails;
import com.cg.model.TransactionDetails;

public interface TransactionService {
	public int deposit(int accNo, int amt);
	public int withdraw(int accNo, int amt);
	public int showBalance(int accNo);
	public TransactionDetails fundTransfer(int accNo, TransactionDetails transaction);
	public ArrayList<TransactionDetails> getAllTransaction();
}
