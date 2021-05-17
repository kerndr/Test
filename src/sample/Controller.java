package sample;
import java.util.Locale;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Controller {
    private Dungeon[][] dungeonMaze=new Dungeon[4][4];
    public Soldier player;
    public Soldier opponent;
    public Dungeon currentDungeon;
    private Button[][] buttonLayout=new Button[4][4];
    @FXML
    public Button zerozero,zeroone,zerotwo,zerothree,onezero,oneone,onetwo,onethree,twozero,twoone,twotwo,twothree,threezero,threeone,threetwo,threethree,attackButton,healButton;
    @FXML
    public Label fightStatusLabel1,fightStatusLabel2,playerLabel,opponentLabel,potionLabel,opponentName,gameResultLabel,dungeonName;
    @FXML
    public ImageView opponentImage;
    @FXML
    public void initialize(){
        initializeMazeAndStartGame();
    }
    @FXML
    public void initializeMazeAndStartGame() {
        buttonLayout[0][0]=zerozero;
        buttonLayout[0][1]=onezero;
        buttonLayout[0][2]=twozero;
        buttonLayout[0][3]=threezero;
        buttonLayout[1][0]=zeroone;
        buttonLayout[1][1]=oneone;
        buttonLayout[1][2]=twoone;
        buttonLayout[1][3]=threeone;
        buttonLayout[2][0]=zerotwo;
        buttonLayout[2][1]=onetwo;
        buttonLayout[2][2]=twotwo;
        buttonLayout[2][3]=threetwo;
        buttonLayout[3][0]=zerothree;
        buttonLayout[3][1]=onethree;
        buttonLayout[3][2]=twothree;
        buttonLayout[3][3]=threethree;
        player = new Soldier("", "", "player.jpg", 150, 150, 25, 15, 5);
        Soldier f1 = new Soldier("The Weakling", "he failed all his fighting classes, so he's not very strong.", "weakling.jpg", 50, 50, 15, 5, 0);
        Soldier f2 = new Soldier("The Alchemist", "she doesn't hit very hard, but she has some tricks up her sleeve that'll make you think twice.", "alchemist.png",  75, 75, 10, 5, 0);
        Soldier f3 = new Soldier("The Titan", "he's very big and strong, but his health isn't great.", "titan.jpg", 75, 75, 25, 15, 0);
        Soldier f4 = new Soldier("The Glitch", "ă̸̡̤̩̙̜͚͙͍̞͉̼͛͗͑̇̍̾̐̀̌̒̀̓̚͝ş̵̛̭̩͙̻͎̳͇̠͈̲̭̃͊̌͂̌̏̊͑̈́̍̚̚̚͝ͅl̵͉̰̲̹̲͉̅̐͒̋͒̉̀̋̈́̃́̕͜͜͝d̷̲̋̒̑̏̒̑͝͝f̸̨̖͉̹͎̐̃̎͋̄̑́̓̑i̵̞̝̭̦̣̖̓͆́y̵̧̛̟͙͉̥̣̰̝̠̒͋͋̉̈́͊̀̎̏̀́͜͝͝w̴͚͖̫͚͚͍̆͑̓̊̄̍ͅͅe̷̳̼̠͈͍̞̓͋̍̿̆ŗ̸̫̜̜̟͖̪͙̖̺̜͉̝͛̀̂́̌͝u̷̦̒̕i̸͇̠̳̜̊̄̈́̿̓͑̎̽̂v̵̧͕̼̞̖̮̬͖̘̣͕̖̊̀b̵̛͖̥̠͕̖̙̘͊̒j̴̨̛̞̞̭͓̪͕̯̣̩͎̦̣̳̃́̄͑ͅk̴͈͖̦̭͕̲̻̞͔͙̟̃̑̑͌̿̎͂͝ͅͅľ̷̛̬̗̺̤̲̠̟͕̪̩͇̑͝s̶̨̩͔͇̀͗̾͜͝j̴̟̠̒̄̇̽̈́̐̓͒̑͌̂̅̒͂̅", "glitch.png", 1, 1, 1, 1, 0);
        Soldier f5 = new Soldier("The Nick", "the strongest enemy you will ever fight.", "nick.jpg", 150, 150, 30, 20, 0);
        Soldier f6 = new Soldier("The Alien", "this enemy is out of this world!", "alien.jpg", 100,100, 20, 15, 0);
        Soldier f7 = new Soldier("The Wolf", "a strong, quick enemy that will make you think fast.", "wolf.jpg", 70,70,25,15,0);
        Soldier f8 = new Soldier("The Spider", "maybe you could step on it or something?", "spider.jpg", 20,20,10,5,0);
        Soldier f9 = new Soldier("The Crab", "look out for its pincers!","crab.jpg",50,50,10,5,0);
        Soldier f10 = new Soldier("The Ogre","get out of my swamp!", "ogre.png", 150, 150, 20, 12, 0);
        Soldier f11 = new Soldier("The Reaper", "death itself has come for you.", "reaper.png", 1000000, 1000000, 10000, 10000, 0);
        Soldier f12 = new Soldier("The Fighter", "this enemy looks just like you.", "player.jpg", 150, 150, 25, 15, 0);
        Soldier f13 = new Soldier("The Slime", "a green blob that looks hard to kill.", "slime.png", 500, 500, 1, 1, 0);
        Soldier f14 = new Soldier("The Zombie","she rose from the dead just to fight you.", "zombie.png", 125, 125, 15, 10, 0);
        Soldier f15 = new Soldier("The Archer","his aim is dead on, but that might not help him very much in this fight.", "archer.png", 75, 75, 30, 5, 0);
        Soldier f16 = new Soldier("The Swordsman", "highly trained and well-armed, this enemy will be hard to kill.", "swordsman.png", 125, 125, 25, 15, 0);
        Soldier[] poolOfFighters={f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16};
        Collections.shuffle(Arrays.asList(poolOfFighters));
        Random random=new Random();
        int randNum=random.nextInt(16);
        poolOfFighters[randNum].setStoleSoul(true);
        Dungeon d1 = new Dungeon("The Classroom","Maybe you'll learn something here.",poolOfFighters[0]);
        Dungeon d2 = new Dungeon("The Arena","Countless fighters have fallen here.",poolOfFighters[1]);
        Dungeon d3 = new Dungeon("The Library","Don't disturb the books!",poolOfFighters[2]);
        Dungeon d4 = new Dungeon("The Kitchen","Attacking your opponent with pots and pans.",poolOfFighters[3]);
        Dungeon d5 = new Dungeon("The Spaceship","The gravity might make fighting hard.",poolOfFighters[4]);
        Dungeon d6 = new Dungeon("The Battlefield","Your fight is only one of many happening around you.",poolOfFighters[5]);
        Dungeon d7 = new Dungeon("The Cliff","Be careful, or you might fall off.",poolOfFighters[6]);
        Dungeon d8 = new Dungeon("The Beach","The peaceful water provides a nice background to your fight.",poolOfFighters[7]);
        Dungeon d9 = new Dungeon("The Garden","The blood of your opponent will make good fertilizer.",poolOfFighters[8]);
        Dungeon d10 = new Dungeon("The Playground","If all else fails, you can push your opponent down the slide.",poolOfFighters[9]);
        Dungeon d11 = new Dungeon("The Lake","Try not to get seasick.",poolOfFighters[10]);
        Dungeon d12 = new Dungeon("The Volcano","This might not be the safest place to fight.",poolOfFighters[11]);
        Dungeon d13 = new Dungeon("The Airport","Don't miss your flight!",poolOfFighters[12]);
        Dungeon d14 = new Dungeon("The Temple.","May the gods be with you in your fight.",poolOfFighters[13]);
        Dungeon d15 = new Dungeon("The Bar","Once your fight is done, you can order a drink.",poolOfFighters[14]);
        Dungeon d16 = new Dungeon("The Cave","Seeing your enemy well enough to hit them is half the problem.",poolOfFighters[15]);
        Dungeon[] dungeons= {d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15,d16};
        Collections.shuffle(Arrays.asList(dungeons));
        dungeonMaze[0][0]=dungeons[0];
        dungeonMaze[0][1]=dungeons[1];
        dungeonMaze[0][2]=dungeons[2];
        dungeonMaze[0][3]=dungeons[3];
        dungeonMaze[1][0]=dungeons[4];
        dungeonMaze[1][1]=dungeons[5];
        dungeonMaze[1][2]=dungeons[6];
        dungeonMaze[1][3]=dungeons[7];
        dungeonMaze[2][0]=dungeons[8];
        dungeonMaze[2][1]=dungeons[9];
        dungeonMaze[2][2]=dungeons[10];
        dungeonMaze[2][3]=dungeons[11];
        dungeonMaze[3][0]=dungeons[12];
        dungeonMaze[3][1]=dungeons[13];
        dungeonMaze[3][2]=dungeons[14];
        dungeonMaze[3][3]=dungeons[15];
        int playerX=random.nextInt(4);
        int playerY=random.nextInt(4);
        currentDungeon=dungeonMaze[playerX][playerY];
        setButtons();
        opponent=currentDungeon.getFighter();
        setLabels();
        opponentName.setText(opponent.getName());
        dungeonName.setText(currentDungeon.getName());
        fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
        fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        setButtons();
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        disableDungeonButtons();
    }
    @FXML
    public void attackButtonPressed(){
        disableDungeonButtons();
        int playerAttackStrength = player.attack();
        opponent.subtractHealth(playerAttackStrength);
        if (opponent.isAlive()) {
            fightStatusLabel1.setText("You attacked with a strength of " + playerAttackStrength + ". Your opponent now has " + opponent.getHealth() + " hitpoints left.");
        }
        else{
            fightStatusLabel1.setText("You attacked with a strength of "+playerAttackStrength+". Your opponent is now dead.");
            disableFightButtons();
            if (opponent.stoleSoul()) {
                setLabels();
                fightStatusLabel2.setText("Great news! This is the fighter who stole your soul. You have reclaimed and reinserted your soul. You feel a sense of calm rush over you.");
                gameResultLabel.setText("         You Win!");
                return;
            }
            else {
                fightStatusLabel2.setText("Unfortunately, this is not the fighter who stole your soul. Keep looking for it by moving to an adjacent orange dungeon on the map.");
            }
            //enableDungeonButtons();
            setButtons();
            opponent=currentDungeon.getFighter();
            setLabels();
            return;
        }
        int opponentAttackStrength = opponent.attack();
        player.subtractHealth(opponentAttackStrength);
        if (player.isAlive()) {
            fightStatusLabel2.setText("Your opponent attacked with a strength of "+opponentAttackStrength+". You now have "+player.getHealth()+" hitpoints left.");
        }
        else{
            fightStatusLabel2.setText("Your opponent attacked with a strength of "+opponentAttackStrength+". You are now dead. Since you have no soul, you become dirt and all your friends forever call you Dirtbag.");
            setLabels();
            disableFightButtons();
            gameResultLabel.setText("         You Lose!");
            return;
        }
        setLabels();
    }
    @FXML
    public void healButtonPressed(){
        if (player.getNumOfPotions()>0){
            player.heal();
            fightStatusLabel1.setText("You drink your potion and suddenly feel healthy and invigorated. You now have " + player.getHealth() + " hitpoints left.");
        }
        if (player.getNumOfPotions()==0){
            healButton.setDisable(true);
        }
        int opponentAttackStrength = opponent.attack();
        player.subtractHealth(opponentAttackStrength);
        if (player.isAlive()) {
            fightStatusLabel2.setText("Your opponent attacked with a strength of "+opponentAttackStrength+". You now have "+player.getHealth()+" hitpoints left.");
        }
        else{
            fightStatusLabel2.setText("Your opponent attacked with a strength of "+opponentAttackStrength+". You are now dead. Since you have no soul, you become dirt and all your friends forever call you Dirtbag.");
            disableFightButtons();
            gameResultLabel.setText("         You Lose!");
        }
        setLabels();
    }
    @FXML
    public void disableDungeonButtons(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++) {
                buttonLayout[i][j].setDisable(true);
            }
        }
    }
    @FXML
    public void enableDungeonButtons(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++) {
                buttonLayout[i][j].setDisable(false);
            }
        }
    }
    @FXML
    public void enableFightButtons(){
        attackButton.setDisable(false);
        healButton.setDisable(false);
    }
    @FXML
    public void disableFightButtons(){
        attackButton.setDisable(true);
        healButton.setDisable(true);
    }
    @FXML
    public void button00Pressed(){
        currentDungeon=dungeonMaze[0][0];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    @FXML
    public void button01Pressed(){
        currentDungeon=dungeonMaze[0][1];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button02Pressed(){
        currentDungeon=dungeonMaze[0][2];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button03Pressed(){
        currentDungeon=dungeonMaze[0][3];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button10Pressed(){
        currentDungeon=dungeonMaze[1][0];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button11Pressed(){
        currentDungeon=dungeonMaze[1][1];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button12Pressed(){
        currentDungeon=dungeonMaze[1][2];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button13Pressed(){
        currentDungeon=dungeonMaze[1][3];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button20Pressed(){
        currentDungeon=dungeonMaze[2][0];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button21Pressed(){
        currentDungeon=dungeonMaze[2][1];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button22Pressed(){
        currentDungeon=dungeonMaze[2][2];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button23Pressed(){
        currentDungeon=dungeonMaze[2][3];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button30Pressed(){
        currentDungeon=dungeonMaze[3][0];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button31Pressed(){
        currentDungeon=dungeonMaze[3][1];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button32Pressed(){
        currentDungeon=dungeonMaze[3][2];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("");
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    public void button33Pressed(){
        currentDungeon=dungeonMaze[3][3];
        opponent=currentDungeon.getFighter();
        opponentName.setText(opponent.getName());
        fightStatusLabel1.setText("You are in the "+currentDungeon.getName());
        fightStatusLabel2.setText("");
        //player.reset();
        setLabels();
        disableDungeonButtons();
        setButtons();
        if (!opponent.isAlive()){
            fightStatusLabel2.setText("You have already defeated the fighter in this dungeon. Please move on to an adjacent dungeon.");
        }
        else {
            enableFightButtons();
            fightStatusLabel1.setText("You are in "+currentDungeon.getName().toLowerCase()+". "+currentDungeon.getDescription());
            fightStatusLabel2.setText("You are fighting "+opponent.getName().toLowerCase()+": "+opponent.getDescription());
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        opponentImage.setImage(image);
        dungeonName.setText(currentDungeon.getName());
    }
    @FXML
    public void setLabels(){
        if (player.getHealth()>0) {
            playerLabel.setText("Health: " + player.getHealth() + "/" + player.getMaxHealth());
        }
        else{
            playerLabel.setText("Health: 0/"+player.getMaxHealth());
        }
        if (opponent.getHealth()>0) {
            opponentLabel.setText("Health: " + opponent.getHealth() + "/" + opponent.getMaxHealth());
        }
        else{
            opponentLabel.setText("Health: 0/"+opponent.getMaxHealth());
        }
        potionLabel.setText("Potions: "+player.getNumOfPotions());
    }
    public void setButtons(){
        resetButtonColors();
        if (currentDungeon==dungeonMaze[0][0]){
            buttonLayout[0][0].setStyle("-fx-background-color: #ff0000");
            buttonLayout[0][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][1].setDisable(false);
            buttonLayout[1][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][0].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[0][1]){
            buttonLayout[0][1].setStyle("-fx-background-color: #ff0000");
            buttonLayout[0][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][0].setDisable(false);
            buttonLayout[0][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][2].setDisable(false);
            buttonLayout[1][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][1].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[0][2]){
            buttonLayout[0][2].setStyle("-fx-background-color: #ff0000");
            buttonLayout[0][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][1].setDisable(false);
            buttonLayout[0][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][3].setDisable(false);
            buttonLayout[1][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][2].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[0][3]){
            buttonLayout[0][3].setStyle("-fx-background-color: #ff0000");
            buttonLayout[0][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][2].setDisable(false);
            buttonLayout[1][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][3].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[1][0]){
            buttonLayout[1][0].setStyle("-fx-background-color: #ff0000");
            buttonLayout[0][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][0].setDisable(false);
            buttonLayout[2][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][0].setDisable(false);
            buttonLayout[1][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][1].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[1][1]){
            buttonLayout[1][1].setStyle("-fx-background-color: #ff0000");
            buttonLayout[1][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][0].setDisable(false);
            buttonLayout[1][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][2].setDisable(false);
            buttonLayout[0][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][1].setDisable(false);
            buttonLayout[2][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][1].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[1][2]){
            buttonLayout[1][2].setStyle("-fx-background-color: #ff0000");
            buttonLayout[1][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][1].setDisable(false);
            buttonLayout[1][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][3].setDisable(false);
            buttonLayout[2][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][2].setDisable(false);
            buttonLayout[0][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][2].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[1][3]){
            buttonLayout[1][3].setStyle("-fx-background-color: #ff0000");
            buttonLayout[0][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[0][3].setDisable(false);
            buttonLayout[2][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][3].setDisable(false);
            buttonLayout[1][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][2].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[2][0]){
            buttonLayout[2][0].setStyle("-fx-background-color: #ff0000");
            buttonLayout[1][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][0].setDisable(false);
            buttonLayout[3][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][0].setDisable(false);
            buttonLayout[2][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][1].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[2][1]){
            buttonLayout[2][1].setStyle("-fx-background-color: #ff0000");
            buttonLayout[2][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][2].setDisable(false);
            buttonLayout[2][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][0].setDisable(false);
            buttonLayout[1][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][1].setDisable(false);
            buttonLayout[3][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][1].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[2][2]){
            buttonLayout[2][2].setStyle("-fx-background-color: #ff0000");
            buttonLayout[2][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][1].setDisable(false);
            buttonLayout[2][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][3].setDisable(false);
            buttonLayout[1][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][2].setDisable(false);
            buttonLayout[3][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][2].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[2][3]){
            buttonLayout[2][3].setStyle("-fx-background-color: #ff0000");
            buttonLayout[2][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][2].setDisable(false);
            buttonLayout[1][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[1][3].setDisable(false);
            buttonLayout[3][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][3].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[3][0]){
            buttonLayout[3][0].setStyle("-fx-background-color: #ff0000");
            buttonLayout[3][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][1].setDisable(false);
            buttonLayout[2][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][0].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[3][1]){
            buttonLayout[3][1].setStyle("-fx-background-color: #ff0000");
            buttonLayout[3][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][2].setDisable(false);
            buttonLayout[3][0].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][0].setDisable(false);
            buttonLayout[2][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][1].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[3][2]){
            buttonLayout[3][2].setStyle("-fx-background-color: #ff0000");
            buttonLayout[3][1].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][1].setDisable(false);
            buttonLayout[3][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][3].setDisable(false);
            buttonLayout[2][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][2].setDisable(false);
        }
        if (currentDungeon==dungeonMaze[3][3]){
            buttonLayout[3][3].setStyle("-fx-background-color: #ff0000");
            buttonLayout[3][2].setStyle("-fx-background-color: #ffa500");
            buttonLayout[3][2].setDisable(false);
            buttonLayout[2][3].setStyle("-fx-background-color: #ffa500");
            buttonLayout[2][3].setDisable(false);
        }
    }
    public void resetButtonColors(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++) {
                buttonLayout[i][j].setStyle("-fx-background-color: #ffff00");
            }
        }
    }
}
