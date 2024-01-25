
public abstract class Case {
	
	private int numero;
	
	public Case(int numero) throws IllegalArgumentException {
		if (numero>50) {
			throw new IllegalArgumentException("Numéro de case supérieur à 50");
		}
		this.numero = numero;
	}

	public abstract Combattant actionCase(Combattant personnage) throws InterruptedException;
	
	@Override
	public String toString() {
		return "[case n°" + numero + "] : ";
	}
}
