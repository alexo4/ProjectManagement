
package roomBookingClasses;

import static GUIs.roomBooking.bookedDate;
import static GUIs.roomBooking.bookedEndTime;
import static GUIs.roomBooking.bookedStartTime;
import static GUIs.roomBooking.numOfPeople;
import static GUIs.roomBooking.unavailableRooms;
import Objects.Room;
import Objects.unavailableRoomTimes;
import java.util.ArrayList;
import libraryFunctions.repository;


public class availableRooms {
    
    public static ArrayList<unavailableRoomTimes> availableRoomsCheck(){
        ArrayList<unavailableRoomTimes> unavailableRooms = new ArrayList<>();
        
        ArrayList<Room> roomBookingList = repository.getAllRoomBookings();
        
        
        for (int i = 0; i < roomBookingList.size(); i++) {
            if(roomBookingList.get(i).getBookedDate().equals(bookedDate) && ((bookedStartTime.isAfter(roomBookingList.get(i).getBookedStartTime().minusMinutes(30)) && bookedStartTime.isBefore(roomBookingList.get(i).getBookedEndTime().plusMinutes(30))) || (bookedEndTime.isAfter(roomBookingList.get(i).getBookedStartTime().minusMinutes(30)) && bookedEndTime.isBefore(roomBookingList.get(i).getBookedEndTime().plusMinutes(30))))){

                unavailableRoomTimes rt = new unavailableRoomTimes(roomBookingList.get(i).getBookedStartTime(), roomBookingList.get(i).getBookedEndTime(),roomBookingList.get(i).getRoomNumber());
                unavailableRooms.add(rt);
            }
        }
        
        return unavailableRooms;
    }
    
    public static ArrayList<Integer> bestRoomCheck(){
        ArrayList<Integer> availableRoomsArray = new ArrayList<>();
        ArrayList<Integer> tempUnavailableRooms = new ArrayList<>();
        
        if(numOfPeople < 3){
            for (int i = 0; i < unavailableRooms.size(); i++) {
                for (int j = 1; j < 6; j++) {
                    
                    if(unavailableRooms.get(i).getUnavailableRoomNumber() == j){
                        tempUnavailableRooms.add(j);
                    
                    } 
                }
                
            }
            
            for (int i = 1; i < 6; i++) {
                if(!tempUnavailableRooms.contains(i)){
                    availableRoomsArray.add(i);
                    
                }
            }
            return availableRoomsArray;
        }
        
        else if(numOfPeople < 5){
            for (int i = 0; i < unavailableRooms.size(); i++) {
                for (int j = 2; j < 6; j++) {
                    
                    if(unavailableRooms.get(i).getUnavailableRoomNumber() == j){
                        tempUnavailableRooms.add(j);
                    
                    } 
                }
                
            }
            
            for (int i = 2; i < 6; i++) {
                if(!tempUnavailableRooms.contains(i)){
                    availableRoomsArray.add(i);
                    
                }
            }
            return availableRoomsArray;
        }
        
        else if(numOfPeople < 9){
            for (int i = 0; i < unavailableRooms.size(); i++) {
                for (int j = 3; j < 6; j++) {
                    
                    if(unavailableRooms.get(i).getUnavailableRoomNumber() == j){
                        tempUnavailableRooms.add(j);
                    
                    } 
                }
                
            }
            
            for (int i = 3; i < 6; i++) {
                if(!tempUnavailableRooms.contains(i)){
                    availableRoomsArray.add(i);
                    
                }
            }
            return availableRoomsArray;
        }
        
        else if(numOfPeople < 16){
            for (int i = 0; i < unavailableRooms.size(); i++) {
                for (int j = 4; j < 6; j++) {
                    
                    if(unavailableRooms.get(i).getUnavailableRoomNumber() == j){
                        tempUnavailableRooms.add(j);
                    
                    } 
                }
                
            }
            
            for (int i = 4; i < 6; i++) {
                if(!tempUnavailableRooms.contains(i)){
                    availableRoomsArray.add(i);
                    
                }
            }
            return availableRoomsArray;
        }
        
        else if(numOfPeople < 51){
            
            for (int i = 0; i < unavailableRooms.size(); i++) {
                for (int j = 5; j < 6; j++) {
                    
                    if(unavailableRooms.get(i).getUnavailableRoomNumber() == j){
                        tempUnavailableRooms.add(j);
                    
                    } 
                }
                
            }
            
            for (int i = 5; i < 6; i++) {
                if(!tempUnavailableRooms.contains(i)){
                    availableRoomsArray.add(i);
                    
                }
            }
            return availableRoomsArray;
        }
        
        return availableRoomsArray;
    }

    

    


}
