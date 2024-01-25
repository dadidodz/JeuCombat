
public class Plaisantin extends Combattant{

	public Plaisantin(String nom, float vieMax, int attaque, int armure) {
		super(nom, vieMax, attaque, armure);
		this.setClasse("Plaisantin");
	}
	
	public void attaquer(Combattant adversaire) {
		System.out.println("Vie de " + adversaire.getNom() + " est de " + adversaire.getVie());
		double degatsInfliges;
		float d20 = ((int)(20*Math.random())+1);
		System.out.println("Le Plaisantin lance un d� :" + d20);
		float multiplicateurDegats = 4*d20/10;
		System.out.println("Multiplicateur de d�g�ts : " + multiplicateurDegats);
		if (d20 == 1) {
			degatsInfliges = 0;
		} else if (d20 == 20){
			degatsInfliges = 9999;
		}else {
			degatsInfliges = Math.ceil(this.getAttaque() * multiplicateurDegats);
		}
		System.out.println(this.getNom() + " attaque. Il fait " + degatsInfliges + "pts de d�g�ts");
		adversaire.encaisser(degatsInfliges);
		System.out.printf("Vie de " + adversaire.getNom() + " est de %.0f" + Jeu.NewLine, adversaire.getVie());
		//System.out.println("" + Jeu.NewLine);
	}
	
	public void encaisser(double degatsRecus) {
		float d20 = ((int)(20*Math.random())+1);
		System.out.println("d� : " + d20);
		if(d20 == 20) {
			System.out.println("D�g�ts absorb�s");
			//vieRestante = this.getVie();
		}else {
			double degatsRecusFinaux = Math.ceil((degatsRecus *(10/d20)));
			System.out.println(this.getNom() + " re�oit " + degatsRecusFinaux + "pts de d�g�ts");
			double vieRestante = this.getVie() - degatsRecusFinaux;
			this.setVie(Math.max(0, vieRestante));
		}		
	}
	
	
}
