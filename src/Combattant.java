
public abstract class Combattant {
	
	private int id;
	private String nom;
	private String classe;
	private float vieMax;
	private double vie;
	private int attaque;
	private float chanceCritique;
	private float multiplicateurCritique;
	private int vitesse;
	private int armure;
	private int position;
	
	public Combattant (String nom, float vieMax, int attaque, int armure) throws IllegalArgumentException  {
		if (vieMax <1 || attaque<0 || armure<0) {
			throw new IllegalArgumentException("Les valeurs ne peuvent pas être négatives");
		}
		this.nom = nom;
		this.vieMax = vieMax;
		this.vie = vieMax;
		this.attaque = attaque;
		this.armure = armure;
		this.position = 0;
		
	}
	
	public String getClasse() {
		return this.classe;
	}
	
	protected void setClasse(String classe) {
		this.classe = classe;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public boolean enVie() {
		boolean retour = true;
		if (this.vie <= 0) {
			retour = false;
		}
		return retour;
	}

	public float getVieMax() {
		return vieMax;
	}

	public void setVieMax(float vieMax) {
		this.vieMax = vieMax;
	}
	
	public double getVie() {
		return this.vie;
	}
	
	public void setVie(double vieRestante) {
		this.vie = vieRestante;
	}
	
	public int getAttaque() {
		return this.attaque;
	}
	
	public int getArmure() {
		return this.armure;
	}
	
	public void setArmure(int nouvelleValeurArmure) {
		this.armure = nouvelleValeurArmure;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void combattre(float vie) {
		this.vie = vie;
	}
	
	public abstract void attaquer(Combattant adversaire);
	
	public abstract void encaisser(double degatsRecus);
	
	public void seSoigner(double montantSoin) {
		this.setVie(Math.min(this.getVieMax(), this.getVie() + montantSoin));
	}
	
	public void action(Combattant personnage) {
		this.vie = personnage.vie;
	}
	
	protected void positionPlusUn() {
		this.position+= 1;
	}
}
