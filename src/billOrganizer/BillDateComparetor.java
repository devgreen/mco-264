package billOrganizer;

import java.util.Comparator;

public class BillDateComparetor implements Comparator<Bill> {

	@Override
	public int compare(Bill bill1, Bill bill2) {
		return bill1.getDate().compareTo(bill2.getDate());
	}

}
