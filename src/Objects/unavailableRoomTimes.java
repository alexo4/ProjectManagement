
package Objects;

import java.time.LocalTime;

import libraryFunctions.*;

public class unavailableRoomTimes {
    
    private LocalTime unavailableStartTime;
    private LocalTime unavailableEndTime;
    private int unavailableRoomNumber;

    public unavailableRoomTimes(LocalTime unavailableStartTime, LocalTime unavailableEndTime, int unavailableRoomNumber) {
        this.unavailableStartTime = unavailableStartTime;
        this.unavailableEndTime = unavailableEndTime;
        this.unavailableRoomNumber = unavailableRoomNumber;
    }

    public LocalTime getUnavailableStartTime() {
        return unavailableStartTime;
    }

    public LocalTime getUnavailableEndTime() {
        return unavailableEndTime;
    }

    public int getUnavailableRoomNumber() {
        return unavailableRoomNumber;
    }

    public void setUnavailableStartTime(LocalTime unavailableStartTime) {
        this.unavailableStartTime = unavailableStartTime;
    }

    public void setUnavailableEndTime(LocalTime unavailableEndTime) {
        this.unavailableEndTime = unavailableEndTime;
    }

    public void setUnavailableRoomNumber(int unavailableRoomNumber) {
        this.unavailableRoomNumber = unavailableRoomNumber;
    }

    
   
    
    
    
    
}
