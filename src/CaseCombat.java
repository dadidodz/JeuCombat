
public class CaseCombat extends Case{

	//private Combat combat;
	private Combattant ennemi;
	//String NewLine = System.getProperty("line.separator");
	
	public CaseCombat(int numéro) {
		super(numéro);
		this.ennemi = new Gobelin("Ennemi", 1000F, 80, 0);
		//this.combat = new Combat();
	}

	public Combattant actionCase(Combattant personnage) {
		Combattant perso = personnage;
		int i = 1;
		while (perso.enVie() && this.ennemi.enVie()) {
			System.out.println("Tour du combat n°" + i);
			perso.attaquer(this.ennemi);
			if (this.ennemi.enVie()) {
				this.ennemi.attaquer(perso);
			}
			System.out.print(""+ Jeu.NewLine);
			i++;
		}
		System.out.println("Fin du combat");
		return perso;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "ceci est une case combat");
	}
}
