package interfaces_16.exercises.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import interfaces_16.exercises.entities.Contract;
import interfaces_16.exercises.entities.Installment;
import interfaces_16.exercises.services.ContractService;
import interfaces_16.exercises.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter the contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		
		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();
		
		System.out.print("Number of installments: ");
		int parcels = sc.nextInt();
		
		Contract contract = new Contract(number, date, contractValue);
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, parcels);
		
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();

	}

}
