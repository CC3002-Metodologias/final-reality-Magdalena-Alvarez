package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.gui.nodes.MovableNode;
import com.github.cc3002.finalreality.gui.nodes.MovableNodeBuilder;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
  private Button button1 = new Button();
  private Button button2 = new Button();
  private Button button3 = new Button();
  private Button button5 = new Button();
  private Button button4 = new Button();
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
  private Label inTurn = new Label();
  private Label info1e = new Label();
  private Label info2e = new Label();
  private Label info3e = new Label();
  private Label info4e = new Label();
  private Label info5e = new Label();
  private Group Vicg = new Group();
  private Label vicL = new Label("You win");
  private Scene secene;
  private Scene loseScene ;
  private MovableNode sprite ;
  private ArrayList<ImageView> imges = new ArrayList<ImageView>();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    primaryStage.setTitle("Final reality");
    Group root = new Group();
    var backgroundIn = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "fondo1.jpeg")));
    var backgroundSec = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "back1.jpg")));
    var backgroundEq = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "fondo3.jpeg")));
    var backgroundVic = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "victory.gif")));
    var backgroundlost = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "defeat.gif")));
    var img1 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite1.gif")));
    var img2 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite2.gif")));
    var img3 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite3.gif")));
    var img4 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite4.gif")));
    var img5 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite5.gif")));
    var imgEn1 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "venom2.gif")));
    var imgEn2 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "venom2.gif")));
    var imgEn3 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "venom2.gif")));
    var imgEn4 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "venom2.gif")));
    var imgEn5 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "venom2.gif")));
    var img1G = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite1.gif")));
    var img2G = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite2.gif")));
    var img3G = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite3.gif")));
    var img4G = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite4.gif")));
    var img5G = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sprite5.gif")));
    var imgEnG = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "venom2.gif")));
    int size = 200;
    int xG=200;
    int yG = 450;
    img1G.setFitHeight(size);
    img1G.setFitWidth(size);
    img1G.setLayoutX(xG);
    img1G.setLayoutY(yG);
    img2G.setFitHeight(size);
    img2G.setFitWidth(size);
    img2G.setLayoutX(xG);
    img2G.setLayoutY(yG);
    img3G.setFitHeight(size);
    img3G.setFitWidth(size);
    img3G.setLayoutX(xG);
    img3G.setLayoutY(yG);
    img4G.setLayoutX(xG);
    img4G.setLayoutY(yG);
    img4G.setFitHeight(size);
    img4G.setFitWidth(size);
    img5G.setFitHeight(size);
    img5G.setFitWidth(size);
    img5G.setLayoutX(xG);
    img5G.setLayoutY(yG);
    imgEnG.setFitHeight(size);
    imgEnG.setFitWidth(size);
    imgEnG.setLayoutX(xG+800);
    imgEnG.setLayoutY(yG);

    imges.add(img1G);
    imges.add(img2G);
    imges.add(img3G);
    imges.add(img4G);
    imges.add(img5G);

    backgroundSec.setFitWidth(1500);
    backgroundSec.setFitHeight(700);
    int delta = 80;
    int x=5;
    int y=100;
    img1.setFitHeight(delta);
    img1.setFitWidth(delta);
    img1.setLayoutX(x);
    img1.setLayoutY(y);

    img2.setFitHeight(delta);
    img2.setFitWidth(delta);
    img2.setLayoutX(x);
    img2.setLayoutY(y+90);

    img3.setFitHeight(delta);
    img3.setFitWidth(delta);
    img3.setLayoutX(x+250);
    img3.setLayoutY(y);

    img4.setFitHeight(delta);
    img4.setFitWidth(delta);
    img4.setLayoutX(x+250);
    img4.setLayoutY(y+90);

    img5.setFitHeight(delta);
    img5.setFitWidth(delta);
    img5.setLayoutX(x+80);
    img5.setLayoutY(y+180);

    imgEn1.setFitHeight(delta);
    imgEn1.setFitWidth(delta);
    imgEn1.setLayoutX(x+1000);
    imgEn1.setLayoutY(y);
    imgEn2.setFitHeight(delta);
    imgEn2.setFitWidth(delta);
    imgEn2.setLayoutX(x+1000);
    imgEn2.setLayoutY(y+90);
    imgEn3.setFitHeight(delta);
    imgEn3.setFitWidth(delta);
    imgEn3.setLayoutX(x+1250);
    imgEn3.setLayoutY(y);
    imgEn4.setFitHeight(delta);
    imgEn4.setFitWidth(delta);
    imgEn4.setLayoutX(x+1250);
    imgEn4.setLayoutY(y+90);
    imgEn5.setFitHeight(delta);
    imgEn5.setFitWidth(delta);
    imgEn5.setLayoutX(x+1080);
    imgEn5.setLayoutY(y+180);
    vicL.setLayoutX(50);
    vicL.setLayoutY(50);
    label.setLayoutX(10);
    label.setLayoutY(10);
    labelEn.setLayoutX(150);
    labelEn.setLayoutY(10);
    labelinv.setLayoutX(10);
    labelinv.setLayoutY(40);
    Group midRoot = CreateZone();
    Group rightRoot = CreateEquipZone();
    Group loseG = new Group();
    Label lose = new Label("you lost");
    lose.setLayoutX(150);
    lose.setLayoutY(50);
    loseG.getChildren().add(backgroundlost);
    lose.setFont(Font.font("Verdana",30));
    lose.setTextFill(Color.WHITE);
    loseG.getChildren().add(lose);
    Vicg.getChildren().add(backgroundVic);
    vicL.setFont(Font.font("Verdana",30));
    vicL.setTextFill(Color.WHITE);
    Vicg.getChildren().add(vicL);
    secene = new Scene(Vicg,450,500);
    loseScene = new Scene(loseG,480,280);
    setUpTimer(primaryStage);
    Group newGroup = new Group();
    Label labelnew = new Label("new group");
    labelnew.setLayoutX(900);
    labelnew.setLayoutY(20);
    Button  buttonNew = new Button("Start");
    buttonNew.setLayoutX(710);
    buttonNew.setLayoutY(295);
    newGroup.getChildren().add(labelnew);
    newGroup.getChildren().add(backgroundSec);
    newGroup.getChildren().add(img1);
    newGroup.getChildren().add(img2);
    newGroup.getChildren().add(img3);
    newGroup.getChildren().add(img4);
    newGroup.getChildren().add(img5);
    newGroup.getChildren().add(imgEn1);
    newGroup.getChildren().add(imgEn2);
    newGroup.getChildren().add(imgEn3);
    newGroup.getChildren().add(imgEn4);
    newGroup.getChildren().add(imgEn5);
    newGroup.getChildren().add(imgEnG);
    buttonNew.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        newGroup.getChildren().add(label);
        newGroup.getChildren().add(labelEn);
        newGroup.getChildren().add(labelinv);
        Group info = playersInfo();
        newGroup.getChildren().add(info);
        Scene sceneNew2 = new Scene(newGroup, 1500, 700);
        primaryStage.setScene(sceneNew2);
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

  private void setUpTimer(Stage stage) {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        label.setText("Character Alive : " + controller.getAlivePlayers());
        labelEn.setText("Enemies Alive : " + controller.getAliveEnemies());
        labelinv.setText("Inventory Size : " + controller.getInventory().size());
        if (controller.isFinished()) {
          if (controller.getResult()) {
            stage.setScene(secene);
          } else {
            stage.setScene(loseScene);
          }
        }
      }
    };
    timer.start();
  }

  public Group CreateZone(){

    int xPos = 600;
    SetUpTimer4();
    Group group = new Group();
    Label label3 =new Label("Insert Characters Names: \n Create 5");
    label3.setLayoutX(xPos);
    label3.setLayoutY(40);
    TextField name1 = new TextField();
    name1.setLayoutX(xPos);
    name1.setLayoutY(100);
    button1 = new Button("Create a Knight");
    button1.setLayoutX(xPos);
    button1.setLayoutY(140);
    button1.setFocusTraversable(false);
    button1.setOnAction((e)->controller.createKnight(name1.getText()));
    TextField name2 = new TextField();
    name2.setLayoutX(xPos);
    name2.setLayoutY(180);
    button2 = new Button("Create a Black Mage");
    button2.setLayoutX(xPos);
    button2.setLayoutY(220);
    button2.setFocusTraversable(false);
    button2.setOnAction((e)->controller.createBlackMage(name2.getText()));
    TextField name3 = new TextField();
    name3.setLayoutX(xPos);
    name3.setLayoutY(250);
    button3 = new Button("Create a Engineer");
    button3.setLayoutX(xPos);
    button3.setLayoutY(290);
    button3.setFocusTraversable(false);
    button3.setOnAction((e)->controller.createEngineer(name3.getText()));
    TextField name4 = new TextField();
    name4.setLayoutX(xPos);
    name4.setLayoutY(330);
     button4 = new Button("Create a Thief");
    button4.setLayoutX(xPos);
    button4.setLayoutY(370);
    button4.setFocusTraversable(false);
    button4.setOnAction((e)->controller.createThief(name4.getText()));
    TextField name5 = new TextField();
    name5.setLayoutX(xPos);
    name5.setLayoutY(410);
    button5 = new Button("Create a White Mage");
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

  public void SetUpTimer4(){
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
      if(controller.getAlivePlayers()>=5){
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
      }

      }
    };
    timer.start();
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
    int xPos = 80;
    int yPos = 100;
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
    info1e.setLayoutX(xPos+1000);
    info1e.setLayoutY(yPos);
    info2e.setLayoutX(xPos+1000);
    info2e.setLayoutY(yPos+100);
    info3e.setLayoutX(xPos+1250);
    info3e.setLayoutY(yPos);
    info4e.setLayoutX(xPos+1250);
    info4e.setLayoutY(yPos+100);
    info5e.setLayoutX(xPos+1100);
    info5e.setLayoutY(yPos+200);
    Group buttons = gameButtons();
    group.getChildren().add(buttons);
    group.getChildren().add(info1);
    group.getChildren().add(info2);
    group.getChildren().add(info3);
    group.getChildren().add(info4);
    group.getChildren().add(info5);
    group.getChildren().add(info1e);
    group.getChildren().add(info2e);
    group.getChildren().add(info3e);
    group.getChildren().add(info4e);
    group.getChildren().add(info5e);
    return group;
  }
  public Group gameButtons(){
    Group group;
    group = new Group();
    int x = 600;
    int y = 80;
    setUpTimer3();
    inTurn.setLayoutX(x);
    inTurn.setLayoutY(y);
    Button startTurn = new Button("Start Turn");
    startTurn.setLayoutX(x);
    startTurn.setLayoutY(y+30);
    Button contTheGame = new Button(" Continue the Game");
    contTheGame.setLayoutX(x+50);
    contTheGame.setLayoutY(y+90);
    contTheGame.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        group.getChildren().remove(0,group.getChildren().size());
        group.getChildren().add(inTurn);
        group.getChildren().add(startTurn);
      }
    });
    Label choseEn = new Label("Choose an Enamy number");
    choseEn.setLayoutX(x);
    choseEn.setLayoutY(y+150);
    Button rtoAtt= new Button("Ready to Attack");
    rtoAtt.setLayoutX(x+50);
    rtoAtt.setLayoutY(y+250);
    TextField targNum = new TextField();
    targNum.setLayoutX(x);
    targNum.setLayoutY(y+200);
    rtoAtt.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.selectTarget(controller.getEnemy(Integer.parseInt(targNum.getText())));
        controller.toAttack();
        group.getChildren().remove(0,group.getChildren().size());
        group.getChildren().add(inTurn);
        group.getChildren().add(startTurn);
      }
    });
    Label invText = new Label("Enter a number between 0 & " + (controller.getInventory().size()-1));
    invText.setLayoutX(x);
    invText.setLayoutY(y+30);
    Label enText = new Label("An enemy played it's turn ");
    enText.setLayoutX(x);
    enText.setLayoutY(y+30);
    TextField numWeapon = new TextField();
    numWeapon.setLayoutX(x);
    numWeapon.setLayoutY(y+60);
    Button choose = new Button("Choose Weapon");
    choose.setLayoutX(x+30);
    choose.setLayoutY(y+90);
    choose.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.goToInventory(Integer.parseInt(numWeapon.getText()));
      }
    });

    startTurn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.startTurn();
        //startTurn.setDisable(true);
        group.getChildren().remove(startTurn);

        if (controller.isAPlayer()){
          int index = controller.getParty().indexOf(controller.getPlayingChar());
          group.getChildren().add(imges.get(index));
          controller.getPlayingChar().decision();
          group.getChildren().add(invText);
          group.getChildren().add(numWeapon);
          group.getChildren().add(choose);
          group.getChildren().add(targNum);
          group.getChildren().add(choseEn);
          group.getChildren().add(rtoAtt);
        }
        else {
          group.getChildren().add(enText);
          controller.getPlayingChar().decision();
          try {
            Thread.sleep(3000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }


          group.getChildren().add(contTheGame);

        }
      }
    });

    group.getChildren().add(inTurn);
    group.getChildren().add(startTurn);
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
        inTurn.setText("Now is playing: "+ controller.getPlayingCharName());
        String name1e = controller.getCharacterName(controller.getEnemy(0));
        int hp1e = controller.getCharacterLife(controller.getEnemy(0));
        int dp1e = controller.getCharacterDp(controller.getEnemy(0));
        boolean status1e = controller.getCharacterStatus(controller.getEnemy(0));
        int W1e = controller.getWeight((controller.getEnemy(0)));
        info1e.setText("Enemy 1: " + name1e + '\n' + "HP: " + hp1e + '\n' + "DP: " + dp1e + '\n' + "Alive? " + status1e + '\n' + "Weapon: " + W1e);
        String name2e = controller.getCharacterName(controller.getEnemy(1));
        int hp2e = controller.getCharacterLife(controller.getEnemy(1));
        int dp2e = controller.getCharacterDp(controller.getEnemy(1));
        boolean status2e = controller.getCharacterStatus(controller.getPlayer(1));
        int W2e = controller.getWeight((controller.getEnemy(1)));
        info2e.setText("Enemy 2: " + name2e + '\n' + "HP: " + hp2e + '\n' + "DP: " + dp2e + '\n' + "Alive? " + status2e + '\n' + "Weapon: " + W2e);
        String name3e = controller.getCharacterName(controller.getEnemy(2));
        int hp3e = controller.getCharacterLife(controller.getEnemy(2));
        int dp3e = controller.getCharacterDp(controller.getEnemy(2));
        boolean status3e = controller.getCharacterStatus(controller.getEnemy(2));
        int W3e = controller.getWeight((controller.getEnemy(2)));
        info3e.setText("Enemy 3: " + name3e + '\n' + "HP: " + hp3e + '\n' + "DP: " + dp3e + '\n' + "Alive? " + status3e + '\n' + "Weapon: " + W3e);
        String name4e = controller.getCharacterName(controller.getEnemy(3));
        int hp4e = controller.getCharacterLife(controller.getEnemy(3));
        int dp4e = controller.getCharacterDp(controller.getEnemy(3));
        boolean status4e = controller.getCharacterStatus(controller.getEnemy(3));
        int W4e = controller.getWeight((controller.getEnemy(3)));
        info4e.setText("Enemy 4: " + name4e + '\n' + "HP: " + hp4e + '\n' + "DP: " + dp4e + '\n' + "Alive? " + status4e + '\n' + "Weight: " + W4e);
        String name5e = controller.getCharacterName(controller.getEnemy(4));
        int hp5e = controller.getCharacterLife(controller.getEnemy(4));
        int dp5e = controller.getCharacterDp(controller.getEnemy(4));
        boolean status5e = controller.getCharacterStatus(controller.getEnemy(4));
        int W5e = controller.getWeight((controller.getEnemy(4)));
        info5e.setText("Enemy 5: " + name5e + '\n' + "HP: " + hp5e + '\n' + "DP: " + dp5e + '\n' + "Alive? " + status5e + '\n' + "Weight: " + W5e);
      }
    };
    timer.start();
  }
  

  
  }


