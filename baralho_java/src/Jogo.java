

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * @author Nasser Rahman 101151428
 * @author Ricardo Burg Machado
 * @author Rafael Fernando dos Santos
 * @author Giovanni Garcia
 * @author Mateus Dal Forno
 * @author Bruno Segui
 * @author Isabel Boaventura
 * @author Rafhael Cunha
 */
public class Jogo {
    

    public int mj = 0;
    public int ma = 0;
    public int empate = 0;
    ArrayList<Carta> maoJogador = new ArrayList();
    ArrayList<Carta> maoAdversario = new ArrayList();
    Baralho baralho = new Baralho();

    public void distribuiCartas() {

        for (int i = 0; i < 5; i++) {

            maoJogador.add(baralho.daUmaCartaInicio());
            maoAdversario.add(baralho.daUmaCartaInicio());
        }
    }

    public void compararCartas() {


        for (int i = 0; i < maoJogador.size(); i++) {

            if (maoJogador.get(i).getValor().getNumero() > maoAdversario.get(i).getValor().getNumero()) {
                System.out.println("Jogador: " + maoJogador.get(i).toString());
                System.out.println("Adversario: " + maoAdversario.get(i).toString());
                System.out.println("Vencedor: Jogador");
                mj++;

            } else if (maoJogador.get(i).getValor().getNumero() < maoAdversario.get(i).getValor().getNumero()) {

                System.out.println("Jogador: " + maoJogador.get(i).toString());
                System.out.println("Adversario: " + maoAdversario.get(i).toString());
                System.out.println("Vencedor: Adversario");
                ma++;
            } else {
                System.out.println("Jogador: " + maoJogador.get(i).toString());
                System.out.println("Adversario: " + maoAdversario.get(i).toString());
                System.out.println("Empate");
                empate++;
            }
        }
    }

    public static void main(String args[]) {
        Jogo j = new Jogo();
        j.distribuiCartas();
        j.compararCartas();
        System.out.println("Resultado Final:");
        System.out.println("Jogador:" + j.mj);
        System.out.println("Adversario:" + j.ma);
        System.out.println("Empates:" + j.empate);

        System.out.println("Portanto, o vencedor Ã©:");

        if (j.mj > j.ma) {
            System.out.println("Jogador");
        } else if (j.mj < j.ma) {
            System.out.println("AdversÃ¡rio");
        } else {
            System.out.println("Deu empate");
        }

    }
}
