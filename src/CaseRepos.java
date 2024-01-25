
public class CaseRepos extends Case {

	public CaseRepos(int numéro) {
		super(numéro);
	}
	
	public Combattant actionCase(Combattant personnage) {
		Combattant perso = personnage;
		double soin = perso.getVieMax()*10/100;
		perso.seSoigner(soin);
		System.out.println(perso.getNom() +  " se soigne de " + soin);
		return perso;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "ceci est une case repos");
	}
}
