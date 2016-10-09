public class Stats {
    private int cooldown, maxDamage, maxHP, hp;
    private int initialCooldown, initialMaxDamage, initialMaxHP, initialHp;

    public Stats(int cooldown, int maxDamage, int maxHP, int hp) {
        this.cooldown = initialCooldown = cooldown;
        this.maxDamage = initialMaxDamage = maxDamage;
        this.maxHP = initialMaxHP = maxHP;
        this.hp = initialHp = hp;
    }

    public void reduceHP(int amount) {
        hp -= amount;
    }

    public void resetHP() {
        hp = initialHp;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHp() {
        return hp;
    }
}
