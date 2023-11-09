import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class App {
    public static void main(String[] args) {
        // Criar perguntas
        List<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("Qual é a capital do Brasil?", new String[]{"Rio de Janeiro", "Brasília", "São Paulo", "Belo Horizonte"}, 2));
        perguntas.add(new Pergunta("Quem escreveu 'Dom Quixote'?", new String[]{"Miguel de Cervantes", "William Shakespeare", "Jane Austen", "Leo Tolstoy"}, 1));
        // Adicione mais perguntas conforme necessário

        // Criar instância do jogo
        JogoDoMilhao jogo = new JogoDoMilhao(perguntas);

        // Iniciar o jogo
        jogo.jogar();
    }
}
