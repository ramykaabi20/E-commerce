package Models;

public class Review {
    private User User;
    private Product Product;
    private String Comment;
    private int Rating;
    public Review(User user, Product product, String comment, int rating) {
        User = user;
        Product = product;
        Comment = comment;
        Rating = rating;
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
    public String getComment() {
        return Comment;
    }
    public void setComment(String comment) {
        Comment = comment;
    }
    public int getRating() {
        return Rating;
    }
    public void setRating(int rating) {
        Rating = rating;
    }

}
