public class Hilo
{
    static void main() throws Exception
    {
        //Creamos un hilo y lo iniciamos
        Thread hilo = new Thread(() -> {
        for (int i = 0; i < 5; i++)
        {
            //Imprimimos el nombre del hilo actual
            System.out.println("Hola desde el hilo" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }, "Trabajador-1");
        hilo.start();
        System.out.println("Hola desde el hilo principal");
        hilo.join();
    }
}
