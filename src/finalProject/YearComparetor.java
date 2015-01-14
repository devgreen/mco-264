package finalProject;

import java.io.Serializable;
import java.util.Comparator;

public class YearComparetor implements Serializable, Comparator<CompletedCourse> {

	@Override
	public int compare(CompletedCourse a, CompletedCourse b) {
		return a.getYearCompleted().compareTo(b.getYearCompleted());
	}

}
