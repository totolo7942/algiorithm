package example;

public class tryCatchExceptionExample {

    public static void main(String[] args) throws Exception {
        try{
            new ExceptionClass().business();
        }catch( Exception e) {
            throw new Exception("throw new Exception");
        }finally {
            System.out.println("#### -- finally process ");
        }
    }



}

class ExceptionClass {
    public void business() throws Exception{
        throw new Exception("## Exception business");
    }
}