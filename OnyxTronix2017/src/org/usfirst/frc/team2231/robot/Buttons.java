package org.usfirst.frc.team2231.robot;

public class Buttons {
	public enum Button {
		A(1), 
		B(2),
		X(3),
		Y(4),
		LB(5),
		RB(6),
		Back(7),
		Start(8),
		LeftAxis(9),
		RightAxis(10),
		LT(11),
		RT(12);
		
		private final int value;
	    Button(int value) {
	        this.value = value;
	    }
	    public int value() { return value; }
	}
	 
}
