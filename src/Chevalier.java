
public class Chevalier extends Combattant {

	public Chevalier(String nom, float vieMax, int attaque, int armure) {
		super(nom, vieMax, attaque, armure);
		this.setClasse("Chevalier");
	}
	
	public void attaquer(Combattant adversaire) {
		System.out.println("Vie de " + adversaire.getNom() + " est de " + adversaire.getVie());
		int degatsInfliges = this.getAttaque() + this.getArmure();
		System.out.println(this.getNom() + " attaque. Il fait " + degatsInfliges + "pts de dégâts");
		adversaire.encaisser(degatsInfliges);
		System.out.printf("Vie de " + adversaire.getNom() + " est de %.0f" + Jeu.NewLine, adversaire.getVie());
	}
	
	public void encaisser(double degatsRecus) {
		double degatsRecusFinaux = Math.max(0, (degatsRecus*(10000/(this.getArmure()+100))/100));
		System.out.println(this.getNom() + " reçoit " + degatsRecusFinaux + "pts de dégâts");
		double vieRestante = this.getVie() - degatsRecusFinaux;
		this.setVie(Math.max(0, vieRestante));
		if(this.enVie() && this.getArmure()>0) {	
			System.out.println("Valeur armure " + this.getNom() +  " " + this.getArmure());
			this.reduireArmure(1);
			System.out.println("Nouvelle valeur armure : " + this.getNom() + " " + this.getArmure());
		}
	}
	
	public void reduireArmure(int valeurReductionArmure) {
		int nouveauMontantArmure = this.getArmure() - valeurReductionArmure;
		this.setArmure(Math.max(0, nouveauMontantArmure));
	}
}
