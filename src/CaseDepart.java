import java.util.Scanner;

public class CaseDepart extends Case {
	
	
	
	public CaseDepart(int numéro) {
		super(numéro);
		
	}
	
	public Combattant actionCase(Combattant personnage) throws InterruptedException {
		char confirmation = ' ';
		Scanner entree = new Scanner(System.in);
		do {
			System.out.print("Voulez-vous commencer la partie ?");
			System.out.print(""+ Jeu.NewLine);
			confirmation = entree.nextLine().charAt(0);
		}while(confirmation!='O' && confirmation!='o');
		entree.close();
		//Thread.sleep(2000);
		Combattant perso = personnage;
		return perso;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "ceci est la case de départ");
	}

}
