package by.it.group351001.ovchinnickov.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить рекурсивный способ вычисления чисел Фибоначчи
 */
public class FiboA {


    private long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        FiboA fibo = new FiboA();
        int n = 33;
        System.out.printf("calc(%d)=%d \n\t time=%d \n\n", n, fibo.calc(n), fibo.time());

        //вычисление чисел фибоначчи медленным методом (рекурсией)
        fibo = new FiboA();
        n = 34;
        System.out.printf("slowA(%d)=%d \n\t time=%d \n\n", n, fibo.slowA(n), fibo.time());
    }

    private long time() {
        long res = System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        return res;
    }

    private int calc(int n) {
        int fib1=0;
        int fib2=1;
        int result=0;
        for(int i=0; i<n-2; i++){
            result=fib1+fib2;
            fib1=fib2;
            fib2=result;
        }
        return result;
    }


    BigInteger slowA(Integer n) {
        if (n == 0){
            return BigInteger.valueOf(0);
        }
        if (n == 1){
            return BigInteger.valueOf(1);
        }
        else{
            return slowA(n - 1).add(slowA(n - 2));
        }
    }


}

