
public class Viking extends Combattant {

	public Viking(String nom, float vieMax, int attaque, int armure) {
		super(nom, vieMax, attaque, armure);
		this.setClasse("Viking");
	}
	
	public void attaquer(Combattant adversaire) {
		System.out.println("Vie de " + adversaire.getNom() + " est de " + adversaire.getVie());
		int degatsInfliges = (int) (this.getAttaque() * ((100 - (this.getVie()*100/this.getVieMax()))/100)) ;
		System.out.println(this.getNom() + " attaque. Il fait " + this.getAttaque() + "pts de dégâts");
		adversaire.encaisser(degatsInfliges);
		System.out.printf("Vie de " + adversaire.getNom() + " est de %.0f" + Jeu.NewLine, adversaire.getVie());
		//System.out.println("" + Jeu.NewLine);
	}
	
	public void encaisser(double degatsRecus) {
		double degatsRecusFinaux = Math.max(0, (degatsRecus*(10000/(this.getArmure()+100))/100));
		System.out.println(this.getNom() + " reçoit " + degatsRecusFinaux + "pts de dégâts");
		double vieRestante = this.getVie() - degatsRecusFinaux;
		this.setVie(Math.max(0, vieRestante));
		if(vieRestante < 0) {
			System.out.println("Valeur armure " + this.getNom() +  " " + this.getArmure());
			this.augmenterArmure(1);
			System.out.println("Nouvelle valeur armure : " + this.getNom() + " " + this.getArmure());
		}		
	}
	
	private void augmenterArmure(int augmentationArmure) {
		this.setArmure(this.getArmure() + augmentationArmure);
	}
}
