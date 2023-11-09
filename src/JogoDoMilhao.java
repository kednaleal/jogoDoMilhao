import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class JogoDoMilhao {
    private List<Pergunta> perguntas;
    private int pontuacao;
    private Semaphore semaforo;

    public JogoDoMilhao(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
        this.pontuacao = 0;
        this.semaforo = new Semaphore(1);
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.getPergunta());
            String[] opcoes = pergunta.getOpcoes();
            for (int i = 0; i < opcoes.length; i++) {
                System.out.println((i + 1) + ". " + opcoes[i]);
            }

            System.out.print("Escolha a opção correta: ");
            int respostaUsuario = scanner.nextInt();

            try {
                semaforo.acquire();
                if (respostaUsuario == pergunta.getRespostaCorreta()) {
                    System.out.println("Resposta correta! Você ganhou 1 milhão de dólares.");
                    pontuacao += 1;
                } else {
                    System.out.println("Resposta incorreta! Fim de jogo.");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforo.release();
            }
        }

        System.out.println("Pontuação total: $" + pontuacao + " milhões.");
        scanner.close();
    }
}
