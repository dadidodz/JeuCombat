
public class CaseFin extends Case {
	
	public CaseFin (int num�ro) {
		super(num�ro);
	}
	
	public Combattant actionCase(Combattant personnage) {
		Combattant perso = personnage;
		return perso;
		
	}

	@Override
	public String toString() {
		return (super.toString() + "ceci est la case de fin. F�licitations!");
	}
}
