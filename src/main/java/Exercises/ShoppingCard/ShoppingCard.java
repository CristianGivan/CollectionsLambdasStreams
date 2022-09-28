package Exercises.ShoppingCard;

import java.util.Map;

public class ShoppingCard {
    Map<Product,Integer> numberOfProductsOfTheSameType;
    public ShoppingCard(Map<Product,Integer> numberOfProductsOfTheSameType){
        this.numberOfProductsOfTheSameType=numberOfProductsOfTheSameType;
    }

    public void setNumberOfProductsOfTheSameType(Map<Product,Integer> numberOfProductsOfTheSameType){
        this.numberOfProductsOfTheSameType=numberOfProductsOfTheSameType;
    }
    public Map<Product,Integer> getNumberOfProductsOfTheSameType(){
        return this.numberOfProductsOfTheSameType;
    }

}
