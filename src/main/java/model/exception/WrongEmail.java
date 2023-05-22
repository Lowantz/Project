package model.exception;

public class WrongEmail extends WrongInput{
    @Override
    public String massage(){
        return super.massage()+"\nWrong Email!";
    }
}
