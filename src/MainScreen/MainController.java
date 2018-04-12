package MainScreen;

import Utility.SwichWindow;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {
    /*Menu bar*/
    @FXML
    public JFXHamburger MenuButton;
    private SwichWindow swich = new SwichWindow();
    @FXML
    private AnchorPane MainScreen;
    @FXML
    private JFXDrawer MenuDrawer;

    private void Menu() throws IOException {
        VBox box = FXMLLoader.load(getClass().getResource("/MainScreen/Menu/Menu.fxml"));
        MenuDrawer.setSidePane(box);
    }

    private void MenuButtonControll() {
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(MenuButton);
        transition.setRate(-1);
        MenuButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (MenuDrawer.isShown()) {
                MenuDrawer.close();
            } else MenuDrawer.open();
        });
    }

    private void righter() {
        CheckBox box = new CheckBox();
        box.setSelected(true);    
/*        for (int i=0;i<=1;i++){
            if (i<10){
                System.out.println("Minuts.getItems().add(\"0"+i+"\");");
            }else {
            System.out.println("Minuts.getItems().add(\""+i+"\");");}
        }*/
    }

    /*Starter Method*/
    @FXML
    public void initialize() throws IOException {
        Menu();
        MenuButtonControll();
        righter();
    }
}
