package interfaces_16.exercises.services;

public interface OnlinePaymentService {

	double paymentFee(double amount);
	
	double interest(double amount, int months);
}
