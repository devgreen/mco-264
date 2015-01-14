package billOrganizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class UseBill {

	public static void main(String[] args) throws ParseException {
		SortedLinkedList<Bill> list = new SortedLinkedList<Bill>();
		Scanner input;
		try {
			input = new Scanner(new File("./getbills.txt"));
			while (input.hasNext()) {
				Bill bill = new Bill(input);
				list.insert(bill);
				// list.insert(bill, new BillTypeComparetor ());
				// list.insert(bill, new BillAmountComparetor ());
				// list.insert(bill, new BillDateComparetor ());
			}
			LinkedListIterator<Bill> oneIter = list.iterator();
			oneIter.reset();
			while (oneIter.hasNext()) {
				System.out.println(oneIter.next());
			}

			Bill bill = new Bill("Macys", 150.0, "2/01/2014", BillType.valueOf("CLOTHING"));
			// System.out.println(bill.toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
