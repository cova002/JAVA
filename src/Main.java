public class Main {
    public static int tamaño=50;
    public static int[] matriz_fibonacci= new  int[100];
    public static int[] matriz_primos= new  int[100];


    public static void main(String[] args) {
    primos();
    fibonacci();
    }

    public static void primos(){
        int num = 0, cont=0, cont2=0;
        boolean primo=true;
        while (cont2<tamaño)
        {
            primo=true;
            cont = 0;

            if (num == 0 || num == 4) {
                primo=false;
            }
            for (int i = 2; i < num / 2; i++) {

                if (num % i == 0){
                    primo=false;
                }
            }
            if (primo == true)
            {
                matriz_primos[cont2]=num;
                cont2++;
            }
            num++;

        }
        System.out.println("Números primos:");

        for(int i=1;i<cont2;i++){
           System.out.print(matriz_primos[i]+", ");
        }
        System.out.println();
    }
    public static void fibonacci(){

        int num1 = 0, num2 = 1, suma = 1;


        for (int i = 1; i < tamaño; i++) {
            matriz_fibonacci[i]=suma;
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
        }
        System.out.println("Sucesión de Fibonacci:");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(matriz_fibonacci[i]+", ");
        }
        System.out.println();
    }
}