import java.util.Random;
class Enemy extends Character {
    public Enemy(int difficulty) {
        super("Enemy", 100 + difficulty * 20, 100 + difficulty * 15, 20 + difficulty * 5);
        // Randomly decide if enemy is Mage or Warlock
        if (new Random().nextBoolean()) {
            this.name = "Enemy Mage";
        } else {
            this.name = "Enemy Warlock";
        }
    }
    public void takeTurn(Character player) {
        String action = new Random().nextInt(3) == 0 ? "attack" : (new Random().nextInt(2) == 0 ? "use_item" : "defend");
        if (action.equals("attack")) {
            this.attack(player);
        } else if (action.equals("use_item")) {
            this.useItem(new Random().nextBoolean() ? "healing" : "mana");
        } else {
            this.defend();
        }
    }
}