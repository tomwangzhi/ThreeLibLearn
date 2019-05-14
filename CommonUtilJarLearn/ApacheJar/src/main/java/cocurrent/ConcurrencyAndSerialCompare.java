package cocurrent;

/**
 * 1.一个方法并发执行  2. 一个是串行执行   结论：并不是并发执行就一定更快，当element足够大时才会运行更快
 */
public class ConcurrencyAndSerialCompare {

    private static int element = 10000000;


    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    public static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int total = 0;
                for (int i = 0; i < element; i++) {
                    total += 5;
                }
            }
        });
        thread.start();
        int total = 0;
        for (int i = 0; i < element; i++) {
            total -= 5;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :"+time+"ms,total="+total);
        thread.join();
    }

    public static void serial() {
        long start = System.currentTimeMillis();
        int total1 = 0;
        for (int i = 0; i < element; i++) {
            total1 += 5;
        }

        int total2 = 0;
        for (int i = 0; i < element; i++) {
            total2 -= 5;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :"+time+"ms,total2="+total2+",total1="+total1);

    }

}
