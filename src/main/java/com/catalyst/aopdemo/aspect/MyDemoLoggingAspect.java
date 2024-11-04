package com.catalyst.aopdemo.aspect;

import com.catalyst.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //this is where we add all our related advices for logging

    //let's start with an @Before advice

//    @Before("execution(public void com.catalyst.aopdemo.dao.AccountDAO.addAccount())")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }

//    @Before("execution(public void addAccount())")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }

//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }

//    @Before("execution(void add*())")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }

//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }

    //only taking a parameter of Account
//    @Before("execution(void add*(com.catalyst.aopdemo.Account))")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }


    //match to any number of argument, and account
//    @Before("execution(void add*(com.catalyst.aopdemo.Account, ..))")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }

    //pass all argument, any return type and argument
//    @Before("execution(* add*(..))")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }

    //for a package, all classes and all methods and any arguments
//    @Before("execution(* com.catalyst.aopdemo.dao.*.*(..))")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }

    //PointCut Declaration

//    @Pointcut("execution(* com.catalyst.aopdemo.dao.*.*(..))")
//    private void forDaoPackage(){}
//
//    //create a pointcut for getter methods
//    @Pointcut("execution(* com.catalyst.aopdemo.dao.*.get*(..))")
//    private void getter(){}
//
//    //create a pointcut for setter methods
//    @Pointcut("execution(* com.catalyst.aopdemo.dao.*.set*(..))")
//    private void setter(){}
//
//
//    //create pointcut: include package ... exclude getter/setter
//    @Pointcut("forDaoPackage() && !(getter() || setter())")
//    private void forDaoPackageNoGetterSetter(){}

//    @Before("forDaoPackage()")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//
//    }
//
//    @Before("forDaoPackage()")
//    public void performApiAnalytics(){
//        System.out.println("\n ====>>> Performing API Advice");
//    }

//    //The fully qualified class package was necessary to identify the pointcut
//    @Before("com.catalyst.aopdemo.aspect.CatalystAopExpressions.forDaoPackageNoGetterSetter()")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n ====>>> Executing @Before advice  on method");
//    }


    //The fully qualified class package was necessary to identify the pointcut
    @Before("com.catalyst.aopdemo.aspect.CatalystAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n ====>>> Executing @Before advice  on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        //display the method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop through args
        for(Object tempArg: args){
            System.out.println(tempArg);

            if(tempArg instanceof Account) {
                //dowmcast and print Account specific stuff

                Account theeAccount = (Account) tempArg;

                System.out.println("account name: " + theeAccount.getName());
                System.out.println("account level: " + theeAccount.getLevel());
            }
        }

    }

//    @Around("execution(* com.catalyst.aopdemo.service.*.getFortune(..))")
//    public Object aroundGetFortune(
//            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
//
//        //print out the method we are advising on
//        String method = theProceedingJoinPoint.getSignature().toShortString();
//
//        System.out.println("\n=====>>> Excecuting @Around on method: " + method);
//
//        //get begin timestamp
//        long begin = System.currentTimeMillis();
//
//        //now, let's execute the method
//
//        Object result = null;
//         try {
//             result = theProceedingJoinPoint.proceed();
//         } catch (Exception e) {
//             //log the exception
//             System.out.println(e.getMessage());
//
//             //give user a custom message
//             result = "Major accident! But no worries, your private AOP helicopter is on the way";
//         }
//
//        //get end timestamp
//        long end = System.currentTimeMillis();
//
//        //compute duration and display it
//        long duration = end - begin;
//        System.out.println("\n=====>> Duration: " + duration / 1000.0 + " seconds");
//
//        return result;
//
//    }


    //rethroe the exception
    @Around("execution(* com.catalyst.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        //print out the method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();

        System.out.println("\n=====>>> Excecuting @Around on method: " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now, let's execute the method

        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            //log the exception
            System.out.println(e.getMessage());

            //rethrow exception
            throw e;
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;
        System.out.println("\n=====>> Duration: " + duration / 1000.0 + " seconds");

        return result;

    }


    @After("execution(* com.catalyst.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint){
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n=====>>> Excecuting @After (finally) on method: " + method);


    }

    @AfterThrowing(
            pointcut = "execution(* com.catalyst.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n=====>>> Excecuting @AfterThrowing on method: " + method);

        //log the exception
        System.out.println("\n=====>>> The exception is:  " + theExc);

    }


    @AfterReturning(
            pointcut = "execution(* com.catalyst.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n=====>>> Excecuting @AfterReturning on method: " + method);

        //print out the result of the method call
        System.out.println("\n=====>>> result is:  " + result);

        //let's post process the data ... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> result is:  " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts

        for(Account tempAccount: result){

            //get the uppercase version of name
            String theUpperCaseName = tempAccount.getName().toUpperCase();

            //update the name on the account

            tempAccount.setName(theUpperCaseName);
        }



    }


}
