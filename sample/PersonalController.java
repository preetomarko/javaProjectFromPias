package sample;

/**
 * Created by HP on 11/29/2015.
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.lang.Object;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PersonalController {

    private Main main;



    @FXML
    private TextField customerAddress;

    @FXML
    private TextField customerAge;

    @FXML
    private ComboBox<String> PaymentChoice;

    @FXML
    private TextField customerEmail;

    @FXML
    private Button customerInfoSubmission;

    @FXML
    private ComboBox<String> GenderChoice;

    @FXML
    private TextField customerMobile;

    @FXML
    private TextField customerName;

    @FXML
    private ImageView personalInfoImage;

    @FXML
    private ImageView personalInfoImage2;

    public PersonalInfo person;

    private String name;
    private String gender;
    private String paymetMethod;
    private String mobile;
    private String email;
    private String adress;
    private String age;
    private PersonalInfo customer;
    private PersonalDataStore ob;

    public  void initialize()
    {
        PaymentChoice.setPromptText("Bikash");
        PaymentChoice.setItems(FXCollections.observableArrayList("Bikash", "Master Card"));
        PaymentChoice.setTooltip(new Tooltip("Payment Method"));

        GenderChoice.setPromptText("Male");
        GenderChoice.setItems(FXCollections.observableArrayList("Male", "Female"));
        GenderChoice.setTooltip(new Tooltip("gender Choice"));


        PaymentChoice.setOnAction(e -> paymetMethod = PaymentChoice.getValue());
        GenderChoice.setOnAction(e -> gender = GenderChoice.getValue());
        //customerAddress.setOnAction();
        customerEmail.setOnAction(e -> email = customerEmail.getText());
        customerName.setOnAction(e-> name = customerName.getText());

        Image image3 = new Image(sample.Main.class.getResourceAsStream("submitButton.png"));
        customerInfoSubmission.setGraphic(new ImageView(image3));


    }

    @FXML
    void PaymentAction(ActionEvent event) {

    }


    @FXML
    void submit(ActionEvent event) throws Exception {

        System.out.println("Submitted");

        PersonalInfo customer = new PersonalInfo(customerName.getText(), customerMobile.getText(), customerAddress.getText(), customerEmail.getText(), customerAge.getText(), GenderChoice.getValue(), PaymentChoice.getValue());

        System.out.println(customer.getName());
        System.out.println(customer.getAddress());
        System.out.println(customer.getEmail());
        System.out.println(customer.getMobile());
        System.out.println(customer.getGender());
        System.out.println(customer.getPaymentMethod());

        ob = new PersonalDataStore(customer);

        this.customer=customer;

        try {
            main.showTicket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main){
        this.main = main;


        Image imagepersonal = new Image(sample.Main.class.getResourceAsStream("safeTravel.jpg"));
        personalInfoImage.setImage(imagepersonal);

        Image imagepersonal2 = new Image(sample.Main.class.getResourceAsStream("personalInfo2.jpg"));
        personalInfoImage2.setImage(imagepersonal2);
    }

}
