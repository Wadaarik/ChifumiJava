import java.util.*;
import java.lang.*;
import java.io.*;

class Chifoumi {
    public static void main(String[] args) {
        RPC rpc = new RPC();
        Challenger challenger = new Challenger();
        Player player = new Player();
    
        int challengerChoice = challenger.challenge();
        int playerChoice = player.player();
        
        String playerChoiceString = rpc.choices[playerChoice];
        String challengerChoiceString = rpc.choices[challengerChoice];
        
        CheckVictory checkVictory = new CheckVictory(playerChoiceString, challengerChoiceString);
        
        System.out.println("Challenger : " + challengerChoiceString);
        System.out.println("Votre choix : " + playerChoiceString);
        System.out.println("Vous avez : " + checkVictory.winCheck());
    }
}

class CheckVictory {
    private String playerChoiceString;
    private String challengerChoiceString;

    public CheckVictory(String playerChoiceString, String challengerChoiceString) {
        this.playerChoiceString = playerChoiceString;
        this.challengerChoiceString = challengerChoiceString;
    }

    public String winCheck() {
        // Logique de vérification simplifiée
        if ((playerChoiceString.equals("Feuille") && challengerChoiceString.equals("Pierre")) || 
            (playerChoiceString.equals("Pierre") && challengerChoiceString.equals("Ciseaux")) || 
            (playerChoiceString.equals("Ciseaux") && challengerChoiceString.equals("Feuille"))) {
            return "Gagné";
        } else if (playerChoiceString.equals(challengerChoiceString)) {
            return "Égalité";
        } else {
            return "Perdu";
        }
    }
}

class RPC {
    String rock = "Pierre";
    String paper = "Feuille";
    String cisors = "Ciseaux"; 
    String[] choices = {rock, paper, cisors};
    
    @Override
    public String toString() {
        return Arrays.toString(choices);
    }
}

class Challenger {
    public int challenge() {
        return (int) (Math.random() * 3);
    }
}

class Player {
    public int player() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Choisissez entre Pierre, Feuille ou Ciseaux :");
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "pierre":
                    return 0;
                case "feuille":
                    return 1;
                case "ciseaux":
                    return 2;
                default:
                    System.out.println("Choix invalide, essayez à nouveau.");
                    return player(); 
            }
        } finally {
            scanner.close(); 
        }
    }
}
