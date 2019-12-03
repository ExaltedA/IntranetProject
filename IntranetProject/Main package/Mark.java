import java.util.*;
public class Mark {
	
	private double a1;
    private double a2;
    private double f;
	
    public Mark() {
    	a1 = 0;
    	a2 = 0;
    	f = 0;
    }
	
    public Mark(double a1, double a2, double f) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.f = f;
    }
	
	
	public double getTotal() {
		return a1 + a2 + f;
	}
	
	public double getA1() {
		return a1;
	}
	
	public double getA2() {
		return a2;
	}
	
	public double getFinal() {
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
	public double getGpa() {
		double a;
		if(getTotal() <= 100 ) {
			a=4.0;
		}
		else if(getTotal() < 95) {
			a=3.67;
		}
		else if(getTotal() < 90) {
			a=3.33;
		}
		else if(getTotal() < 85) {
			a=3.0;
		}
		else if(getTotal() < 80) {
			a=2.67;
		}
		else if(getTotal() < 75) {
			a=2.33;
		}
		else if(getTotal() < 70) {
			a=2.0;
		}
		else if(getTotal() < 65) {
			a=1.67;
		}
		else if(getTotal() < 60) {
			a=1.33;
		}
		else if(getTotal() < 55) {
			a = 1.0;
		}
		else {
			a=0;
		}
		return a;
		}
	
	public String getLet() {
		String letter;
		if (getTotal() <= 100 ) {
			letter = "A";
		}
		else if(getTotal() < 95) {
			letter = "A-";
		}
		else if(getTotal() < 90) {
			letter = "B+";
		}
		else if(getTotal() < 85) {
			letter = "B";
		}
		else if(getTotal() < 80) {
			letter = "B-";
		}
		else if(getTotal() < 75) {
			letter = "C+";
		}
		else if(getTotal() < 70) {
			letter = "C";
		}
		else if(getTotal() < 65) {
			letter = "C-";
		}
		else if(getTotal() < 60) {
			letter = "D+";
		}
		else if(getTotal() < 55) {
			letter = "D";
		}
		else {
			letter = "F";
		}
		return letter;
		}

	@Override
	public String toString() {
		return " [Attestation 1 =" + a1 + ", Attestation 2 =" + a2 + ", Final =" + f + "] Total = " + getTotal() + " " + getLet()  ;
	}
	
}
