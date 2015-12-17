package sample;

/**
 * Created by HP on 11/30/2015.
 */
public class PersonalInfo {
    private String name;
    private String mobile;
    private String address;
    private String email;
    private String gender;
    private String age;
    private String paymentMethod;
   private static PersonalInfo instance;
    PersonalDataStore ob;


    public PersonalInfo(String text, String text1, String text2, String text3, String text4, String text5, String text6) {
        this.name = text;
        this.mobile = text1;
        this.address = text2;
        this.email = text3;
        this.age = text4;
        this.gender = text5;
        this.paymentMethod = text6;
    }



    public PersonalInfo() {

    }


    public void setName(String s){
        this.name=s;
    }

    public static PersonalInfo getInstance() {
        return instance;
    }


    public String getName(){
        return name;
    }

    public String getMobile(){return mobile;}

    public String getAddress(){
        return address;
    }

    public String getGender(){
        return gender;
    }

    public String getEmail(){
        return email;
    }

    public String getAge(){
        return age;
    }

    public String getPaymentMethod() {return paymentMethod;}

}
