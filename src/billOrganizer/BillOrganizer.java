package billOrganizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Scanner;

public class BillOrganizer {

	private PriorityQueue<Bill> date;
	private PriorityQueue<Bill> amount;
	private PriorityQueue<Bill> billType;
	private SortedLinkedList<Bill> list;

	public BillOrganizer(String fileName) throws FileNotFoundException, ParseException, DuplicateDataException {
		Scanner input = new Scanner(new File(fileName));
		while (input.hasNext()) {
			Bill nextBill = new Bill(input);
			list.insert(nextBill);
			date.enqueue(nextBill, new BillDateComparetor());
			amount.enqueue(nextBill, new BillAmountComparetor());
			billType.enqueue(nextBill, new BillTypeComparetor());
		}
	}

	public BillOrganizer() {
		date = new PriorityQueue<Bill>(new BillDateComparetor());
		amount = new PriorityQueue<Bill>(new BillAmountComparetor());
		billType = new PriorityQueue<Bill>(new BillTypeComparetor());
		list = new SortedLinkedList<Bill>();
	}

	public BillOrganizer(SortedLinkedList <Bill> listb) throws ClassNotFoundException, IOException {
		date = new PriorityQueue<Bill>(new BillDateComparetor());
		amount = new PriorityQueue<Bill>(new BillAmountComparetor());
		billType = new PriorityQueue<Bill>(new BillTypeComparetor());
		this.list = listb;
		LinkedListIterator<Bill> iter = list.iterator();
		while (iter.hasNext()) {
			Bill bill = iter.next();
			date.enqueue(bill, new BillDateComparetor());
			amount.enqueue(bill, new BillAmountComparetor());
			billType.enqueue(bill, new BillTypeComparetor());

		}
	}

	public void insert(Bill bill) throws DuplicateDataException {
		date.enqueue(bill, new BillDateComparetor());
		amount.enqueue(bill, new BillAmountComparetor());
		billType.enqueue(bill, new BillTypeComparetor());
		list.insert(bill);
	}

	public void payNextBill(int id) throws Exception {
		
			LinkedListIterator<Bill> iter = list.iterator();
			while (iter.hasNext()) {
			Bill bill = iter.next();
			if (bill.getId() == id){
			list.remove(bill);
			date.remove(bill);
			amount.remove(bill);
			billType.remove(bill);
			}
		}

	}

	public void payNextBill(BillCriteria criteria) throws Exception {
		if (criteria.toString().equalsIgnoreCase("BILLDUEDATE")) {
			Bill getBill = date.dequeue();
			amount.remove(getBill);
			billType.remove(getBill);
			list.remove(getBill);
		} else if (criteria.toString().equalsIgnoreCase("BILLAMOUNT")) {
			Bill bill = amount.dequeue();
			date.remove(bill);
			billType.remove(bill);
			list.remove(bill);
		} else {
			Bill bill = billType.dequeue();
			amount.remove(bill);
			date.remove(bill);
			list.remove(bill);
		}
	}

	public double totalBills() {
		double total = 0.0;
		LinkedListIterator <Bill>iter = list.iterator();
		while (iter.hasNext()) {
			total += iter.next().getAmount();
		}
		return total;
	}

	public String toString() {
		StringBuilder info = new StringBuilder();
		LinkedListIterator<Bill> iter = list.iterator();
		while (iter.hasNext()) {
			Bill bill = iter.next();
			info.append(bill.toString());
			info.append("\n");
		}
		return info.toString();
	}

	public String toString(BillCriteria criteria) {
		StringBuilder info = new StringBuilder();
		if (criteria.toString().equalsIgnoreCase("BILLDUEDATE")) {
			LinkedListIterator<Bill> iter = date.getIteratior();
			while (iter.hasNext()) {
				Bill bill = (Bill) iter.next();
				info.append(bill);
				info.append("\n");

			}

		}

		else if (criteria.toString().equalsIgnoreCase("BILLAMOUNT")) {
			LinkedListIterator<Bill> iter = amount.getIteratior();
			while (iter.hasNext()) {
				Bill bill = (Bill) iter.next();
				info.append(bill);
				info.append("\n");

			}

		} else {
			LinkedListIterator<Bill> iter = billType.getIteratior();
			while (iter.hasNext()) {
				Bill bill = (Bill) iter.next();
				info.append(bill);
				info.append("\n");
			}
		}
		return info.toString();
	}

	public LinkedListIterator<Bill> iteratorByDate() {
		LinkedListIterator<Bill> iter = date.getIteratior();
		return iter;
	}

	public LinkedListIterator<Bill> iteratorByAmount() {
		LinkedListIterator<Bill> iter = amount.getIteratior();
		return iter;
	}

	public LinkedListIterator<Bill> iteratorByType() {
		LinkedListIterator<Bill> iter = billType.getIteratior();
		return iter;
	}

	public void closeOrganizer(String fileName) throws FileNotFoundException, IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
		output.writeObject(this.list);
		output.close();
	}

}
