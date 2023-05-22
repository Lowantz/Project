package model.exception;

public class WrongPhone extends WrongInput{
    @Override
    public String massage(){
        return super.massage()+"\nWrong Phone!";
    }


}
