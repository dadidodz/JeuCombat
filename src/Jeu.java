import java.util.Scanner;

public class Jeu {
	
	public static final int NB_CASE = 15;
	private Plateau plateau;
	private Combattant personnage;
	private String[][] statsCombattants = new String [][] {
		{"Chevalier", "2500", "100","100"},
		{"Viking", "2000", "250","25"},
		{"Plaisantin", "1500", "125", "0"}
	};
	private String[] nomsStats = new String []{"Classe", "PV", "Force", "Armure"};
	
	static String NewLine = System.getProperty("line.separator");
	
	public Jeu() {
		System.out.println("Création du plateau de jeu");
		this.plateau = new Plateau(NB_CASE);
	}
	
	public void jouerJeu() throws InterruptedException {
		choixPersonnage();
		System.out.println("Début du jeu");
		System.out.printf("Statistiques du personnage :\n	Attaque : " + this.personnage.getAttaque() + "\n	Vie : %.0f \n	Armure : " + this.personnage.getArmure(), this.personnage.getVieMax());
		System.out.print(NewLine);
		this.actionPersonnage(this.personnage);
		do {
			this.positionPlusUn();
			this.actionPersonnage(this.personnage);
			
		}while (!this.estPartieFinie());
	
		System.out.println("Fin du jeu.");
	}
	
	private void choixPersonnage() {
		System.out.println("Statistiques des différentes classes :");
		for (int i=0; i<this.statsCombattants.length; i++) {
			for (int j=0; j<this.statsCombattants[i].length; j++) {
				System.out.println(this.nomsStats[j] + " : " + this.statsCombattants[i][j]);
			}
			System.out.print(""+ NewLine);
		}
		char confirmation = ' ', choix = ' ';
		Scanner entree = new Scanner(System.in);
		do {
			System.out.print("Avant de commencer à jouer, choisissez votre classe. Vous avez le choix entre " + this.statsCombattants.length + " classes :");
			for(int a=0; a<this.statsCombattants.length; a++) {
				System.out.print(" " + this.statsCombattants[a][0]);
			}
			System.out.print(NewLine);
			do{
				System.out.println("Taper 'c' pour le chevalier, 'v' pour le viking, 'p' pour le plaisantin ");
				choix = entree.nextLine().charAt(0);
			}while(choix!='c' && choix!='v' && choix!='p');
			do{
				System.out.print("Vous avez choisi le ");
				if (choix == 'c') {
					System.out.print(this.statsCombattants[0][0]);
				}
				if (choix=='v') {
					System.out.print(this.statsCombattants[1][0]);
				}
				if (choix=='p') {
					System.out.print(this.statsCombattants[2][0]);
				}
				System.out.println(" êtes-vous sûr ? (Ce choix sera inchangeable pas la suite) (O/N)");
				confirmation = entree.nextLine().charAt(0);
			}while(confirmation!='o' && confirmation!='n');
		}while(confirmation == 'n');
		//entree.close();
		this.personnage = creerPersonnage(choix);
	}
	
	//Attribue les caractéristiques des personnages en fonction du choix du joueur
	private Combattant creerPersonnage(char classe) {
		if (classe == 'c') {
			return new Chevalier(this.statsCombattants[0][0], Float.parseFloat(this.statsCombattants[0][1]), Integer.parseInt(this.statsCombattants[0][2]), Integer.parseInt(this.statsCombattants[0][3]));
		}
		if (classe == 'v') {
			return new Viking(this.statsCombattants[1][0], Float.parseFloat(this.statsCombattants[1][1]), Integer.parseInt(this.statsCombattants[1][2]), Integer.parseInt(this.statsCombattants[1][3]));
		}
		if (classe == 'p') {
			return new Plaisantin(this.statsCombattants[2][0], Float.parseFloat(this.statsCombattants[2][1]), Integer.parseInt(this.statsCombattants[2][2]), Integer.parseInt(this.statsCombattants[2][3]));
		}else
			return null;
	}
	
	private boolean estPartieFinie() {
		boolean retour = false;
		if (this.personnage.getPosition()==NB_CASE-1 || !this.personnage.enVie() ) {
				retour = true;
		}
		return retour;			
	}
	
	private void positionPlusUn() {
		System.out.println("Position du pion " + this.personnage.getClasse() + " avant de jouer : " + this.personnage.getPosition());
		System.out.println("Le personnage avance d'une case");
		this.personnage.positionPlusUn();
		System.out.println("Position du pion " + this.personnage.getClasse() + " après avoir jouer : " + this.personnage.getPosition());
		System.out.print(""+ NewLine);
		// Thread.sleep(2000);
	}
	
	private void actionPersonnage(Combattant personnage) throws InterruptedException {
		personnage.action(this.plateau.calculAction(personnage));
	}
}
