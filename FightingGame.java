import java.util.Random;
import java.util.Scanner;
public class FightingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int difficulty = 1;

        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();

        System.out.print("Choose your class (Mage/Warlock): ");
        String playerClass = scanner.nextLine().toLowerCase();

        Character player;
        if (playerClass.equals("mage")) {
            player = new Mage(playerName);
        } else if (playerClass.equals("warlock")) {
            player = new Warlock(playerName);
        } else {
            System.out.println("Invalid class! Defaulting to Mage.");
            player = new Mage(playerName);
        }

        // Game loop
        while (player.hp > 0) {
            System.out.println("\nYour Stats: HP=" + player.hp + " MP=" + player.mp + " SP=" + player.sp +
                    " Potions: Healing=" + player.healingPotions + " Mana=" + player.manaPotions + "\n");

            Enemy enemy = new Enemy(difficulty);
            System.out.println("A wild " + enemy.name + " appears!");

            // Battle loop
            while (enemy.hp > 0 && player.hp > 0) {
                System.out.println("\nYour Turn!");
                System.out.print("Choose your action (Attack, Defend, Use Item): ");
                String action = scanner.nextLine().toLowerCase();

                if (action.equals("attack")) {
                    player.attack(enemy);
                } else if (action.equals("defend")) {
                    player.defend();
                } else if (action.equals("use item")) {
                    System.out.print("Choose item (Healing, Mana): ");
                    String itemType = scanner.nextLine().toLowerCase();
                    player.useItem(itemType);
                } else {
                    System.out.println("Invalid action. Please choose again.");
                }

                if (enemy.hp > 0) {
                    System.out.println("\nEnemy's Turn!");
                    enemy.takeTurn(player);
                }
            }

            if (player.hp > 0) {
                score++;
                System.out.println("\nYou defeated the enemy! Score: " + score);

                // Random potion drop
                String potionDrop = new Random().nextBoolean() ? "healing" : "mana";
                if (potionDrop.equals("healing")) {
                    player.healingPotions++;
                    System.out.println("Enemy dropped a Healing Potion! You now have " + player.healingPotions + ".");
                } else {
                    player.manaPotions++;
                    System.out.println("Enemy dropped a Mana Potion! You now have " + player.manaPotions + ".");
                }
            }

            difficulty++; // Increase difficulty after each victory
        }

        System.out.println("\nGame Over! Your final score: " + score);
        scanner.close();
    }
}