package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by USER on 12/16/2015.
 */
public class tableViewRow {
    private SimpleStringProperty date;
    private SimpleStringProperty timeOfDeparture;
    private SimpleStringProperty from;
    private SimpleStringProperty to;
    private SimpleStringProperty acNonAC;
    private Integer availableSeats;
    private SimpleStringProperty fare;
    public tableViewRow()
    {

    }
    public tableViewRow(String d,String tod,String f,String t,String acNac,int as,String fr)
    {
        date=new SimpleStringProperty(d);
        timeOfDeparture=new SimpleStringProperty(tod);
        from=new SimpleStringProperty(f);
        to=new SimpleStringProperty(t);
        acNonAC=new SimpleStringProperty(acNac);
        availableSeats=as;
        fare=new SimpleStringProperty(fr);
    }

    public String getDate()  {return date.get();}
    public String getTimeOfDeparture()  {return timeOfDeparture.get();}
    public String getFrom()  {return from.get();}
    public String getTo()  {return to.get();}
    public String getAcNonAC()  {return acNonAC.get();}
    public Integer getAvailableSeats()  {return availableSeats; }
    public String getFare()  {return fare.get();}

    public void setDate(String d) {date.set(d);}
    public void setTimeOfDeparture(String tod) {timeOfDeparture.set(tod); }
    public void setFrom(String f) {from.set(f); }
    public void setTo(String t) {to.set(t); }
    public void setAcNonAC(String acNac) {acNonAC.set(acNac);}
    public void setAvailableSeats(int avs) {availableSeats=avs;}
    public void setFare(String fr) {fare.set(fr);}


}
