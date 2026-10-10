package productorConsumidor;

public class Productor extends Thread
{
    private final Buffer buffer;

    public Productor(Buffer buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        int valor = 1;
        try
        {
            while (true)
            {
                buffer.producir(valor++);
                //Se simula el tiempo de produccion
                Thread.sleep(4000);
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
