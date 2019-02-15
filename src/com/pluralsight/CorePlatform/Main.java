package com.pluralsight.CorePlatform;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        BankAccount acct1 = new BankAccount("1234");
        BankAccount acct2 = new BankAccount("5678",500);

        System.out.println("acct1 id:  "+acct1.getId()+" || acct 1 balance:  "+acct1.getBalance());
        System.out.println("acct2 id:  "+acct2.getId()+" || acct 2 balance:  "+acct2.getBalance());

        BankAccount acct = new BankAccount("1234");
        doWork(acct);

        Class<?> c2 = Class.forName("com.pluralsight.CorePlatform.BankAccount");
        showName(c2);

        Class<?> c3 = BankAccount.class;
        showName(c3);

        Class<BankAccount> c4 = BankAccount.class;
        showName(c4);

        System.out.println();
        System.out.println("*** HighVolume Account ***");
        System.out.println();
        HighVolumeAccount acct4 = new HighVolumeAccount("1234", 1000);
        HighVolumeAccount acct5 = new HighVolumeAccount("5678",500);
        System.out.println("acct4 id:  "+acct4.getId()+" || acct 4 balance:  "+acct4.getBalance());
        System.out.println("acct5 id:  "+acct5.getId()+" || acct 5 balance:  "+acct5.getBalance());
        acct4.run();
        acct5.run();
        System.out.println("acct4 id:  "+acct4.getId()+" || acct 4 balance:  "+acct4.getBalance());
        System.out.println("acct5 id:  "+acct5.getId()+" || acct 5 balance:  "+acct5.getBalance());

        classInfo(acct4);
        typeModifiers(acct4);

        System.out.println();
        System.out.println("*** Accessing Type Member Information test***");
        System.out.println();

        fieldInfo(acct1);
        methodInfo(acct1);
        methodInfo2(acct4);

        callGetId(acct1);

        BankAccount acct6 = new BankAccount("1234",500);

        callDeposit(acct6,50 );
        System.out.println("Balance for Acct6:  " + acct6.getBalance());

        System.out.println();
        System.out.println("*** Creating the Work Dispatch System ***");
        System.out.println();
        BankAccount acct7 = new BankAccount("1234", 500);
        //never got this to work -- didn't explain how you pass in the parameters for the transactional work...
        startWork("com.pluralsight.CorePlatform.AccountWorker", acct7, 'd', 100);


    }

    private static void doWork(Object obj){
        Class<?> c = obj.getClass();
        showName(c);
    }

    private static void showName(Class<?> theClass){
        System.out.println("Object name:  " + theClass.getSimpleName());
    }

    private static void classInfo(Object obj){
        Class<?> theClass = obj.getClass();
        System.out.println("Object name:  " + theClass.getSimpleName());

        Class<?> superClass = theClass.getSuperclass();
        System.out.println("Super Class name:  " + superClass.getSimpleName());

        Class<?>[] interfaces = theClass.getInterfaces();
        for(Class<?> iface:interfaces)
            System.out.println(iface.getSimpleName());

    }

    private static void typeModifiers(Object obj){
        Class<?> theClass = obj.getClass();
        System.out.println("Object name:  " + theClass.getSimpleName());

        int modifiers = theClass.getModifiers();

        if ((modifiers & Modifier.FINAL) > 0)  //if bit turned on, will get > 0
            System.out.println("Bitwise check - final");

        if(Modifier.isFinal(modifiers))
            System.out.println("Method check - final");

        if(Modifier.isPrivate(modifiers))
            System.out.println("Method check - private");
        else if(Modifier.isProtected(modifiers))
            System.out.println("Method check - protected");
        else if(Modifier.isPublic(modifiers))
            System.out.println("Method check - public");


    }

    private static void fieldInfo(Object obj){
        Class<?> theClass = obj.getClass();
        System.out.println("Object name:  " + theClass.getSimpleName());

        Field[] fields = theClass.getFields();
        System.out.println("Fields");
        displayFields(fields);

        Field[] declaredFields = theClass.getDeclaredFields();
        System.out.println("Declared Fields");
        displayFields(declaredFields);

    }

    private static void displayFields(Field[] arr){

        for(Field f:arr)
            System.out.println(f.getName() + " : " + f.getType());
    }

    private static void methodInfo(Object obj){
        Class<?> theClass = obj.getClass();
        System.out.println("Object name:  " + theClass.getSimpleName());

        Method[] methods = theClass.getMethods();
        System.out.println("*** Methods ***");

        for(Method m:methods)
            System.out.println(m.getName());

        Method[] declMethods = theClass.getMethods();
        System.out.println("*** Declared Methods ***");

        for(Method m:declMethods)
            System.out.println(m.getName());



    }


    private static void methodInfo2(Object obj){
        Class<?> theClass = obj.getClass();
        System.out.println("Object name:  " + theClass.getSimpleName());

        Method[] methods = theClass.getMethods();
        System.out.println("*** Methods that we've written ***");

        for(Method m:methods)
            if(m.getDeclaringClass() != Object.class)
                System.out.println(m.getName());

        Method[] declMethods = theClass.getMethods();
        System.out.println("*** Declared Methods that we've written ***");

        for(Method m:declMethods)
            if(m.getDeclaringClass() != Object.class)
                System.out.println(m.getName());

    }


    private static void callGetId(Object obj) {

        try {

            System.out.println("Getting Object Id w/o object name by calling a method");

            Class<?> theClass = obj.getClass();
            System.out.println("Object name:  " + theClass.getSimpleName());

            Method m = theClass.getMethod("getId");
            Object result = m.invoke(obj); //get into the object instance, call get id method, and pass back results

            System.out.println("Result:  " + result);

        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }
    }

    private static void callDeposit(Object obj, int amt){

        try {

            System.out.println("Depositing w/o object name by calling a method");

            Class<?> theClass = obj.getClass();
            System.out.println("Object name:  " + theClass.getSimpleName());

            Method m = theClass.getMethod("deposit", int.class);
            Object result = m.invoke(obj,amt); //get into the object instance, call deposit method with $50, and pass back results

        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }


    }

    private static void startWork(String workerTypeName, Object workerTarget, char txType, int amt){

        try {

            System.out.println("Startwork in the worker method");

            Class<?> workerType = Class.forName(workerTypeName);
            Class<?> targetType = workerTarget.getClass();

            Constructor c = workerType.getConstructor(targetType);
            Object worker = c.newInstance(workerTarget);
            Method doWork = workerType.getMethod("doWork");
            doWork.invoke(worker);

        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }


    }






}
