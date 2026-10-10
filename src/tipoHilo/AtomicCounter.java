package tipoHilo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter
{
    static AtomicInteger counter = new AtomicInteger(0);

    public void runTest(int thread, int iters) throws InterruptedException
    {

        Thread[] arr = new Thread[thread];
        for (int i = 0; i < thread; i++)
        {
            arr[i] = new Thread(() -> {
                for (int j = 0; j < iters; j++)
                {
                    counter.incrementAndGet();
                }
            });
            arr[i].start();
        }
        for (Thread t : arr)
            t.join();
        System.out.println("esperado = "+(thread * iters)+ " | obtenido = "+counter.get());

    }
}
