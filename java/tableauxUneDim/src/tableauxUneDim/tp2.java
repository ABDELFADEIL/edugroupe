package tableauxUneDim;

public class tp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 10, y = 15;

		System.out.println(addition(x, y));

		int[] tableauEntiers2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

		System.out.println("Somme = " + somme(tableauEntiers2));

	}

	public static int somme(int[] tabEnt) {

		int somme = 0;

		for (int i = 0; i < tabEnt.length; i++) {
			somme += tabEnt[i];
		}
		return somme;
	}

	public static int addition(int a, int b) {

		return a + b;
	}
}
