package models.services;

public class PaypalService implements OnlinePaymentService {

    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;
    
    @Override
    public double paymentFee(Double amount) {
        return amount * FEE_PERCENTAGE;
    }

    public double interest(double amount, int months) {
        // J = C * i * t
        return amount * MONTHLY_INTEREST * months;
    }
}
