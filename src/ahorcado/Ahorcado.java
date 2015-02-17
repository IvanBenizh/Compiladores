/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ahorcado;//Nombre Paquete
import javax.swing.JOptionPane;

public class Ahorcado{
    
    public static void main (String args[]){
        //Variable donde se guardaran las palabra que tendran que adivinar
        String [] palabra = {"italia","alemania","reinounido","rusia","china","japon","mexico","españa","brasil","colombia","india"};
        
        //Variable para generar palabra aleatoria
        int aleatorio;
        aleatorio = (int)(Math.random()*10);
        
        String respuesta;
        String ingresadas = "";
        
        //Arreglo  para revisar que la letra que introdujo esta dentro de la palabra
        char [] prueba = new char [palabra[aleatorio].length ()];
        
        //Arreglo para ir dibujando el personaje ahorcado
        String [] soga  = new String [8];
        
        soga[7] ="-|";
        soga[6] ="-|\n 6";
        soga[5] ="-|\n 0";
        soga[4] ="-|\n 0\n |";
        soga[3] ="-|\n 0\n/|";
        soga[2] ="-|\n 0\n/|\\";
        soga[1] ="-|\n 0\n/|\\\n/^";
        soga[0] ="-|\n 0\n/|\\\n/^\\\n";
        
        //Ciclo para que adivine o se acaben los aciertos
        for(int i=0;i < palabra[aleatorio].length();i++){
            prueba[i] = '_';    
        }//fin de for
        
        int cont = 8;   //Oportunidades de error
        int cont2 = 0;  //Numero de intentos
        int salir = 0;
        
        //Instrucciones
        System.out.println("Bienvenido al juego del Ahorcado");
        System.out.println("Tiene 8 intentos para adivinar la palabra");
        System.out.println("Las palabras estan relaciondas con PAISESi");
        System.out.println("USA SOLO LETRAS MINUSCULAS");
        
        //Mostrar palabra con lineas _ _ _ _ ...
        for(int i=0;i < palabra[aleatorio].length();i++){
            System.out.print(prueba[i]+ " ");
        }//fin de for
        
        //Espacio entre la palabra y el ingreso de letras
        System.out.println("\n\n\n");
        
        //Ciclo que inicia el juego y termina si se agotan los intentos o gana
        while (cont > 0){
            //ingresa letra y se guarda en variable respuesta
            respuesta = JOptionPane.showInputDialog(null,"Ingresa una letra (letras minusculas)");
            ingresadas = ingresadas + respuesta.charAt(0); //Conocer letras 
            
            System.out.println("Letra ingresada: " + ingresadas + "\n");
            
            //Ciclo para comparar letras
            for(int q = 0;q < palabra[aleatorio].length();q++){
                //letra de entrada debe ser identica a letra de la palabra
                if(respuesta.charAt(0) == palabra[aleatorio].charAt(q)){
                    prueba[q] = palabra[aleatorio].charAt(q);
                    cont2++;
                }//fin de if
            }//fin ciclo for
            
            System.out.println("");
            
            //Letra incorrecta
            if (cont2 < 1){
                cont--;
                System.out.println("");
                System.out.println("Esa letra no existe en la palabra, Intenta de nuevo porfavor");
                System.out.println("");
                System.out.println("Le quedan " + cont + " intentos");
                System.out.println("");
                System.out.println(soga[cont]);
                cont2=0;
            }//fin de if
            
            //Letra correcta
            else{
                System.out.println("La letra existe");
                System.out.println("Porfavor Ingrese una nueva letra");
                cont2=0;
            }//fin de else
            
            //
            for(int s= 0;s < palabra[aleatorio].length();s++){
                System.out.print(prueba[s] + " ");
            }//fin de cilo for
            
            for(int d= 0;d < palabra[aleatorio].length();d++){
                if(palabra[aleatorio].charAt(d) == prueba[d]){
                    salir ++;
                }//fin de if
                
                else{
                     salir = 0;
                }// fin de else
                
                //Terminar programa
                if (salir == palabra[aleatorio].length()){
                    System.out.println("");
                    System.out.println("********************************************************************************");
                    System.out.println("Haz Ganado , FELICIDADES ERES UN CAMPEON !!!");
                    System.out.println("********************************************************************************");
                    System.out.println("FIN DEL JUEGO");
                    cont=0;
                }//fin de if
                cont2=0;
            }//fin de cilo for
        } //fin de ciclo while
        
        if(salir < palabra[aleatorio].length()){
            System.out.println("");
            System.out.println("***************************************************************************");
            System.out.println("");
            System.out.println("Haz sido AHORCADO");
            System.out.println("FIN DEL JUEGO");
        }//fin de if
    }//fin de main
}//fin de la clase Ahorcado