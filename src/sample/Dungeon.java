package sample;

public class Dungeon {
    String name;
    String description;
    Soldier fighter;

    public Dungeon(String n, String d, Soldier f) {
        name = n;
        description = d;
        fighter = f;
    }

    public boolean isDefeated() {
        if (fighter.isAlive() == false) {
            return true;
        }

        return false;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Soldier getFighter() {
        return fighter;
    }
}
