import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Deck {
    public static Scanner reader = new Scanner(System.in);
    public static Random random= new Random();
   public static Card card=new Card();
    public static void main(String[] args) {
        card.iniciar();
            showMenu();
    }
    public static void showMenu(){
        int opcion=0;
        boolean d=true;
        do{

            try {

            System.out.println("Bienvenido a Poker!");
            System.out.println("Selecciona una opción:");
            System.out.println("1 Mezclar deck:");
            System.out.println("2 Sacar una carta");
            System.out.println("3 Carta al azar");
            System.out.println("4 Generar una mano de 5 cartas");
            System.out.println("0 Salir");
            opcion = reader.nextInt();

            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    suffle();
                    break;
                case 2:
                    head();
                    break;
                case 3:
                    pick();
                    break;
                case 4:
                    hand();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            } catch (InputMismatchException ex) {
                System.out.println("Opción no válida");
                reader.next();
            }
        }
        while(d==true);

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
        int cantidad=card.cards.size();
        if(cantidad==0){
            System.out.println("Se han agotado las cartas");
            System.exit(0);
        }else {
            System.out.println("Quedan " + card.cards.size() + " cartas");
            System.out.println();

        }
    }
    public static void pick(){
        int carta=random.nextInt(card.cards.size());
        System.out.println(card.cards.get(carta));
        card.cards.remove(carta);
        int cantidad=card.cards.size();
        if(cantidad==0){
            System.out.println("Se han agotado las cartas");
            System.exit(0);
        }else {
            System.out.println("Quedan " + card.cards.size() + " cartas");
            System.out.println();

        }
    }
    public static void hand(){
        for(int i=0;i<5;i++){
            int carta=random.nextInt(card.cards.size());
            System.out.println(card.cards.get(carta));
            card.cards.remove(carta);
            int cantidad=card.cards.size();
            if(cantidad==0){
                System.out.println("Se han agotado las cartas");
                System.exit(0);
            }
        }
        System.out.println("Quedan "+ card.cards.size()+" cartas");
    }

}
