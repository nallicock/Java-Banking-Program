import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import  javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;



//Nicholas Allicock	||	Software Developer	||	Java Bank Account Project
public class Main /*extends Application*/ {
	//Button button;
	
	
	public static void promptEnter() //press enter to go to next screen
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter to Continue...");
		scanner.nextLine();
	}
	
	public static void startingUser() //Upon startup, prompt user to input values for the account information
	{
		System.out.println("Welcome to Omar Banking\n"
				+ "To begin, please input the following information:");
	}
	
	public static void menuSelect () //Prints selection menu, prompt user to choose an option
	{
		System.out.print("1. View Account Balance"
				+ "\n2. Deposit Funds"
				+ "\n3. Withdraw Funds"
				+ "\n4. View Account Details"
				+ "\n5. Quit"
				+ "\nPlease Choose an Option: ");
		
		
	}
	
	public static void main (String[] args)
	{
		startingUser();
		
		String _name = null;
		String _email = null;
		String _address = null;
		String _postalCode = null;
		String _phoneNumber = null;
		
		Scanner userInput = new Scanner(System.in);
		
		while(_name == null) {
			System.out.print("Please input name: ");	//inputs for Account constructor
			_name = userInput.nextLine();
			if (_name.isEmpty())
			{
				System.out.print("Invalid input... ");
				_name = null;
			}
		}	
		
		while(_email == null) {
			System.out.print("Please input email: ");
			_email = userInput.nextLine();
			if (_email.isEmpty())
			{
				System.out.print("Invalid input... ");
				_email = null;
			}
		}
		
		while(_address == null) {
			System.out.print("Please input address: ");
			_address = userInput.nextLine();
			if (_address.isEmpty())
			{
				System.out.print("Invalid input... ");
				_address = null;
			}
		}
		
		while(_postalCode == null) {
			System.out.print("Please input postal code: ");
			_postalCode = userInput.nextLine();
			if (_postalCode.isEmpty())
			{
				System.out.print("Invalid input... ");
				_postalCode = null;
			}
		}
		
		while(_phoneNumber == null) {
			System.out.print("Please input phone number: ");
			_phoneNumber = userInput.nextLine();
			if(_phoneNumber.isEmpty())
			{
				System.out.print("Invalid input... ");
				_phoneNumber = null;
			}
		}
		
		String[] myArray = {"Nicholas"};
		
		System.out.println("\n");
		
		//launch(args);
		Account account1 = new Account(_name, _email, _address, _postalCode, _phoneNumber);
		
		Account.Chequings c1 = account1.new Chequings(0);
		Account.Savings s1 = account1.new Savings(0);
		Account.InterestSavings is1 = account1.new InterestSavings(0, 0.05);

			menuSelect();
			int userOption = -1;
			while(userOption != 5) {
			userOption = userInput.nextInt();
			switch(userOption)
			{
			case 1: //view account balance
				c1.viewBalance();
				s1.viewBalance();
				is1.viewBalance();	
				promptEnter();
				menuSelect();
				System.out.println("\n");
				userOption = -1;
				break;
				
			case 2: //deposit funds
				int choice = -1;
				Scanner scanner2 = new Scanner(System.in);
				
				System.out.println("\n");
				System.out.print("Please choose the account you wish to deposit to: "
						+ "\n1. Chequings"
						+ "\n2. Savings"
						+ "\n3. 5% Interest Savings"
						+ "\nEnter option:");
				
				
				choice = scanner2.nextInt();
				
				
				if(choice <= 0 || choice > 3) 
				{
					System.out.println("Invalid entry. Please choose valid option.");
					promptEnter();
				}
				
				else if (choice == 1)
				{
					double dAmount;
					Scanner scanner3 = new Scanner(System.in);
					System.out.print("Enter amount to deposit: ");
					dAmount = scanner3.nextDouble();
					c1.deposit(dAmount);
					promptEnter();
					userOption = -1;

				}
					
				else if (choice == 2)
				{
					double dAmount;
					Scanner scanner3 = new Scanner(System.in);
					System.out.print("Enter amount to deposit: ");
					dAmount = scanner3.nextDouble();
					s1.deposit(dAmount);
					promptEnter();
					userOption = -1;

				}
				
				else if (choice == 3)
				{
					double dAmount;
					Scanner scanner3 = new Scanner(System.in);
					System.out.print("Enter amount to deposit: ");
					dAmount = scanner3.nextDouble();
					is1.deposit(dAmount);
					promptEnter();

				}
					userOption = -1;
					
					menuSelect();
					System.out.println("\n");
				break;
				
				
			case 3: //withdraw
				int wChoice = -1;
				Scanner scanner4 = new Scanner(System.in);
				
				System.out.println("\n");
				System.out.print("Please choose the account you wish to withdraw from: "
						+ "\n1. Chequings"
						+ "\n2. Savings"
						+ "\n3. 5% Interest Savings"
						+ "\nEnter option:");
				
				
				wChoice = scanner4.nextInt();
				
				if(wChoice <= 0 || wChoice > 3)
				{
					System.out.println("\nInvalid entry. Please choose valid option.\n");
				}
				
				else if (wChoice == 1)
				{
					double wAmount;
					Scanner scanner5 = new Scanner(System.in);
					System.out.print("Enter amount to withdraw: ");
					wAmount = scanner5.nextDouble();
					System.out.println("\n");
					c1.withdraw(wAmount);
					promptEnter();
					userOption = -1;

				}
					
				else if (wChoice == 2)
				{
					double wAmount;
					Scanner scanner5 = new Scanner(System.in);
					System.out.print("Enter amount to withdraw: ");
					wAmount = scanner5.nextDouble();
					System.out.println("\n");
					s1.withdraw(wAmount);
					promptEnter();
					userOption = -1;

				}
				
				else if (wChoice == 3)
				{
					double wAmount;
					Scanner scanner5 = new Scanner(System.in);
					System.out.print("Enter amount to withdraw: ");
					wAmount = scanner5.nextDouble();
					System.out.println("\n");
					is1.withdraw(wAmount);
					promptEnter();

				}
					userOption = -1;
				
				
				menuSelect();
				break;
				
			case 4: //view details for accounts
				c1.viewDetails();
				s1.viewDetails();
				is1.viewDetails();
				userOption = -1;
				promptEnter();
				menuSelect();
				break;
				
			case 5: //quit
				System.out.println("Thank you for choosing Omar banking!");
				break;
				
			default:
				System.out.println("Invalid input. ");
				promptEnter();
				menuSelect();
			
					
			}
			
		}

	}
	
	/*@Override
	public void start(Stage stage) throws Exception {
		
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("home.fxml"));
		Scene scene = new Scene(root, 1920, 1080);
		stage.setScene(scene);
		stage.show();
	}*/

}
