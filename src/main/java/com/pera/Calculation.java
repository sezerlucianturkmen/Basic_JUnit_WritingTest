package com.pera;

public class Calculation {

    public int sum(int s1,int s2){
        return s1+s2;
    }

    public double divide(double s1, double s2) throws Exception {
        if(s2 == 0){
            throw new Exception("Don't do this");
        }else {
            return s1/s2;
        }
    }

    public int divide2(int s1,int s2){
        return s1/s2;
    }

    public int multiply(int... numberList){
        int result=1;
        for(int number: numberList)
            result *= number;
        return result;
    }

}
