package br.com.alura.desafio2;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        var impressora1 = new Impressora(1);
        var impressora2 = new Impressora(2);

        var thread1 = new Thread(impressora1);
        var thread2 = new Thread(impressora2);

//        thread1.start();
//        thread2.start();

//        thread1.setPriority(1);
//        thread2.setPriority(10);

        thread1.setPriority(1);
        thread2.setPriority(10);

        thread1.start();
        thread2.start();

        var tarefa = new RealizaTarefa();
        var thread3 = new Thread(tarefa);
        System.out.println(thread3.isAlive());
        thread3.start();
        thread3.join();
        System.out.println(thread3.isAlive());
    }
}
