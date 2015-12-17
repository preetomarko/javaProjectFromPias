package sample;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by HP on 12/6/2015.
 */
public class SearchTicketInfo implements Serializable {

    private String starting;
    private String destination;
    private LocalDate date;
    private String coachType;

    public SearchTicketInfo(String x1, String x2, LocalDate x3, String x4){
        starting = x1;
        destination = x2;
        date = x3;
        coachType = x4;
    }

    public String getStarting(){return starting;}
    public String getDestination(){return destination;}
    public LocalDate getDate(){return date;}
    public String getCoachType(){return coachType;}
}
