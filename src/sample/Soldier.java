package sample;
import java.util.Random;
import java.util.Scanner;
public class Soldier {
    private int maxDamage;
    private int minDamage;
    private String name;
    private String description;
    private int health;
    private int maxHealth;
    private int numOfPotions;
    private String picture;
    private boolean stoleSoul=false;

    public Soldier(String newName, String newDescription, String newPicture, int newHealth, int newMaxHealth, int newMaxDamage, int newMinDamage, int newNumOfPotions) {
        maxDamage = newMaxDamage;
        minDamage = newMinDamage;
        picture=newPicture;
        name = newName;
        description=newDescription;
        health = newHealth;
        numOfPotions = newNumOfPotions;
        maxHealth=newMaxHealth;
    }
    public void regenerate(){
        health=maxHealth;
        //numOfPotions=1;
    }
    public void upgrade(){
        System.out.println("You now have a chance to upgrade your character. Press (1) to upgrade your damage, (2) to upgrade your health, and (3) to get an extra potion.");
        Scanner scan=new Scanner(System.in);
        int choice=scan.nextInt();
        if (choice==1){
            maxDamage*=1.2;
            minDamage*=1.2;
            System.out.println("Congratulations! Your min damage is now "+minDamage+" and your max damage is now "+maxDamage+".\n");
        }
        else if (choice==2){
            health*=1.2;
            maxHealth*=1.2;
            System.out.println("Congratulations! Your health is now "+health+".\n");
        }
        else if (choice==3){
            numOfPotions+=1;
            System.out.println("Congratulations! You now have "+numOfPotions+" potions.\n");
        }
    }
    public boolean isAlive(){
        if (health>0){
            return true;
        }
        return false;
    }
    public boolean stoleSoul(){
        if (stoleSoul) return true;
        else return false;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public void reset(){
        health=maxHealth;
        numOfPotions=1;
    }
    public void subtractHealth(int damage){
        health-=damage;
    }
    public int getHealth(){
        return health;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getNumOfPotions(){
        return numOfPotions;
    }
    public int attack(){
        Random rand=new Random();
        return rand.nextInt(maxDamage+1-minDamage)+minDamage;
    }
    public boolean heal() {
        if (numOfPotions > 0) {
            numOfPotions--;
            health=maxHealth;
            return true;
        }
        return false;
    }
    public void setStoleSoul(boolean t){
        stoleSoul=t;
    }
}