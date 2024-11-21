package interfaces_16.exercises.services;

public class PaypalService implements OnlinePaymentService {
	
	@Override
	public double interest(double amount, int months) {
		return amount * 0.01 * months;
	}

	@Override
	public double paymentFee(double amount) {
		return amount * 0.02;
	}

}
