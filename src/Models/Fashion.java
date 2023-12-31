package Models;

import Enums.Categories;

public class Fashion extends Product{

    public Fashion(int ID,String name, double price, int quantity) {
        super(ID,name, price, quantity, Categories.valueOf("FASHION"));
    }
}
