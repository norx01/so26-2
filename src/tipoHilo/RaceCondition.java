package tipoHilo;

public class RaceCondition
{
    static int counter = 0;

    public void runTest(int thread, int iters) throws InterruptedException
    {
        Thread[] threads = new Thread[thread];
        for (int i = 0; i < thread; i++)
        {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < iters; j++)
                {
                    counter++;
                }
            });
            threads[i].start();
        }
        for (Thread t : threads)
            t.join();
        System.out.println("esperado = "+(thread * iters)+ " | obtenido = "+counter);
    }
}
