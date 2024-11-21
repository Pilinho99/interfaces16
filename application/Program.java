package interfaces_16.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import interfaces_16.entities.CarRental;
import interfaces_16.entities.Vehicle;
import interfaces_16.services.BrazilTaxService;
import interfaces_16.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		try {
		
			System.out.println("Enter rent data:");
			System.out.print("Car model: ");
			String carModel = sc.nextLine();
			System.out.print("Start date (dd/MM/yyyy HH:mm): ");
			LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
			System.out.print("End date (dd/MM/yyyy HH:mm): ");
			LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
			
			CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
			
			System.out.print("Enter price per hour: ");
			double pricePerHour = sc.nextDouble();
			
			System.out.print("Enter price per day: ");
			double pricePerDay = sc.nextDouble();
			
			RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
			
			rentalService.processInvoice(cr);
			
			System.out.println("PAYMENT:");
			System.out.println("Basic payment: $ " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
			System.out.println("Tax: $ " + String.format("%.2f", cr.getInvoice().getTax()));
			System.out.println("Total payment: $ " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		} catch (DateTimeParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
