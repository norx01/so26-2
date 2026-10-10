package productorConsumidor;

public class Consumidor extends Thread
{
    private final Buffer buffer;

    public Consumidor(Buffer buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                buffer.consumir();
                //Se simula el tiempo de consumo
                Thread.sleep(5000);
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
