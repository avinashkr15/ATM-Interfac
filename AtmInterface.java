package com.AtmInterface;

import java.util.Scanner;

class BankAccount{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance=100000f;
	int transaction=0;
	String  transactionHistory="";
	
	public void register() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Your  Name : ");
		this.name=sc.nextLine();
		
		System.out.println("\nEnter Your  Username : ");	
		this.userName=sc.nextLine();
		
		System.out.println("\nEnter Your Password : ");
		this.password=sc.nextLine();
		
		System.out.println("\nEnter Your Account Number :");
		this.accountNo=sc.nextLine();
		
		System.out.println("\n Registration Completed ...Kindly Login :");
	}
	public boolean login() {
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		
		while(!isLogin) {
			System.out.println("\n Enter Your  Username : ");
			String Username=sc.nextLine();
			
			if(Username.equals(Username)) {
				while(!isLogin) {
					System.out.println("\n Enter Your  Password : ");
					String password=sc.nextLine();
					
					if(password.equals(password)) {
						System.out.println("Login Successfull...");
						
						isLogin=true;
					}
					else {
						System.out.println("\n Incorrect Password : ");
					}
				}
			}
			else {
				System.out.println("\n Username nt found : ");
			}
			
		}
		return isLogin;
	}
	
	public void withdraw() {
		System.out.println("\n Enter Amount to withdraw : ");
		
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		
		try {
		if(balance>=amount) {
			transaction++;
			balance-=amount;
			System.out.println("\n Withdraw Successfull... ");
			
			String str=amount+"Rs Withdrawed\n";
			transactionHistory.concat(str);
			
		}
		else {
			System.out.println("\nInsufficent Balance : ");
		}
		}
		catch(Exception e) {
			
		}
	}
	
	public void deposit() {
		System.out.println("\nEnter amount to deposit : ");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(amount<=100000) {
				transaction++;
				balance+=amount;
				System.out.println("\n Successfully Deposit : ");
				String str=amount+"Rs Deposited\n";
				transactionHistory.concat(str);
				
				
			}
			else {
				System.out.println("Sorry...Limit is 1000000.00 ");
				
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public void transfer() {
		Scanner sc= new Scanner (System.in);
		System.out.println("\n Enter Receipent Name :");
		String receipent=sc.nextLine();
		System.out.println("\n Enter amount to transfer : ");
		float amount=sc.nextFloat();
		
		try {
			if(balance>=amount) {
				if(balance<=60000f) {
					transaction++;
					balance-=amount;
					System.out.println("\nSuccessfully Transtered to"+receipent);
					String str=amount+"Rs transfered to"+receipent+"\n";
					transactionHistory.concat(str);
					
			}
				else {
					System.out.println("\nSorry...Limit is 50000.00");
					
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public  void checkBalance() {
		System.out.println("\n"+balance+"Rs");
		
	}
	public void transactionHistory() {
		if(transaction==0) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n"+transactionHistory);
		}
	}
	
	
}
public class AtmInterface {
	public static int takeIntegerInput(int limit) {
		int input=0;
		boolean flag=false;
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag && input > limit|| input<1) {
					System.out.println("Choose the number between 1 to " + limit);
					flag=false;
				}
			}
			catch(Exception e) {
				System.out.println("Enter only integer value");
				flag=false;
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
		System.out.println("\n                           WELCOME TO PNB ATM SYSTEM               \n");
		System.out.println("1. Register \n2. Exit");
		System.out.println("Enter Your Choice : ");
		int choice=takeIntegerInput(2);
		if(choice==1) {
			BankAccount ba=new BankAccount();
			ba.register();
			while(true) {
				System.out.println("\n1.Login \n2. Exit");
				System.out.println("Enter Your Choice : ");
				int ch=takeIntegerInput(2);
				if(ch==1) {
					if(ba.login()) {
						System.out.println("\n\n                         WELCOME BACK " + ba.name+ "\n                           ");
						boolean isFinished=false;
						while(!isFinished) {
							System.out.println("\n1. Withdraw \n2. Deposit\n3. Transfer \n4. Check Balance\n5. Transaction History\n6. Exti");
							System.out.println("\n Enter Your Choice : ");
							int c=takeIntegerInput(6);
							switch(c) {
							case 1:
								ba.withdraw();
								break;
							case 2:
								ba.deposit();
								break;
							case 3:
								ba.transfer();
								break;
							case 4:
								ba.checkBalance();
								break;
							case 5:
								ba.transactionHistory();
								break;
							case 6:
								isFinished=true;
								break;
								
							}
						}
					}
				}
				else {
					System.exit(0);;
				}
			}
		}
		else {
			System.exit(0);
		}
		
	}

}
