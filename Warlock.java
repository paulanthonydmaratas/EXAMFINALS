import java.util.Random;
class Warlock extends Character {
    public Warlock(String name) {
        super(name, 120, 120, 15);
    }

    // Warlock specific abilities
    public void shadowBolt(Character enemy) {
        if (this.mp >= 30) {
            int damage = new Random().nextInt(21) + 40; // Random damage between 40 and 60
            enemy.hp -= damage;
            this.mp -= 30;
            System.out.println(this.name + " casts Shadow Bolt on " + enemy.name + " for " + damage + " damage! Shadow damage over time!");
        } else {
            System.out.println(this.name + " doesn't have enough MP to cast Shadow Bolt!");
        }
    }

    public void healthstone() {
        if (this.mp >= 40) {
            int heal = (int)(0.4 * this.hp);
            this.hp += heal;
            this.mp -= 40;
            System.out.println(this.name + " uses Healthstone and heals for " + heal + " HP!");
        } else {
            System.out.println(this.name + " doesn't have enough MP to use Healthstone!");
        }
    }
}