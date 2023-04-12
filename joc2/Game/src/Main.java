import java.util.Random;
import java.util.Scanner;

public class Main {

	private static final int NUM_VAR_RASPUNS=3;
	private static final int NUM_VAR_DECIZIE=10;

	private static int points = 0;
	
	public static int MaxAttemptsToDie = -1;
	
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);
	
	private static int currentQuestion = 0;
	public static String[] questions = {
			"A sarit un tigru dintr-un boschete. Ce faci acum?",
			"Este o praprastie in fata ta, ai de ales dintre: ",
			"Dupa ceva timp dai de un porc mistret ranit, ai de ales dintre: ",
			"Iti este fomica, acum totul pare foarte bun de mancat, la fel si fructele din boschetele de langa tine... ",
			"Ai dat de o cabana abandonata, ce doresti sa faci acum? ",
			"Observi ceva de mancare intr-un copac, acum alegerea ta este: "
	};
	public static String[][] possibleAnswers = {
		{"Fugi (1)", "Il ataci cu un bat de pe jos (2)", "Tipi (3)", "Faci selfie (4)"},
		{"Sari (1)", "Mergi in partea stanga, pe langa prapastie (2)", "Mergi in partea dreapta, pe langa prapastie (3)", "Incerci sa cobori in prapastie (4)"},
		{"Il tai (1)", "Dai cu apa sfintita (2)", "Il lasi acolo (3)", "Incerci sa-l tratezi (4)"},
		{"Mananci, normal (1)", "Mananci, dar mai putin (2)", "Treci peste (3)", "Incerci sa cauti altceva (4)"},
		{"Loot-ezi (1)", "Treci peste (2)", "Te asiguri ca nu mai e nimeni in cabana intai (3)", "Cauti o arma (4)"},
		{"Te urci in copac (1)", "Incerci sa ajungi la ce este in copac cu un bat (2)", "Mergi mai departe (3)", "Cercetezi zona mai bine (4)"},
	};
	public static int[] answers = {1, 2, 3, 4, 3, 4};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int aleatoriu = random.nextInt(3);
		
		String[] personaje = {"Jo", "Boyd", "Flint"};
		
		System.out.println("Bine ai venit! Sa inceapa jocul!");
		System.out.println("Alege un caracter dintre Jo, Boyd si Flint:");
		
		String caracter = scanner.nextLine();
		
		while (!isPersonajValid(caracter, personaje)) {
			System.out.println("Caracterul ales nu este valid. Te rog sa alegi dintre Jo, Boyd si Flint.");
			caracter = scanner.nextLine();
		}
		System.out.println("Ai ales personajul "+ caracter + "."); 
		
		System.out.println("Unde doresti sa incepi aventura? Alege dintre: desert, jungla sau zona montana.");
		
		String locatie = scanner.nextLine();
		
		while (!isLocatieValida(locatie)) {
			System.out.println("Locatia aleasa nu este valida. Te rog sa alegi dintre desert, jungla sau zona montana.");
			locatie = scanner.nextLine();
		}
		System.out.println("Ai ales sa incepi aventura in "+ locatie + ".");
		
		
		while (currentQuestion < questions.length) {
			System.out.println("--------");
			System.out.println(questions[currentQuestion]);
			for (var i = 0; i < possibleAnswers[currentQuestion].length; i++) {
				System.out.println(possibleAnswers[currentQuestion][i]);
			}
			System.out.println("Raspuns: ");
			var answer = scanner.nextLine();
			if (Integer.parseInt(answer) == answers[currentQuestion]) {
				points += 1;
			} else {
				points -= 1;
				
				if (points == MaxAttemptsToDie) {
					System.out.println("Ai murit din cauza raspunsurilor multiple gresite ... ");
					return;
				}
			}
			
			System.out.println("Puncte: " + points);
			System.out.println("--------");
			currentQuestion += 1;
		}

		System.out.println("Ai atins finalul jocului cu scorul de: " + points + " puncte");	
	}

	private static boolean isPersonajValid(String caracter, String[] personaje) {
		// TODO Auto-generated method stub
		return caracter.equalsIgnoreCase("Jo")|| caracter.equalsIgnoreCase("Boyd") || caracter.equalsIgnoreCase("Flint");
		
	}
	
	private static boolean isLocatieValida(String locatie) {
		// TODO Auto-generated method stub
		return locatie.equalsIgnoreCase("desert") || locatie.equalsIgnoreCase("jungla") || locatie.equalsIgnoreCase("zona montana");
	}
	
	private static String[] getRaspunsuri(String caracter, String locatie, int aleatoriu1, int aleatoriu2) {
		// TODO Auto-generated method stub
		String[] raspunsuri = new String[3];
		raspunsuri[0] = "Alegi varianta 1";
		raspunsuri[1] = "Alegi varianta 2";
		raspunsuri[2] = "Alegi varianta 3";
		return raspunsuri;
	}
	
	private static void afiseazaRaspunsuri(String[] raspunsuri) {
		// TODO Auto-generated method stub
		for (int i = 0; i < raspunsuri.length; i++){
			System.out.println((i + 1) + ". " + raspunsuri[i]);
		}
	}

}
