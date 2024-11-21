package interfaces_16.application;

import java.util.Locale;

import interfaces_16.entities.AbstractShape;
import interfaces_16.entities.Circle;
import interfaces_16.entities.Rectangle;
import interfaces_16.enums.Color;

public class Program2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		AbstractShape s1 = new Circle(Color.BLACK, 2.0);
		AbstractShape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);
		
		System.out.println("Circle color: " + s1.getColor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println();
		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));

	}

}
