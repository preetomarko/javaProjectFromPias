// created and modified by ARKO on 10 december, at 2:40 pm

package sample;

import java.time.LocalDate;

import clientInfoPkg.clientInfo;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.Duration;
import networkUtil.*;
import clientInfoPkg.*;


public class homepageController {

    ObservableList<String> options =
            FXCollections.observableArrayList(
                    "Dhaka","Chittagong","Rajshahi","Khulna","Barisal","Sylhet","Rangpur"
            );

    //ObservableList<String> fromBoxList = FXCollections.observableArrayList();
    //ObservableList<String> toBoxList = FXCollections.observableArrayList();


    boolean toClicked= false;
    boolean fromClicked= false;
    boolean bothClicked= false;
    String toCombo;
    String fromCombo;
    String lastClicked;

    String validPassword = "123";
    String validUserID = "abcd";

    clientInfo c;

    @FXML
    TabPane menuTabPane;

    @FXML
    Tab homeMenu;

    @FXML
    Tab buyTktMenu;

    @FXML
    Tab cancelTktMenu;

    @FXML
    Tab availableRouteMenu;

    @FXML
    Tab FAQmenu;

    @FXML
    Tab creditsMenu;

    @FXML
    private TextField adminUserID;

    @FXML
    private PasswordField adminPassword;

    @FXML
    ComboBox fromComboBox;

    @FXML
    ComboBox toComboBox;

    @FXML
    private DatePicker datePick;

    @FXML
    private RadioButton ACradioButton;

    @FXML
    private RadioButton nonACradioButton;

    @FXML
    private ImageView bkash;

    @FXML
    private ImageView sureCash;

    @FXML
    private ImageView DBBL;

    @FXML
    private ImageView masterCard;

    @FXML
    private ImageView visa;

    @FXML
    private Button tktSearch;

    @FXML
    private Button adminLoginButton;

    @FXML
    private Label alert;  // initially, this label's setVisible() has been made false in the fxml
    // this will be visible only when an alert is needed

    @FXML
    void ACradioButtonClick(ActionEvent event) {
        /*
        if(!c.isAc())c.setAC(true);
        else c.setAC(false);
        */
        //c.setAC(ACradioButton.isSelected());
        ACradioButton.requestFocus();
    }

    @FXML
    void nonACradioButtonClick(ActionEvent event) {
        /*
        if(!c.isNonAC())c.setNonAC(true);
        else c.setAC(false);
        */
        //c.setNonAC(nonACradioButton.isSelected());
        nonACradioButton.requestFocus();
    }


//    @FXML
//    void FAQmenuAction(ActionEvent event) {
//
//    }
//
//    @FXML
//    void adminPasswordTakeAction(ActionEvent event) {
//
//    }
//
//    @FXML
//    void adminUserIDtakeAction(ActionEvent event) {
//
//    }
//
//    @FXML
//    void availableRouteMenuAction(ActionEvent event) {
//
//    }
//
//    @FXML
//    void buyTktMenuAction(ActionEvent event) {
//        try{
//            main.showHomepage();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void cancelTktMenuAction(ActionEvent event) {
//
//    }
//
//    @FXML
//    void creditsMenuAction(ActionEvent event) {
//
//    }

    @FXML
    void datePickAction(ActionEvent event) {
        System.out.println(datePick.getValue());   // type: LocalDate
        //System.out.println(datePick.getValue().getClass());



    }

//    @FXML
//    void homeMenuAction(ActionEvent event) {
//
//    }


    @FXML
    void searchTktButton(ActionEvent event) {
        // send a request to server for searching a ticket from database

        c.setDate(datePick.getValue());
        c.setAC(ACradioButton.isSelected());
        c.setNonAC(nonACradioButton.isSelected());
        if( allOptionsFilledUp() ){
            try{
                main.availableBusView();
            }
            catch (Exception e){
                e.printStackTrace();
            }


            /*
            try {
                //String serverAddress="127.0.0.1";
                //int serverPort=55555;
                //NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);

                //nc.write(c);

            } catch(Exception e) {
                System.out.println (e);
            }
            */

        }

        else{
            alert.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(
                    Duration.seconds(2)
            ); // making the "alert" label visible for 2 seconds
            visiblePause.setOnFinished(
                    Event -> alert.setVisible(false)
            );
            visiblePause.play();
        }

    }

    @FXML
    void fromComboBoxAction(ActionEvent event) {
        //fromComboBox.setItems(options);
        /*
        if(fromClicked && toClicked && !lastClicked.equals("from")){
            fromBoxList.setAll(options);
            toBoxList.setAll(options);
            toClicked=false;
            System.out.println("both combo box has been clicked");
        }
        */


        /*System.out.println("now fromBoxList of size "+ fromBoxList.size()+ " will be setAll()");
        fromComboBox.setItems(fromBoxList);
        */

        //fromComboBox=new ComboBox(fromBoxList);
        String s=(String)fromComboBox.getValue();
        c.setFrom(s);

        if(fromComboBox.getValue()==toComboBox.getValue()){
            toComboBox.getSelectionModel().clearSelection();   // to clear the selected option in the other combo box, because the starting point and destination can't be the same
            c.setTo(null);
            //toComboBox.setButtonCell(null);
            //toComboBox.valueProperty().set(null);
            //toComboBox.getSelectionModel().clearSelection();
        }

                    //System.out.println(s.getClass());
                    //System.out.println(s);
        System.out.println("from "+s);

        //temp.remove(s);
        /*
        fromClicked=true;
        fromCombo=s;
        lastClicked="from";
        //options.removeAll(s);
        if(fromClicked && !toClicked){
            toBoxList.remove(fromCombo);
            System.out.println("removing "+fromCombo+" from the list and after removing, the size of the toBoxList= "+toBoxList.size());
            toComboBox.setItems(toBoxList);
        }
        */
    }

    @FXML
    void toComboBoxAction(ActionEvent event) {
        //toComboBox.setItems(options);
        /*
        if(fromClicked && toClicked && !lastClicked.equals("to")){
            fromBoxList.setAll(options);
            toBoxList.setAll(options);
            fromClicked=false;
            System.out.println("both combo box has been clicked");
        }
        */

        /*
        System.out.println("now toBoxList of size "+ toBoxList.size()+ " will be setAll()");
        toComboBox.setItems(toBoxList);
        */
        //toComboBox=new ComboBox(toBoxList);
        String s=(String)toComboBox.getValue();
        c.setTo(s);

        if(fromComboBox.getValue()==toComboBox.getValue()){
            //fromComboBox.setButtonCell(null);
            //fromComboBox.valueProperty().set(null);
            fromComboBox.getSelectionModel().clearSelection();// to clear the selected option in the other combo box, because the starting point and destination can't be the same
            c.setFrom(null);
        }

        System.out.println("to "+s);

        /*
        toClicked=true;
        toCombo=s;
        lastClicked="to";
        //options.removeAll(s);
        if(toClicked && !fromClicked){
            fromBoxList.remove(toCombo);
            System.out.println("removing "+toCombo+" from the list and after removing, the size of the fromBoxlist= "+fromBoxList.size());
            fromComboBox.setItems(fromBoxList);
        }
        */
    }

    @FXML
    void adminPasswordTakeAction(ActionEvent event) {

    }

    @FXML
    void adminUserIDtakeAction(ActionEvent event) {

    }

    @FXML
    void adminLoginAction(ActionEvent event) {
        if(adminUserID.getText().equals(validUserID) && adminPassword.getText().equals(validPassword)){
            try{
                main.AdminEdit();
            }catch(Exception e){e.printStackTrace();}
        }
    }

    boolean allOptionsFilledUp()
    {
        if(c.getFrom()!=null && c.getTo()!=null && c.getD()!=null && (c.isAc() || c.isNonAC())){
            return true;
        }
        return false;
        //if any one of the options has not been selected, this function will return false and the client will be stuck in the homepage
    }

//    public static TermProjectMain main;
//
//    public static void setMain(TermProjectMain m) {main = m;}

    public static Main main;

    public static void setMain(Main m) {main = m;}
    
    public void init()
    {
        /*
        Image img1 = new Image(TermProjectMain.class.getResourceAsStream("bkash.png"));
        bkash.setImage(img1);
        Image img2 = new Image(TermProjectMain.class.getResourceAsStream("sure cash.png"));
        sureCash.setImage(img2);
        Image img3 = new Image(TermProjectMain.class.getResourceAsStream("dutch bangla.png"));
        DBBL.setImage(img3);
        Image img4 = new Image(TermProjectMain.class.getResourceAsStream("mastercard.png"));
        masterCard.setImage(img4);
        Image img5 = new Image(TermProjectMain.class.getResourceAsStream("visa.png"));
        visa.setImage(img5);
        */

        //fromBoxList.setAll(options);
        //toBoxList.setAll(options);
        //fromComboBox.getItems().addAll(fromBoxList);
        c=new clientInfo();

        fromComboBox.getItems().addAll(options);

        //toComboBox.getItems().addAll(toBoxList);
        toComboBox.getItems().addAll(options);

        fromComboBox.setVisibleRowCount(4);
        toComboBox.setVisibleRowCount(4);

        // the code fragment below ensures that no day before today is selected from the datePicker by disabling the selecting option for those days and marking them in pink color
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isBefore(LocalDate.now())) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        datePick.setDayCellFactory(dayCellFactory);
        datePick.setEditable(false);

        final ToggleGroup group = new ToggleGroup();
        ACradioButton.setToggleGroup(group);
        nonACradioButton.setToggleGroup(group);

    }


}
