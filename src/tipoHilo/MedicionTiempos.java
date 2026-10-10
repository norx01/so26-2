package tipoHilo;

public class MedicionTiempos
{
    static void main() throws InterruptedException
    {
        AtomicCounter ac = new AtomicCounter();
        RaceCondition rc = new RaceCondition();
        SyncCounter sc = new SyncCounter();

        int thread = 8;
        int iters = 100_000;

        //Condicion de Carrera
        long inicio = System.nanoTime();
        rc.runTest(thread,iters);
        long fin = System.nanoTime();
        System.out.println("Condicion de carrera: "+(fin-inicio)/1_000_000+" ms");

        //Contador Atomico
        inicio = System.nanoTime();
        ac.runTest(thread,iters);
        fin = System.nanoTime();
        System.out.println("Contador atomico: "+(fin-inicio)/1_000_000+" ms");

        //Contador sincronizado
        inicio = System.nanoTime();
        sc.runTest(thread,iters);
        fin = System.nanoTime();
        System.out.println("Contador sincronizado: "+(fin-inicio)/1_000_000+" ms");
    }
}
