
package Objects;

import java.time.LocalDate;
import java.time.LocalTime;

import libraryFunctions.*;

public class Room implements iPrintable{
    
    private String emailAddress;
    private int roomNumber;
    private LocalDate bookedDate;
    private LocalTime bookedStartTime;
    private LocalTime bookedEndTime;
    private String organiserID;
    private String roomID;

    public Room(String emailAddress, int roomNumber, LocalDate bookedDate, LocalTime bookedStartTime, LocalTime bookedEndTime, String organiserID, String roomID) {
        this.emailAddress = emailAddress;
        this.roomNumber = roomNumber;
        this.bookedDate = bookedDate;
        this.bookedStartTime = bookedStartTime;
        this.bookedEndTime = bookedEndTime;
        this.organiserID = organiserID;
        this.roomID = roomID;
    }
    

   
    
    
    
    @Override
    public String getPrintableString(){
        return "Email Address: "+emailAddress+" Organiser's ID: "+organiserID+" Room ID: "+roomID+" Room Number: "+roomNumber+" Date Booked: "+bookedStartTime+"-"+bookedEndTime+" "+bookedDate;
        
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getBookedDate() {
        return bookedDate;
    }

    public LocalTime getBookedStartTime() {
        return bookedStartTime;
    }

    public LocalTime getBookedEndTime() {
        return bookedEndTime;
    }

    public String getOrganiserID() {
        return organiserID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBookedDate(LocalDate bookedDate) {
        this.bookedDate = bookedDate;
    }

    public void setBookedStartTime(LocalTime bookedStartTime) {
        this.bookedStartTime = bookedStartTime;
    }

    public void setBookedEndTime(LocalTime bookedEndTime) {
        this.bookedEndTime = bookedEndTime;
    }

    public void setOrganiserID(String organiserID) {
        this.organiserID = organiserID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
    
    
}
