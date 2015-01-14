package finalProject;

public enum Grade {

	A(4), B(3), C(2), D(1), F(0);

	private int numGrade;

	private Grade(int numGrade) {
		this.numGrade = numGrade;

	}

	public int getNumGrade() {
		return numGrade;
	}

}
