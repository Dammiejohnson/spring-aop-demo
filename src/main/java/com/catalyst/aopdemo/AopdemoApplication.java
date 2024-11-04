package com.catalyst.aopdemo;

import com.catalyst.aopdemo.dao.AccountDAO;
import com.catalyst.aopdemo.dao.MembershipDAO;
import com.catalyst.aopdemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {
		return runner -> {

			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

//			demoTheAfterReturningAdvice(theAccountDAO);

//			demoTheAfterThrowingAdvice(theAccountDAO);

//			demoTheAfterAdvice(theAccountDAO);

//			demoTheAroundAdvice(theTrafficFortuneService);

//			demoTheAroundAdviceHandleException(theTrafficFortuneService);

			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowgit giyException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		//call the methods to find accounts
		List<Account> theAccounts = null;

		try{
			//add a boolean flag to simulate the exception
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception ex) {

			System.out.println("\n\nMain Program: ... caught exception: " + ex);
		}
		//display the accounts
		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("-------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		//call the methods to find accounts
		List<Account> theAccounts = null;

		try{
			//add a boolean flag to simulate the exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception ex) {

			System.out.println("\n\nMain Program: ... caught exception: " + ex);
		}
		//display the accounts
		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("-------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO){
		//call the methods to find accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		//display the accounts
		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("-------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}



	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

//		//call the business method
//		theAccountDAO.addAccount();

//		//call the business method
//		Account myAccount = new Account();
//		theAccountDAO.addAccount(myAccount);

		//call the business method
		Account myAccount = new Account();
		myAccount.setName("Chinedu");
		myAccount.setLevel("Diamond");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();


		//call the accountdao getter/setter methods
		theAccountDAO.setName("Dami");
		theAccountDAO.setServiceCode("Silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		//call the membership method
//		theMembershipDAO.addAccount();


       // call the membership method
		theMembershipDAO.addSilly();
		theMembershipDAO.goToSleep();

	}

}
