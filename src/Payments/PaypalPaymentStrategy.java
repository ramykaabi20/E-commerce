package Payments;
import Interface.PaymentStrategy;
public class PaypalPaymentStrategy implements PaymentStrategy{
    private String Email;
    private String Password;
    public PaypalPaymentStrategy(String email, String password) {
        Email = email;
        Password = password;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Paypal");
    }
}
