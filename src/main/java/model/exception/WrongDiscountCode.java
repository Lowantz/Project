package model.exception;

public class WrongDiscountCode extends Exception {
    public String massage(){
        return "Wrong Discount Code!";
    }
}
