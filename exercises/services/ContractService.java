package interfaces_16.exercises.services;

import java.time.LocalDate;

import interfaces_16.exercises.entities.Contract;
import interfaces_16.exercises.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService paymentService;
	
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int months) {
		
		double amount = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = paymentService.interest(amount, i);
			double paymentFee = paymentService.paymentFee(amount + interest);
			double total = paymentFee + interest + amount;
			
			contract.getInstallments().add(new Installment(dueDate, total));
		}
	}
}
