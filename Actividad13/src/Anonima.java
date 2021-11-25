import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Anonima {
    static List<String> frase= Arrays.asList(new String[] {"Esperamos que pueda suceder cualquier cosa, y nunca estamos prevenidos para nada.",
            "Tener un hijo, plantar un árbol y escribir un libro es fácil. Lo difícil es criar un niño, regar el árbol y que alguien lea el libro.",
            "El pasado es como una lámpara colocada a la entrada del porvenir",
            "No busques personas con tus mismos gustos, busca personas con tus mismos valores.",
            "Cuando no sepas dónde ir, sigue el perfume de un sueño.",
            "Valor es lo que se necesita para levantarse y hablar, pero también es lo que se requiere para sentarse y escuchar.",
            "El día más desaprovechado de todos los días es aquel en que no nos hemos reído. ",
            "Si no sueltas el pasado, ¿con qué mano agarras el futuro?","La vida es una obra teatral que no importa cuánto haya durado, sino lo bien que haya sido representada."
            ,"Estar preparado es importante, saber esperar lo es aún más, pero aprovechar el momento adecuado es la clave de la vida. "});
  public static void main(String[] args) {

    sort1();
      sort2();
      sort3();
  }
  public static void sort1(){

      System.out.println("");
      System.out.println("Clase anónima");
      System.out.println("");

      // Clase anónima
      Function<List<String>, Set<String>> f1= new Function<List<String>, Set<String>>() {

          @Override
          public Set<String> apply(List<String> nameList) {

              return new HashSet<>(nameList);
          }
      };
      Set<String> set1 = f1.apply(frase);
      System.out.println(set1);

      System.out.println("");
      System.out.println("Lambda");
      System.out.println("");

      Function<List<String>,Set<String>> f2 = (frase) -> new HashSet<>(frase);
      Set<String> set2 = f2.apply(frase);
      System.out.println(set2);

      System.out.println("");
      System.out.println("Referencia");
      System.out.println("");

      frase.stream().forEach(
              System.out::println
      );

      frase.sort(Comparator.comparing(String::length));
  }
    public static void sort2(){




        frase.sort(Comparator.comparing((String frase) -> frase.length()));
        System.out.println("");
        System.out.println("Lambda longitud");
        System.out.println("");
        frase.forEach((frase)->System.out.println(frase));


        System.out.println("");
        System.out.println("Referencia longitud");
        System.out.println("");
        frase.forEach((frase)->System.out.println(frase));
    }
    public static void sort3(){



    }


}