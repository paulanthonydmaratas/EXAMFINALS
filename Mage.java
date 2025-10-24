import java.util.Random;
class Mage extends Character {
    public Mage(String name) {
        super(name, 100, 100, 20);
    }

    // Mage specific abilities
    public void fireball(Character enemy) {
        if (this.mp >= 25) {
            int damage = new Random().nextInt(21) + 30; // Random damage between 30 and 50
            enemy.hp -= damage;
            this.mp -= 25;
            System.out.println(this.name + " casts Fireball on " + enemy.name + " for " + damage + " damage! Enemy is burned!");
        } else {
            System.out.println(this.name + " doesn't have enough MP to cast Fireball!");
        }
    }

    public void iceBlock() {
        if (this.mp >= 60) {
            this.mp -= 60;
            System.out.println(this.name + " casts Ice Block and is immune for 2 turns!");
        } else {
            System.out.println(this.name + " doesn't have enough MP to cast Ice Block!");
        }
    }
}