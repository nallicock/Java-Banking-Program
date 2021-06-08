import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Account //parent/outer class for the savings and chequings
{
	private String ownerName;
	private int accountNumber;
	private String email;
	private String address;
	private String postalCode;
	private String phoneNumber;
	
	public Account(String _ownerName, int _accountNumber, String _email, 
			String _address, String _postalCode, String _phoneNumber)
	{
		this.ownerName = _ownerName;
		this.accountNumber = _accountNumber;
		this.email = _email;
		this.address = _address;
		this.postalCode = _postalCode;
		this.phoneNumber = _phoneNumber;
	}
	
	
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public String getPostalCode()
	{
		return this.postalCode;
	}
	
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	public class Chequings//inner class of account
	{
		private String accountType = "Chequings";
		private double balance = 0;
		public Chequings(double _balance)
		
		{
			this.balance = _balance;
		}
		
		public void deposit(double amount)
		{
			this.balance += amount;
			System.out.println("Your $" + amount + " deposit to your " + accountType + " has been processed.\n"
					+ "Your new " + accountType + " balance is: $" + balance + ".\n");
		}
			
		public void withdraw(double amount)
		{
			if(this.balance - amount >= 0) {
			this.balance -= amount;
			System.out.println("Your withdrawl of $" + amount + " from your " + accountType + " has been processed.\n"
					+ "Your new " + accountType + " balance is: " + balance + ".\n");
			}
			
			else
			{
				System.out.println("Insufficient funds to withdraw $" + amount + " from " + accountType + ".\n");
			}
		}
		
		public void viewBalance()
		{
			System.out.println("\nThis " + accountType + " account's balance is: $" + this.balance + ".\n");
		}
		
		public void viewDetails()
		{
			System.out.println("Hi, " + ownerName +". This " + accountType + " account's balance is: $" + balance + ".\n"
					+ "Account Details:\n"
					+ "Email: " + getEmail()
					+ "\nAddress: " + getAddress()
					+ "\nPostal Code: " + getPostalCode()
					+ "\nPhone Number: " + getPhoneNumber() + "\n");
		}
		
	}
	
	public class Savings //inner class of account
	{
		private String accountType = "Savings";
		private double balance = 0;
		
		public Savings(double _balance)
		
		{
			this.balance = _balance;
		}
		
		public void deposit(double amount)
		{
			this.balance += amount;
			System.out.println("Your $" + amount + " deposit to your " + accountType + " has been processed.\n"
					+ "Your new " + accountType + " balance is: $" + balance + ".\n");
		}
			
		public void withdraw(double amount)
		{
			if(this.balance - amount >= 0) {
			this.balance -= amount;
			System.out.println("Your withdrawl of $" + amount + " from your " + accountType + " has been processed.\n"
					+ "Your new " + accountType + " balance is: " + balance + ".\n");
			}
			
			else
			{
				System.out.println("Insufficient funds to withdraw $" + amount + " from " + accountType + ".\n");
			}
		}
		
		public void viewBalance()
		{
			System.out.println("\nThis " + accountType + " account's balance is: $" + this.balance + ".\n");
		}
		
		public void viewDetails()
		{
			System.out.println("Hi, " + ownerName +". This " + accountType + " account's balance is: $" + balance + ".\n"
					+ "Account Details:\n"
					+ "Email: " + getEmail()
					+ "\nAddress: " + getAddress()
					+ "\nPostal Code: " + getPostalCode()
					+ "\nPhone Number: " + getPhoneNumber() + "\n");
		}
	
	}
	
	public class InterestSavings extends Savings
	{	
		private double balance;
		private String accountType = "Interest Savings";
		private double interestRate;
		
		public InterestSavings(double _balance, double _interestRate)
		{
			super(_balance);
			this.interestRate = _interestRate;
		}
		
		@Override
		public void deposit(double amount)
		{
			this.balance += amount;
			System.out.println("Your $" + amount + " deposit to your " + accountType + " has been processed.\n"
					+ "Your new " + accountType + " balance is: $" + balance + ".\n");
		}
		
		@Override
		public void withdraw(double amount)
		{
			if(this.balance - amount >= 0) {
			this.balance -= amount;
			System.out.println("Your withdrawl of $" + amount + " from your " + accountType + " has been processed.\n"
					+ "Your new " + accountType + " balance is: " + balance + ".\n");
			}
			
			else
			{
				System.out.println("Insufficient funds to withdraw $" + amount + " from " + accountType + ".\n");
			}
		}
		
		public void viewBalance()
		{
			System.out.println("\nThis " + interestRate * 100 + "% " + accountType + " account's balance is: $" + this.balance + ".\n");
		}
		
		@Override
		public void viewDetails()
		{
			System.out.println("Hi, " + ownerName +". This " + interestRate * 100 + "% " + accountType + " account's balance is: $" + this.balance + ".\n"
					+ "Account Details:\n"
					+ "Email: " + getEmail()
					+ "\nAddress: " + getAddress()
					+ "\nPostal Code: " + getPostalCode()
					+ "\nPhone Number: " + getPhoneNumber() + "\n");
		}
		
		
	}
		
	
	//transfer funds... implement later
	
}
