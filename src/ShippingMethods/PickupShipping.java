package ShippingMethods;

import Interface.ShippingStrategy;

public class PickupShipping implements ShippingStrategy {
    @Override
    public void ship() {
        System.out.println("You can visit our store to pick up your order. In the meantime, we will prepare your order.\n Thank You!");
    }
}
