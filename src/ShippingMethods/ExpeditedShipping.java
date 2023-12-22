package ShippingMethods;

import Interface.ShippingStrategy;

public class ExpeditedShipping implements ShippingStrategy {
    @Override
    public void ship() {
        System.out.println("Your order will be shipped via FedEx. Thank You!");
    }
}
