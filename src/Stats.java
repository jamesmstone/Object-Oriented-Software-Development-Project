public class Stats {
    private int cooldown, maxDamage, maxHP, hp;
    private int initialCooldown, initialMaxDamage, initialMaxHP, initialHp;

    public Stats(int cooldown, int maxDamage, int maxHP, int hp) {
        this.cooldown = initialCooldown = cooldown;
        this.maxDamage = initialMaxDamage = maxDamage;
        this.maxHP = initialMaxHP = maxHP;
        this.hp = initialHp = hp;
    }

    /**
     * Reduces hp by amount
     * @param amount
     */
    public void reduceHP(int amount) {
        hp -= amount;
    }

    /**
     * resets hp to its original value
     */
    public void resetHP() {
        hp = maxHP;
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

    /**
     * Modifies a stats object
     * @param statsToAdd the modifications you wish to make
     */
    public void modify(Stats statsToAdd){
        this.cooldown += statsToAdd.cooldown;
        this.maxDamage += statsToAdd.maxDamage;
        this.maxHP += statsToAdd.maxHP;
        this.hp += statsToAdd.hp;
    }
}
