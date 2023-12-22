package Models;
import Interface.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy PaymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        PaymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        PaymentStrategy.pay(amount);
    }
}
