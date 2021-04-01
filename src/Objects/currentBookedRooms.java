
package Objects;

import java.time.LocalDate;
import java.time.LocalTime;


public class currentBookedRooms {
    
    private int roomNumber;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public currentBookedRooms(int roomNumber, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.roomNumber = roomNumber;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
    
    
    
    
}
