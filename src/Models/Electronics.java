package Models;

import Enums.Categories;

public class Electronics extends Product{

    public Electronics(int ID,String name, double price, int quantity){
        super(ID,name, price, quantity, Categories.valueOf("ELECTRONICS"));

    }
}
