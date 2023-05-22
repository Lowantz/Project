package model.exception;

public class NoAvailableProduct extends WrongBuy {
    @Override
    public String massage(){
        return super.massage()+"\nNo Available Product!";
    }
}
