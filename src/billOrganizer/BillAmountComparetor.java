package billOrganizer;

import java.util.Comparator;

public class BillAmountComparetor implements Comparator<Bill> {

	@Override
	public int compare(Bill bill1, Bill bill2) {
		return bill1.getAmount().compareTo(bill2.getAmount());
	}

}
