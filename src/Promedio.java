import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        double[] calificaciones = new double[6];
        System.out.println("Ingresa tu nombre: ");
        nombre = sc.nextLine();
        double suma=0;
        for(int i=1;i<6;i++){
            System.out.println("Ingresa tu calificacion "+i+": ");
            calificaciones[i] = sc.nextDouble();
            suma= suma + calificaciones[i];
        }
        String cali = "";
        double promedio=suma/5;
        if(promedio <= 50){
            cali="F";
        }
        else{
            if(promedio > 50 && promedio <=60){
                cali="E";
            }
            else {
                if(promedio > 60 && promedio <=70){
                    cali="D";
                }
                else{
                    if(promedio > 70 && promedio <=80){
                        cali="C";
                    }
                    else{
                        if(promedio > 80 && promedio <=90){
                            cali="B";
                        }
                        else{
                            if(promedio > 90 && promedio <=100){
                                cali="A";
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Nombre del estudiante: "+nombre);
        for(int i=1;i<6;i++){
            System.out.println("Calificación "+i+": "+calificaciones[i]);
        }
        System.out.println("Promedio: "+promedio);
        System.out.println("Calificación: "+cali);
    }


}
