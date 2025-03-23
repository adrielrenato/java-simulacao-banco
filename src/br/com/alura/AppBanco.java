package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {
    public static void main(String[] args) {
        var cliente = new Cliente("João");
        var conta = new Conta(cliente, new BigDecimal("150"));
        var operacao = new OperacaoSaque(conta, new BigDecimal("150"));

//        Thread saqueJoao = new Thread(operacao);
//        Thread saqueMaria = new Thread(operacao);

        Thread saqueJoao = Thread.startVirtualThread(operacao);
        Thread saqueMaria = Thread.startVirtualThread(operacao);

        saqueJoao.start();
        saqueMaria.start();

        try {
            saqueJoao.join();
            saqueMaria.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(Thread.currentThread().getName());
        System.out.println("Saldo do final o dia: " + conta.getSaldo());

        // Saque João
//        operacao.executa();
        // Saque Maria
//        operacao.executa();
    }
}
