package model.exception;

public class NoEnoughCredit extends WrongBuy{
    @Override
    public String massage(){
        return super.massage()+"\nNo Enough Credit!";
    }
}
