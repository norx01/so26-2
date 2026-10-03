package tipoHilo;

public class RaceCondition
{
    static int counter = 0;

    static void main() throws Exception
    {
        int thread = 8;
        int iters = 100_000;
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
