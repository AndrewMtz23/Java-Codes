import java.util.*;

public class buscaminas{
	public static void main(String[] args){
		
		Scanner leer = new Scanner (System.in);
		int tablero [][]= new int[20][20];
		
		double w=0; double z=0;
		int ntminas=0; int intento=75; int tminas=10;
		
		for(int j=0;j<20;j++)
			for (int i=0;i<20;i++)
				tablero [j][i]=0;
		
		        do  {  
     			    w=Math.random()*20;
        		    z=Math.random()*20;  
           		    w=(int)w;
           		    z=(int)z;
           		    if  (z!=0 && w!=0 && z!=20-1 && w!=20-1){
             	    tablero[(int)w][(int) z ]=1;
              	    ntminas++;
           			}

       		    }while (ntminas<=10);
      
       	System.out.println("  Bienvenido al Buscaminas ");
        System.out.println("  Ingresa las Coordenas en el Rango del 1 al 20");
       	do {
       		int x=0,y=0; int nminas = 0;
       		
       		do{
       			 System.out.println("\n	Intento :"+intento+" , Cual es su coordenada? \n");
       			 System.out.print("Fila:  ");
       			 x=leer.nextInt();
       			 System.out.println();
       			 System.out.print("Columna:  ");
       			 y=leer.nextInt();
       			 
       			 if(x==0 || y==0 || x>20 || y>20)
       			 	System.out.println("\n	==>Coordenadas incorrectas<== \n");
       		}while (x==0 || y==0 || x>20 || y>20);
       		
       		x=x-1;
       		y=y-1;
       		
       		if(tablero[x][y] == 0) {
                if (x == 0 && y == 0) {
                    for (int i = x; i <= x + 1; i++) {
                        for (int j = y; j <= y + 1; j++) {
                            if (i != x || j != y) {
                                if (i >= 0 && i < 20 && j >= 0 && j < 20) {
                                    nminas += tablero[i][j];
                                }
                            }
                        }
                    }
                } else {
                    for (int i = x - 1; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            if (i != x || j != y) {
                                if (i >= 0 && i < 20 && j >= 0 && j < 20) {
                                    nminas += tablero[i][j];
                                }
                            }
                        }
                    }
                }
                System.out.print("\n	Mina no Encontrada. ");
            
                if (intento > tminas) {
                    System.out.print("	Alrededor hay: " + nminas);
                }
                System.out.println("\n	Intentos restantes: " + (intento - 1));
            } else {
                tminas = tminas - 1;
                System.out.println("\n	Acertaste!, Mina Eliminada Restan " + tminas + " Minas");
                System.out.println("\n	Intentos restantes: " + (intento - 1));
            }
            
       	
          intento=intento-1;
        }while (intento>=tminas && intento>0 && tminas>0);	
 	   
       	if(tminas==0)
       		System.out.println("		GANASTE!");
       	
       	if(tminas>intento)
       		System.out.println("		PERDISTE!    (Exceso de minas restantes "+tminas+")\n\n");
       	
       	if(intento==0)
       		System.out.println("		PERDISTE!");
 	   }
}