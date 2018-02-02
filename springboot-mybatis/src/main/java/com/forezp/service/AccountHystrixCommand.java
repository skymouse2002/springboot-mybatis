package com.forezp.service;

import java.util.ArrayList;
import java.util.List;

import com.forezp.entity.Account;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class AccountHystrixCommand extends HystrixCommand<List<Account>> {

	private AccountService accountservice;
	public AccountHystrixCommand(AccountService accountservice) {
		//最少配置:指定命令组名(CommandGroup)  
        super(HystrixCommandGroupKey.Factory.asKey("AccountGroup"));

        this.accountservice=accountservice;
	}

	@Override
	protected List<Account> run() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" *****AccountHystrixCommand Run");
		
		return  accountservice.findAccountList();
	}

	@Override
	protected List<Account> getFallback() {
		// TODO Auto-generated method stub
		Account Account=new Account();
		List<Account> list= new ArrayList<Account>();
		list.add(Account);
		return list;
	}
}
