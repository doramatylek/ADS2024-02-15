package by.it.group310901.yakovtsov;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * Время расчета должно быть не более 2 секунд
 */

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //Решение сложно найти интуитивно
        //возможно потребуется дополнительный поиск информации
        //см. период Пизано

        long prev = 0;
        long curr = 1;
        long temp;
        long pizanoPeriod = 0;

        for(int i = 0; i < m * m; i++)
        {
            temp = curr;
            curr = (prev + curr) % m;
            prev = temp;

            if (prev == 0 && curr == 1)
                pizanoPeriod = i + 1;
        }

        n = n % pizanoPeriod;

        if (n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else

        prev = 0;
        curr = 1;
        for(int i = 0; i < n - 1; i++)
        {

            temp = curr;
            curr = (prev + curr) % m;
            prev = temp;
        }
        return curr % m;
    }
}

