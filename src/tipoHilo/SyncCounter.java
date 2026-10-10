package tipoHilo;

public class SyncCounter
{
    static int counter = 0;
    static final Object lock = new Object();

    static void inc()
    {
        synchronized (lock)
        {
            counter++;
        }
    }

    public void runTest(int thread, int iters) throws InterruptedException
    {
        Thread[] arr = new Thread[thread];
        for (int i = 0; i < thread; i++)
        {
            arr[i] = new Thread(() -> {
                for (int j = 0; j < iters; j++)
                {
                    inc();
                }
            });
            arr[i].start();
        }
        for (Thread t : arr)
            t.join();
        System.out.println("esperado = "+(thread * iters)+ " | obtenido = "+counter);
    }

}
