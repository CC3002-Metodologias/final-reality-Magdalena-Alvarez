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
  private Label weapon1 = new Label();
  private Label weapon2 = new Label();
  private Label weapon3 = new Label();
  private Label weapon4 = new Label();
  private Label weapon5 = new Label();

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
        Scene sceneNew = new Scene(EquipGroup,1200,600);
        primaryStage.setScene(sceneNew);

      }
    });
    //
    Button  buttonNew = new Button("Start");
    buttonNew.setLayoutX(330);
    buttonNew.setLayoutY(150);
    newGroup.getChildren().add(labelnew);
    newGroup.getChildren().add(backgroundSec);
    buttonNew.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        newGroup.getChildren().add(label);
        newGroup.getChildren().add(labelEn);
        controller.startGame();
        Scene sceneNew = new Scene(newGroup,1200,600);
        primaryStage.setScene(sceneNew);

      }
    });
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
    Label label3 =new Label("Insert Characters Names: \n Only create 5");
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
    int xPos = 500, xPos2 = xPos +150;
    int yPos = 50;
    int  cont1 =0, cont2 =0, cont3 =0, cont4 =0, cont5 =0;
    String name1 = controller.getCharacterName(controller.getPlayer(0));
    Label player1 = new Label("Player 1 : "+ name1);
    player1.setLayoutX(xPos);
    player1.setLayoutY(yPos);
    Button button1 = new Button("Equip Weapon: ");
    button1.setLayoutX(xPos2);
    button1.setLayoutY(yPos);
    String name2 = controller.getCharacterName(controller.getPlayer(1));
    Label player2 = new Label("Player 2 : "+ name2);
    player2.setLayoutX(xPos);
    player2.setLayoutY(yPos+30);
    String name3 = controller.getCharacterName(controller.getPlayer(2));
    Label player3 = new Label("Player 3 : "+ name3);
    player3.setLayoutX(xPos);
    player3.setLayoutY(yPos+60);
    String name4 = controller.getCharacterName(controller.getPlayer(3));
    Label player4 = new Label("Player 4 : "+ name4);
    player4.setLayoutX(xPos);
    player4.setLayoutY(yPos+90);
    String name5 = controller.getCharacterName(controller.getPlayer(4));
    Label player5 = new Label("Player 5 : "+ name5);
    player5.setLayoutX(xPos);
    player5.setLayoutY(yPos+120);

    group.getChildren().add(player1);
    group.getChildren().add(player2);
    group.getChildren().add(player3);
    group.getChildren().add(player4);
    group.getChildren().add(player5);
    return group;
  }
  public void setUpTimer2(){
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        weapon1.setText("Character Alive : " + controller.getAlivePlayers());
        weapon2.setText("Enemies Alive : " + controller.getAliveEnemies());
        weapon3.setText("Inventory Size : " + controller.getInventory().size());
      }
    };
    timer.start();
  }
  }


