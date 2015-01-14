package billOrganizer;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Bill implements Serializable, Comparable<Bill> {

	private static int counter;
	private Integer id;
	private String name;
	private Double amount;
	private Date date;
	private BillType billType;

	public Bill(String name, Double amount, String date, BillType billType) throws ParseException {
		counter++;
		this.id = counter;
		this.name = name;
		this.amount = amount;
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		this.date = formatter.parse(date);
		this.billType = billType;

	}

	// assuming there is 1 bill on each line of the file
	public Bill(Scanner input) throws ParseException {
		String data = input.nextLine();
		String[] bill = data.split(" ");
		counter++;
		this.id = counter;
		this.name = bill[0];
		this.amount = Double.parseDouble(bill[1]);
		// GregorianCalendar a = new GregorianCalendar(bill[2]);
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		this.date = formatter.parse(bill[2]);
		this.billType = BillType.valueOf(bill[3]);

	}

	public Bill(Bill next) {
		Bill bill = next;
	}

	public int compareTo(Bill other) {
		return this.id.compareTo(other.id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType billType) {
		this.billType = billType;
	}

	public String toString() {
		DecimalFormat format = new DecimalFormat("$#.##");
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		StringBuilder info = new StringBuilder();
		info.append(id + " " + name + " " + format.format(amount) + " " + formatter.format(date) + " " + " " + billType);
		return info.toString();
	}

}
