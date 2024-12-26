package com.lub2code.aopdemo;

import com.lub2code.aopdemo.dao.AccountDAO;
import com.lub2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner -> {
			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			demoTheAfterThrowingAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try{
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n\n 메인 프로그램 : ... 예외를 잡았습니다. : " + exc);
			System.out.println("\n\n 메인 프로그램 : demoTheAfterThrowingAdvice : ");
		}

		System.out.println("\n\n메인 프로그램 : demoTheAfterThrowingAdvice");
		System.out.println("--------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO){
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("\n\n메인 프로그램 : demoTheAfterReturningAdvice");
		System.out.println("--------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		// 비즈니스 메서드를 호출
		Account myAccount = new Account();
		myAccount.setName("만식이");
		myAccount.setLevel("브론즈");

		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// accountDAO가 가진 getter/setter 메서드를 호출
		theAccountDAO.setName("봉식이");
		theAccountDAO.setServiceCode("실버");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// 멤버십DAO의 메서드를 호출
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
	}
}
