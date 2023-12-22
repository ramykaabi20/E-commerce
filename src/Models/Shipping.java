package Models;

import Interface.ShippingStrategy;

public class Shipping {
    private ShippingStrategy shippingStrategy;
    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }
    public void ship() {
        shippingStrategy.ship();
    }
}
