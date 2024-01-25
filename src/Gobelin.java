
public class Gobelin extends Combattant {

	public Gobelin(String nom, float vieMax, int attaque, int armure) {
		super(nom, vieMax, attaque, armure);
		this.setClasse("Gobelin");
	}
	
	public void attaquer(Combattant adversaire) {
		System.out.println("Vie de " + adversaire.getNom() + " est de " + adversaire.getVie());
		int degatsInfliges = this.getAttaque();
		System.out.println(this.getNom() + " attaque. Il fait " + degatsInfliges + "pts de dégâts");
		adversaire.encaisser(degatsInfliges);
		System.out.printf("Vie de " + adversaire.getNom() + " est de %.0f" + Jeu.NewLine, adversaire.getVie());
		//System.out.println("" + Jeu.NewLine);
	}
	
	public void encaisser(double degatsRecus) {
		double degatsRecusFinaux = degatsRecus * ((100-this.getArmure())/100);
		double vieRestante = this.getVie() - degatsRecusFinaux;
		this.setVie(Math.max(0, vieRestante));		
	}
}
