import java.util.ArrayList;
import java.util.List;

class Card {
    public static List<String> cards = new ArrayList<String>();
   public static String[] cardsType ={"trebol","pica","corazon","diamante"};
   public static String [] cardValue = {"A","2","3","4","5","6","7","8","9","10","J", "Q", "K" };
    public static String [] cardColor = {"Negro","Rojo"};
    public void iniciar() {
        for(int i=0;i<=(cardsType.length)-1;i++){
            for(int j=0;j<=(cardValue.length)-1;j++){
                if(cardsType[i]== cardsType[0]|| cardsType[i]== cardsType[1]){
                    cards.add(cardsType[i] + ", " +cardColor[0]+", "+ cardValue[j]) ;
                }
                else{
                    cards.add(cardsType[i] + ", " +cardColor[1]+", "+ cardValue[j]) ;
                }

            }
        }
        //for (int i = 0 ; i < cards.size() ; i++) {
          //  System.out.println(cards.get(i));
       // }
    }

}
