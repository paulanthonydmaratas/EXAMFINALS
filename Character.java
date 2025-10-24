import java.util.Random;
abstract class Character {
    String name;
    int hp, mp, sp;
    int healingPotions = 3;
    int manaPotions = 3;

    public Character(String name, int hp, int mp, int sp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.sp = sp;
    }

    // Basic Actions
    public void attack(Character enemy) {
        if (this.sp >= 2) {
            int damage = new Random().nextInt(11) + 10; // Random damage between 10 and 20
            enemy.hp -= damage;
            this.sp -= 2;
            System.out.println(this.name + " attacks " + enemy.name + " for " + damage + " damage!");
        } else {
            System.out.println(this.name + " doesn't have enough SP to attack!");
        }
    }

    public void defend() {
        if (this.sp >= 3) {
            this.sp -= 3;
            System.out.println(this.name + " defends and reduces incoming damage!");
        } else {
            System.out.println(this.name + " doesn't have enough SP to defend!");
        }
    }

    public void useItem(String itemType) {
        if (itemType.equals("healing") && healingPotions > 0) {
            this.hp += 50;
            healingPotions--;
            System.out.println(this.name + " uses a Healing Potion! " + this.hp + " HP restored.");
        } else if (itemType.equals("mana") && manaPotions > 0) {
            this.mp += 30;
            manaPotions--;
            System.out.println(this.name + " uses a Mana Potion! " + this.mp + " MP restored.");
        } else {
            System.out.println("No " + itemType + " potions left!");
        }
    }
}