import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Deck {
    public static Random random= new Random();
   public static Card card=new Card();
    public static void main(String[] args) {
        card.iniciar();
        suffle();
        head();
        pick();
        hand();
    }

    public static void suffle(){
        Collections.shuffle(card.cards);
        System.out.println();
            System.out.println("¡Se mezcló el Deck!");
        System.out.println();
    }
    public static void head(){
        System.out.println(card.cards.get(0));
        card.cards.remove(0);
        System.out.println("Quedan "+ card.cards.size()+" cartas");
        System.out.println();System.out.println();
    }
    public static void pick(){
        int carta=random.nextInt(card.cards.size());
        System.out.println(card.cards.get(carta));
        card.cards.remove(carta);
        System.out.println("Quedan "+ card.cards.size()+" cartas");System.out.println();System.out.println();
    }
    public static void hand(){
        for(int i=0;i<5;i++){
            int carta=random.nextInt(card.cards.size());
            System.out.println(card.cards.get(carta));
            card.cards.remove(carta);
        }
        System.out.println("Quedan "+ card.cards.size()+" cartas");
    }
}
