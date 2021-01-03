package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.GameController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {
  GameController controller = new GameController();
  private Label label = new Label();
  private Label labelEn = new Label();
  private Label labelinv = new Label();
  private static final String RESOURCE_PATH = "src/main/resources/";
  private Label equipped1 = new Label();
  private Label equipped2 = new Label();
  private Label equipped3 = new Label();
  private Label equipped4 = new Label();
  private Label equipped5 = new Label();
  private Label weapon1 = new Label();
  private Label weapon2 = new Label();
  private Label weapon3 = new Label();
  private Label weapon4 = new Label();
  private Label weapon5 = new Label();
  private int  cont1 =0, cont2 =0, cont3 =0, cont4 =0, cont5 =0;
  private Label info1 = new Label();
  private Label info2 = new Label();
  private Label info3 = new Label();
  private Label info4 = new Label();
  private Label info5 = new Label();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    primaryStage.setTitle("Final reality");
    Group root = new Group();
    var backgroundIn = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "fondo1.jpeg")));
    var backgroundSec = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "fondo2.jpeg")));
    var backgroundEq = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "fondo3.jpeg")));
    label.setLayoutX(10);
    label.setLayoutY(10);
    labelEn.setLayoutX(150);
    labelEn.setLayoutY(10);
    labelinv.setLayoutX(10);
    labelinv.setLayoutY(40);
    Group midRoot = CreateZone();
    Group rightRoot = CreateEquipZone();
    setUpTimer();
    Group newGroup = new Group();
    Label labelnew = new Label("new group");
    labelnew.setLayoutX(900);
    labelnew.setLayoutY(20);
    Button  buttonNew = new Button("Start");
    buttonNew.setLayoutX(710);
    buttonNew.setLayoutY(295);
    newGroup.getChildren().add(labelnew);
    newGroup.getChildren().add(backgroundSec);
    buttonNew.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {

        newGroup.getChildren().add(label);
        newGroup.getChildren().add(labelEn);
        newGroup.getChildren().add(labelinv);
        Group info = playersInfo();
        newGroup.getChildren().add(info);
        Scene sceneNew = new Scene(newGroup,1200,600);
        primaryStage.setScene(sceneNew);
        controller.startGame();

      }
    });
    //
    Group EquipGroup = new Group();
    Button  buttonEquip = new Button("Continue");
    buttonEquip.setLayoutX(330);
    buttonEquip.setLayoutY(150);
    EquipGroup.getChildren().add(backgroundEq);
    buttonEquip.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        EquipGroup.getChildren().add(label);
        EquipGroup.getChildren().add(labelEn);
        EquipGroup.getChildren().add(labelinv);
        Group players = equipping();
        EquipGroup.getChildren().add(players);
        EquipGroup.getChildren().add(buttonNew);
        Scene sceneNew = new Scene(EquipGroup,1200,600);
        primaryStage.setScene(sceneNew);

      }
    });
    //

    root.getChildren().add(backgroundIn);
    root.getChildren().add(label);
    root.getChildren().add(labelinv);
    root.getChildren().add(labelEn);
    root.getChildren().add(buttonEquip);
    root.getChildren().add(midRoot);
    root.getChildren().add(rightRoot);


    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(root, 1200, 600);

    primaryStage.setScene(scene);


    primaryStage.show();
  }

  private void setUpTimer() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        label.setText("Character Alive : " + controller.getAlivePlayers());
        labelEn.setText("Enemies Alive : " + controller.getAliveEnemies());
        labelinv.setText("Inventory Size : " + controller.getInventory().size());
      }
    };
    timer.start();
  }

  public Group CreateZone(){
    int xPos = 600;
    Group group = new Group();
    Label label3 =new Label("Insert Characters Names: \n Create 5");
    label3.setLayoutX(xPos);
    label3.setLayoutY(40);
    TextField name1 = new TextField();
    name1.setLayoutX(xPos);
    name1.setLayoutY(100);
    Button button1 = new Button("Create a Knight");
    button1.setLayoutX(xPos);
    button1.setLayoutY(140);
    button1.setFocusTraversable(false);
    button1.setOnAction((e)->controller.createKnight(name1.getText()));
    TextField name2 = new TextField();
    name2.setLayoutX(xPos);
    name2.setLayoutY(180);
    Button button2 = new Button("Create a Black Mage");
    button2.setLayoutX(xPos);
    button2.setLayoutY(220);
    button2.setFocusTraversable(false);
    button2.setOnAction((e)->controller.createBlackMage(name2.getText()));
    TextField name3 = new TextField();
    name3.setLayoutX(xPos);
    name3.setLayoutY(250);
    Button button3 = new Button("Create a Engineer");
    button3.setLayoutX(xPos);
    button3.setLayoutY(290);
    button3.setFocusTraversable(false);
    button3.setOnAction((e)->controller.createEngineer(name3.getText()));
    TextField name4 = new TextField();
    name4.setLayoutX(xPos);
    name4.setLayoutY(330);
    Button button4 = new Button("Create a Thief");
    button4.setLayoutX(xPos);
    button4.setLayoutY(370);
    button4.setFocusTraversable(false);
    button4.setOnAction((e)->controller.createThief(name4.getText()));
    TextField name5 = new TextField();
    name5.setLayoutX(xPos);
    name5.setLayoutY(410);
    Button button5 = new Button("Create a White Mage");
    button5.setLayoutX(xPos);
    button5.setLayoutY(450);
    button5.setFocusTraversable(false);
    button5.setOnAction((e)->controller.createWhiteMage(name5.getText()));
    group.getChildren().add(label3);
    group.getChildren().add(name1);
    group.getChildren().add(button1);
    group.getChildren().add(name2);
    group.getChildren().add(button2);
    group.getChildren().add(name3);
    group.getChildren().add(button3);
    group.getChildren().add(name4);
    group.getChildren().add(button4);
    group.getChildren().add(name5);
    group.getChildren().add(button5);

    return group;
  }
  public Group CreateEquipZone(){
    int xPos = 900;
    Group group = new Group();
    Label label3 = new Label("Choose your Weapons: ");
    label3.setLayoutX(xPos);
    label3.setLayoutY(40);
    TextField name1 = new TextField();
    name1.setLayoutX(xPos);
    name1.setLayoutY(100);
    Button button1 = new Button("Create an Axe");
    button1.setLayoutX(xPos);
    button1.setLayoutY(140);
    button1.setFocusTraversable(false);
    button1.setOnAction((e)->controller.createAxe(name1.getText()));
    TextField name2 = new TextField();
    name2.setLayoutX(xPos);
    name2.setLayoutY(180);
    Button button2 = new Button("Create a Bow");
    button2.setLayoutX(xPos);
    button2.setLayoutY(220);
    button2.setFocusTraversable(false);
    button2.setOnAction((e)->controller.createBow(name2.getText()));
    TextField name3 = new TextField();
    name3.setLayoutX(xPos);
    name3.setLayoutY(250);
    Button button3 = new Button("Create a Knife");
    button3.setLayoutX(xPos);
    button3.setLayoutY(290);
    button3.setFocusTraversable(false);
    button3.setOnAction((e)->controller.createKnife(name3.getText()));
    TextField name4 = new TextField();
    name4.setLayoutX(xPos);
    name4.setLayoutY(330);
    Button button4 = new Button("Create a Staff");
    button4.setLayoutX(xPos);
    button4.setLayoutY(370);
    button4.setFocusTraversable(false);
    button4.setOnAction((e)->controller.createStaff(name4.getText()));
    TextField name5 = new TextField();
    name5.setLayoutX(xPos);
    name5.setLayoutY(410);
    Button button5 = new Button("Create a Sword");
    button5.setLayoutX(xPos);
    button5.setLayoutY(450);
    button5.setFocusTraversable(false);
    button5.setOnAction((e)->controller.createSword(name5.getText()));
    group.getChildren().add(label3);
    group.getChildren().add(name1);
    group.getChildren().add(button1);
    group.getChildren().add(name2);
    group.getChildren().add(button2);
    group.getChildren().add(name3);
    group.getChildren().add(button3);
    group.getChildren().add(name4);
    group.getChildren().add(button4);
    group.getChildren().add(name5);
    group.getChildren().add(button5);

    return group;
  }
  public Group equipping(){
    Group group = new Group();
    int xPos = 350, xPos2 = xPos +250;
    int yPos = 50;
    int tope = controller.getInventory().size()-1;
    setUpTimer2();
    String name1 = controller.getCharacterName(controller.getPlayer(0));
    Label player1 = new Label("Player 1 : "+ name1);
    player1.setLayoutX(xPos);
    player1.setLayoutY(yPos);
    Button button1 = new Button("Equip Weapon: ");
    button1.setLayoutX(xPos2);
    button1.setLayoutY(yPos);
    button1.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.equip(controller.getPlayer(0),cont1);
        if (cont1<tope){
          cont1++;
        }
        else {
          cont1=0;
        }
      }
    });
    String name2 = controller.getCharacterName(controller.getPlayer(1));
    Label player2 = new Label("Player 2 : "+ name2);
    player2.setLayoutX(xPos);
    player2.setLayoutY(yPos+30);
    Button button2 = new Button("Equip Weapon: ");
    button2.setLayoutX(xPos2);
    button2.setLayoutY(yPos+30);
    button2.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.equip(controller.getPlayer(1),cont2);
        if (cont2<tope){
          cont2++;
        }
        else {
          cont2=0;
        }
      }
    });
    String name3 = controller.getCharacterName(controller.getPlayer(2));
    Label player3 = new Label("Player 3 : "+ name3);
    player3.setLayoutX(xPos);
    player3.setLayoutY(yPos+60);
    Button button3 = new Button("Equip Weapon: ");
    button3.setLayoutX(xPos2);
    button3.setLayoutY(yPos+60);
    button3.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.equip(controller.getPlayer(2), cont3);
        if (cont3 < tope) {
          cont3++;
        } else {
          cont3 = 0;
        }
      }
    });
    String name4 = controller.getCharacterName(controller.getPlayer(3));
    Label player4 = new Label("Player 4 : "+ name4);
    player4.setLayoutX(xPos);
    player4.setLayoutY(yPos+90);
    Button button4 = new Button("Equip Weapon: ");
    button4.setLayoutX(xPos2);
    button4.setLayoutY(yPos+90);
    button4.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.equip(controller.getPlayer(3), cont4);
        if (cont4 < tope) {
          cont4++;
        } else {
          cont4 = 0;
        }
      }
    });
    String name5 = controller.getCharacterName(controller.getPlayer(4));
    Label player5 = new Label("Player 5 : "+ name5);
    player5.setLayoutX(xPos);
    player5.setLayoutY(yPos+120);
    Button button5 = new Button("Equip Weapon: ");
    button5.setLayoutX(xPos2);
    button5.setLayoutY(yPos+120);
    button5.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.equip(controller.getPlayer(4), cont5);
        if (cont5 < tope) {
          cont5++;
        } else {
          cont5 = 0;
        }
      }
    });
    weapon1.setLayoutX(xPos2+180);
    weapon1.setLayoutY(yPos);
    equipped1.setLayoutX(xPos2+350);
    equipped1.setLayoutY(yPos);
    weapon2.setLayoutX(xPos2+180);
    weapon2.setLayoutY(yPos+30);
    equipped2.setLayoutX(xPos2+350);
    equipped2.setLayoutY(yPos+30);
    weapon3.setLayoutX(xPos2+180);
    weapon3.setLayoutY(yPos+60);
    equipped3.setLayoutX(xPos2+350);
    equipped3.setLayoutY(yPos+60);
    weapon4.setLayoutX(xPos2+180);
    weapon4.setLayoutY(yPos+90);
    equipped4.setLayoutX(xPos2+350);
    equipped4.setLayoutY(yPos+90);
    weapon5.setLayoutX(xPos2+180);
    weapon5.setLayoutY(yPos+120);
    equipped5.setLayoutX(xPos2+350);
    equipped5.setLayoutY(yPos+120);
    group.getChildren().add(player1);
    group.getChildren().add(player2);
    group.getChildren().add(player3);
    group.getChildren().add(player4);
    group.getChildren().add(player5);
    group.getChildren().add(button1);
    group.getChildren().add(button2);
    group.getChildren().add(button3);
    group.getChildren().add(button4);
    group.getChildren().add(button5);
    group.getChildren().add(weapon1);
    group.getChildren().add(weapon2);
    group.getChildren().add(weapon3);
    group.getChildren().add(weapon4);
    group.getChildren().add(weapon5);
    group.getChildren().add(equipped1);
    group.getChildren().add(equipped2);
    group.getChildren().add(equipped3);
    group.getChildren().add(equipped4);
    group.getChildren().add(equipped5);

    return group;
  }
  public void setUpTimer2(){
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        weapon1.setText( controller.getWeaponName(controller.getFromInventory(cont1)));
        weapon2.setText(controller.getWeaponName(controller.getFromInventory(cont2)));
        weapon3.setText(controller.getWeaponName(controller.getFromInventory(cont3)));
        weapon4.setText(controller.getWeaponName(controller.getFromInventory(cont4)));
        weapon5.setText(controller.getWeaponName(controller.getFromInventory(cont5)));
        if (controller.getEquippedWeapon(controller.getPlayer(0))!=null){
          equipped1.setText("Equipped: " + controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(0))));
        }
        else{
          equipped1.setText("No Weapon Equipped");
        }
        if (controller.getEquippedWeapon(controller.getPlayer(1))!=null){
          equipped2.setText("Equipped: " + controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(1))));
        }
        else{
          equipped2.setText("No Weapon Equipped");
        }
        if (controller.getEquippedWeapon(controller.getPlayer(2))!=null){
          equipped3.setText("Equipped: " + controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(2))));
        }
        else{
          equipped3.setText("No Weapon Equipped");
        }
        if (controller.getEquippedWeapon(controller.getPlayer(3))!=null){
          equipped4.setText("Equipped: " + controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(3))));
        }
        else{
          equipped4.setText("No Weapon Equipped");
        }
        if (controller.getEquippedWeapon(controller.getPlayer(4))!=null){
          equipped5.setText("Equipped: " + controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(4))));
        }
        else{
          equipped5.setText("No Weapon Equipped");
        }
      }
    };
    timer.start();
  }
  public Group playersInfo(){
    Group group = new Group();
    int xPos = 600;
    int yPos = 20;
    setUpTimer3();
    info1.setLayoutX(xPos);
    info1.setLayoutY(yPos);
    info2.setLayoutX(xPos);
    info2.setLayoutY(yPos+100);
    info3.setLayoutX(xPos+250);
    info3.setLayoutY(yPos);
    info4.setLayoutX(xPos+250);
    info4.setLayoutY(yPos+100);
    info5.setLayoutX(xPos+100);
    info5.setLayoutY(yPos+200);
    group.getChildren().add(info1);
    group.getChildren().add(info2);
    group.getChildren().add(info3);
    group.getChildren().add(info4);
    group.getChildren().add(info5);
    return group;
  }
  public void setUpTimer3(){
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        String name1 = controller.getCharacterName(controller.getPlayer(0));
        int hp1 = controller.getCharacterLife(controller.getPlayer(0));
        int dp1 = controller.getCharacterDp(controller.getPlayer(0));
        boolean status1 = controller.getCharacterStatus(controller.getPlayer(0));
        String nameW1 = controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(0)));
        info1.setText("Player 1: " + name1 + '\n' + "HP: " + hp1 + '\n' + "DP: " + dp1 + '\n' + "Alive? " + status1 + '\n' + "Weapon: " + nameW1);
        String name2 = controller.getCharacterName(controller.getPlayer(1));
        int hp2 = controller.getCharacterLife(controller.getPlayer(1));
        int dp2 = controller.getCharacterDp(controller.getPlayer(1));
        boolean status2 = controller.getCharacterStatus(controller.getPlayer(1));
        String nameW2 = controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(1)));
        info2.setText("Player 2: " + name2 + '\n' + "HP: " + hp2 + '\n' + "DP: " + dp2 + '\n' + "Alive? " + status2 + '\n' + "Weapon: " + nameW2);
        String name3 = controller.getCharacterName(controller.getPlayer(2));
        int hp3 = controller.getCharacterLife(controller.getPlayer(2));
        int dp3 = controller.getCharacterDp(controller.getPlayer(2));
        boolean status3 = controller.getCharacterStatus(controller.getPlayer(2));
        String nameW3 = controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(2)));
        info3.setText("Player 3: " + name3 + '\n' + "HP: " + hp3 + '\n' + "DP: " + dp3 + '\n' + "Alive? " + status3 + '\n' + "Weapon: " + nameW3);
        String name4 = controller.getCharacterName(controller.getPlayer(3));
        int hp4 = controller.getCharacterLife(controller.getPlayer(3));
        int dp4 = controller.getCharacterDp(controller.getPlayer(3));
        boolean status4 = controller.getCharacterStatus(controller.getPlayer(3));
        String nameW4 = controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(3)));
        info4.setText("Player 4: " + name4 + '\n' + "HP: " + hp4 + '\n' + "DP: " + dp4 + '\n' + "Alive? " + status4 + '\n' + "Weapon: " + nameW4);
        String name5 = controller.getCharacterName(controller.getPlayer(4));
        int hp5 = controller.getCharacterLife(controller.getPlayer(4));
        int dp5 = controller.getCharacterDp(controller.getPlayer(4));
        boolean status5 = controller.getCharacterStatus(controller.getPlayer(4));
        String nameW5 = controller.getWeaponName(controller.getEquippedWeapon(controller.getPlayer(4)));
        info5.setText("Player 5: " + name5 + '\n' + "HP: " + hp5 + '\n' + "DP: " + dp5 + '\n' + "Alive? " + status5 + '\n' + "Weapon: " + nameW5);
      }
    };
    timer.start();
  }
  }


