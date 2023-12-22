package Payments;

import Interface.PaymentStrategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String Name;
    private String CardNumber;
    private String CVV;
    private String DateOfExpiry;

    public CreditCardPaymentStrategy(String name, String cardNumber, String CVV, String dateOfExpiry) {
        this.Name = name;
        this.CardNumber = cardNumber;
        this.CVV = CVV;
        this.DateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}
