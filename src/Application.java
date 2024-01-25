/**
 * Cette classe permet de démarrer le jeu
 * 
 * @author Dorian BLATIERE

 */
public class Application {

	public static void main(String[] args) throws InterruptedException {
		Jeu j = new Jeu();
		j.jouerJeu();
		/*
		for(int i = 0; i<50; i++) {
			int a;
			a = ((int)(6*Math.random())+1);
			System.out.println(a);
		}
		
		float degatsEnc = Math.max(0, (100*(10000/(80+100))/100));
		System.out.println(degatsEnc);
		degatsEnc = (100*(10000/(80+100))/100);
		System.out.println(degatsEnc);
		*/
	}
	

}
