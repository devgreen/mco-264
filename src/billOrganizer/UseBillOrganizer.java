package billOrganizer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.Scanner;

public class UseBillOrganizer {

	public static void main(String[] args) {

		BillOrganizer bills = new BillOrganizer();
		Scanner keyboard = new Scanner(System.in);

		int choice;
		do {
			choice = menu();
			try {
				switch (choice) {
				case 1:// add a bill
					System.out.println("Please enter bill information");
					String name = keyboard.next();
					// System.out.println ("");
					double amount = keyboard.nextDouble();
					String date = keyboard.next();
					String type = keyboard.next();
					BillType getType = BillType.valueOf(type);
					Bill bill = new Bill(name, amount, date, getType);
					bills.insert(bill);
					// to show all bills already there + the bill that was just
					// added
					System.out.println(bills.toString());
					break;
				case 2: // total your bills
					double total = bills.totalBills();
					System.out.println("Total: " + total);
					break;
				case 3: // view sorted by date
					BillCriteria criteria = BillCriteria.valueOf("BILLDUEDATE");
					System.out.println(bills.toString(criteria));
					break;

				case 4: // view sorted by type
					criteria = BillCriteria.valueOf("BILLTYPE");
					System.out.println(bills.toString(criteria));
					break;
				case 5: // view sorted by amount
					criteria = BillCriteria.valueOf("BILLAMOUNT");
					System.out.println(bills.toString(criteria));
					break;
				case 6: // pay by date
					criteria = BillCriteria.valueOf("BILLDUEDATE");
					bills.payNextBill(criteria);
					// to show that the bill has been paid and removed
					System.out.println(bills.toString(BillCriteria.valueOf("BILLDUEDATE")));
					break;
				case 7: // pay by type
					criteria = BillCriteria.valueOf("BILLTYPE");
					bills.payNextBill(criteria);
					// to show that the bill has been paid and removed
					System.out.println(bills.toString(BillCriteria.valueOf("BILLTYPE")));
					break;
				case 8: // pay by amount
					criteria = BillCriteria.valueOf("BILLAMOUNT");
					bills.payNextBill(criteria);
					// to show that the bill has been paid and removed
					System.out.println(bills.toString(BillCriteria.valueOf("BILLAMOUNT")));
					break;
				case 9: // pay by bill id
					System.out.println("enter bill id");
					int id = keyboard.nextInt();
					bills.payNextBill(id);
					// to show that the bill has been paid and removed
					System.out.println(bills.toString());
					break;
				case 10: // store
					bills.closeOrganizer("./bills.txt");
					break;
				case 11: // retrieve
					// System.out.println("What is the file name?");
					// keyboard.next();
					// String fileName2 = keyboard.nextLine();
					ObjectInputStream indexFile = new ObjectInputStream(new FileInputStream("./bills.txt"));
					SortedLinkedList<Bill> list = (SortedLinkedList<Bill>) indexFile.readObject();
					bills = new BillOrganizer(list);
					System.out.println(bills.toString());
					indexFile.close();
					break;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (choice != 12);
		// keyboard.close();
	}

	public static int menu() {

		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {

			System.out.println("What would you like to do?");
			System.out.println("1. Add a bill");
			System.out.println("2. Total your bills");
			System.out.println("3. View bills sorted by date");
			System.out.println("4. View bills according to type");
			System.out.println("5. View bills accroding to amount");
			System.out.println("6. Pay first bll due by date");
			System.out.println("7. Pay first bill due by type");
			System.out.println("8. Pay first bill due by amount");
			System.out.println("9. Pay a specific bill by giving the billID");
			System.out.println("10. Store all the bil information");
			System.out.println("11. Retrieve the bills");
			System.out.println("12. Exit the program");
			choice = scanner.nextInt();

		} while (choice < 1 || choice > 12);

		// scanner.close();
		return choice;

	}

}
