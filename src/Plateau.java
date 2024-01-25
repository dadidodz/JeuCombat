
public class Plateau {

	//public static final int NB_CASE=10;
	private Case[] cases;
	
	public Plateau (int nbCases) {
		this.cases = new Case [nbCases];
		for (int i=0; i<cases.length; i++) {
			switch(i) {
			case 0:
				cases[i]= new CaseDepart(i);
			break;
			case Jeu.NB_CASE-1:
				cases[i]= new CaseFin(i);
			break;
			default:
			if ((i % 2) == 0) {
				cases[i]= new CaseRepos(i);
			}
			else {
				cases[i]= new CaseCombat(i);
			}
			}
		}
	}
	
	public Combattant calculAction (Combattant personnage) throws InterruptedException{
		System.out.println(this.cases[personnage.getPosition()].toString());
		/*int a = cases[position].actionCase(valeur);
		if(position+a>(cases.length-1)) {
			return (2*((cases.length-1)-position) - a);
		}
		return a;*/
		Combattant copiePersonnage = cases[personnage.getPosition()].actionCase(personnage);
		return copiePersonnage;
	}
}
