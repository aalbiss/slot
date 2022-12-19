//FINITO

package esercizi;

import java.util.Scanner;

public class Slot {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner KB = new Scanner(System.in);
		int j = 1;
		int i;
		int DIM = 3;
		int MIN = 1;
		int MAX = 100;
		int numeriCasuali[] = new int[DIM];
		int casuali;
		boolean jackpot = false;
		int monete = 100;
		int rigioca = 0;
		
		do {
			monete--;
			
			for(i=0;i<DIM;i++) {
				casuali = (int) (Math.random() * (MAX-MIN+1)+MIN);
				numeriCasuali[i]=casuali;
				
				System.out.print(numeriCasuali[i] + " ");
			}
			System.out.println();
			
//			Thread.sleep(500);
			
			if (numeriCasuali[0]==numeriCasuali[1] && numeriCasuali[1]==numeriCasuali[2]) {
				monete = monete + 100;
				jackpot = true;

			}
			else if(numeriCasuali[0]==numeriCasuali[1] || numeriCasuali[0]==numeriCasuali[2] || numeriCasuali[1]==numeriCasuali[2]) {
				monete = monete + 3;
				System.out.println("2 numeri uguali, +3 monete");
				System.out.println("--------------------------");
			}
			
			System.out.println();
			j++;
			
		}while(jackpot==false && j<=10);
		
		if(jackpot) {
			System.out.println("!! Hai fatto jackpot !! NON PUOI PIÙ GIOCARE");
		}

		else {
			do {
				
				monete--;
				Thread.sleep(700);
				for(i=0;i<DIM;i++) {
					casuali = (int) (Math.random() * (MAX-MIN+1)+MIN);
					numeriCasuali[i]=casuali;
					
					System.out.print(numeriCasuali[i] + " ");
				}
				
				System.out.println();
				
				if (numeriCasuali[0]==numeriCasuali[1] && numeriCasuali[1]==numeriCasuali[2]) {
					monete = monete + 100;
					jackpot = true;
				}
				else if(numeriCasuali[0]==numeriCasuali[1] || numeriCasuali[0]==numeriCasuali[2] || numeriCasuali[1]==numeriCasuali[2]) {
					monete = monete + 3;
					System.out.println("2 numeri uguali, +3 monete");
				}
				
				Thread.sleep(400);
				
				System.out.println();
				if(monete>0 && jackpot==false) {
					System.out.println("Inserire 1 per rigiocare e vedere le monete; 2 per rigiocare e non vedere le monete; 3 per fermarsi");
					rigioca = KB.nextInt();
					if(rigioca==1){
						System.out.println();
						System.out.println("Hai ancora: " + monete + " monete");
						System.out.println("La slot sta rigirando");
						System.out.println();
					}
					else if(rigioca==2) {
						System.out.println();
						System.out.println("La slot sta rigirando");
						System.out.println();
						rigioca=1;
					}
					
				}
					
			}while((rigioca == 1 && monete>=0) && jackpot==false ); //do
			
		} 
		
		System.out.println("Jackpot: " + jackpot);
		System.out.println("Prelevare le monete le monete: " + monete + " monete");
	}
}
