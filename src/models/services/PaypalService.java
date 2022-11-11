package models.services;

public class PaypalService implements OnlinePaymentService {

    private static final double FEE_PERCENTAGE = 0.02;          // taxa de pagamento
    private static final double MONTHLY_INTEREST = 0.01;        // taxa de juros mensal
    
    @Override
    public double paymentFee(double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double interest(double amount, int months) {
        // J = C * i * t
        return amount * MONTHLY_INTEREST * months;
    }
}
