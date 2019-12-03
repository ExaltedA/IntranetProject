import java.util.*;
public class Mark {
	
	private double a1;
    private double a2;
    private double f;
	
    public Mark() {}
	
    public Mark(double a1, double a2, double f) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.f = f;
    }
	
	
	public double total(double a1, double a2, double f) {
		return a1 + a2 + f;
	}
	
	public double getA1() {
		return a1;
	}
	
	public double getA2() {
		return a2;
	}
	
	public double getFineal() {
		return f;
	}
	
	public void setA1(double a1) {
		this.a1 = a1;
	}
	
	public void setA2(double a2) {
		this.a2 = a2;
	}
	
	public void setF(double f) {
		this.f = f;
	}
	
	public static String let(int grade) {
		String letter;
		if(grade <= 100 ) {
			letter = "A";
		}
		else if(grade < 95) {
			letter = "A-";
		}
		else if(grade < 90) {
			letter = "B+";
		}
		else if(grade < 85) {
			letter = "B";
		}
		else if(grade < 80) {
			letter = "B-";
		}
		else if(grade < 75) {
			letter = "C+";
		}
		else if(grade < 70) {
			letter = "C";
		}
		else if(grade < 65) {
			letter = "C-";
		}
		else if(grade < 60) {
			letter = "D+";
		}
		else if(grade < 55) {
			letter = "D";
		}
		else {
			letter = "F";
		}
		return letter;
		}
	
}
