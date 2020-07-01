public class Calculator {
    private int current=0;

    public int get(String x){
        int first = 0;
        int second = 0;
        char action = 0;

        for( int i=0;i<x.length();i++){
            if (!Character.isDigit(x.charAt(i))){
                action = x.charAt(i);
                first = Integer.parseInt(x.substring(0,i));
                second = Integer.parseInt(x.substring(i+1));
            }
        }
        if (action=='+') current = add(first,second);
        if (action=='-') current = minus(first,second);
        if (action=='*') current = multiply(first,second);
        if (action=='/') current = divide(first,second);
        return current;
    }

    public int clear(){
        current=0;
        return current;
    }

    private int add(int x, int y){
        return x+y;
    }

    private int minus(int x,int y){
        return x-y;
    }

    private int multiply(int x,int y){
        return x*y;
    }

    private int divide(int x, int y){
        if (y == 0) return 0;
        else return x/y;
    }
}
