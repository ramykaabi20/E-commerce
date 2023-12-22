package Models;

public class Order {
    private User User;
    private Product Product;
    private int Quantity;
    private double TotalPrice;
    private String Address;
    private String PhoneNumber;
    private String Email;
    private String PaymentMethod;
    private String ShippingMethod;

    public Order(User user, Product product, int quantity, double totalPrice, String address, String phoneNumber, String email, String paymentMethod, String shippingMethod) {
        User = user;
        Product = product;
        Quantity = quantity;
        TotalPrice = totalPrice;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
        PaymentMethod = paymentMethod;
        ShippingMethod = shippingMethod;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product product) {
        Product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public String getShippingMethod() {
        return ShippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        ShippingMethod = shippingMethod;
    }
    public void addProduct(Product product) {
        this.Product = product;
    }
    public void removeProduct(Product product) {
        this.Product = null;
    }
    public void showOrder() {
        System.out.println("User: " + User.getUserName());
        System.out.println("Product: " + Product.getName());
        System.out.println("Quantity: " + Quantity);
        System.out.println("Total Price: " + TotalPrice);
        System.out.println("Address: " + Address);
        System.out.println("Phone Number: " + PhoneNumber);
        System.out.println("Email: " + Email);
        System.out.println("Payment Method: " + PaymentMethod);
        System.out.println("Shipping Method: " + ShippingMethod);
    }





}
