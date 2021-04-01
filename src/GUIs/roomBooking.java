/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Objects.Employee;
import Objects.EmployeeIdentity;
import Objects.Room;
import Objects.unavailableRoomTimes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import libraryFunctions.repository;
import static libraryFunctions.repository.currentUser;
import static libraryFunctions.repository.getAllNames;
import static libraryFunctions.repository.getAllRoomIDs;
import roomBookingClasses.addEmployees;
import roomBookingClasses.availableRooms;

/**
 *
 * @author aocar
 */
public class roomBooking extends javax.swing.JFrame {

    /**
     * Creates new form roomBooking
     */
    public static String email;
    public static LocalDate bookedDate;
    public static LocalTime bookedStartTime;
    public static LocalTime bookedEndTime;
    public static int roomNumber;
    public static int roomID;
    public static int numOfPeople;
    public static boolean tickboxState;
            
    
    public static ArrayList<Integer> availableRoomsArray;
    public static ArrayList<unavailableRoomTimes> unavailableRooms;
    public static ArrayList<unavailableRoomTimes> unavailableRoomTimesArray;
    public static ArrayList<JButton> buttons = new ArrayList<JButton>();
    public static ArrayList<JLabel> roomLabels = new ArrayList<JLabel>();
    public static ArrayList<JLabel> timeLabels = new ArrayList<JLabel>();
    public static ArrayList<JButton> employeeButtons = new ArrayList<JButton>();
    public static ArrayList<String> meetingAttendees = new ArrayList<>();
    public static ArrayList<EmployeeIdentity> namesFound;
    
    public roomBooking() {
        initComponents();
        emailPanel.setVisible(true);  
        bookingDetailsPanel.setVisible(false);
        invalidEmailMessage.setVisible(false);
        unavailableRoomsLabel1.setVisible(false);
        unavailableRoomsLabel2.setVisible(false);
        unavailableRoomsLabel3.setVisible(false);
        unavailableRoomsLabel4.setVisible(false);
        unavailableRoomsLabel5.setVisible(false);
        unavailableTimeLabel1.setVisible(false);
        unavailableTimeLabel2.setVisible(false);
        unavailableTimeLabel3.setVisible(false);
        unavailableTimeLabel4.setVisible(false);
        unavailableTimeLabel5.setVisible(false);
        RoomButton1.setVisible(false);
        RoomButton2.setVisible(false);
        RoomButton3.setVisible(false);
        RoomButton4.setVisible(false);
        RoomButton5.setVisible(false);
        buttons.add(RoomButton1);
        buttons.add(RoomButton2);
        buttons.add(RoomButton3);
        buttons.add(RoomButton4);
        buttons.add(RoomButton5);
        roomLabels.add(unavailableRoomsLabel1);
        roomLabels.add(unavailableRoomsLabel2);
        roomLabels.add(unavailableRoomsLabel3);
        roomLabels.add(unavailableRoomsLabel4);
        roomLabels.add(unavailableRoomsLabel5);
        timeLabels.add(unavailableTimeLabel1);
        timeLabels.add(unavailableTimeLabel2);
        timeLabels.add(unavailableTimeLabel3);
        timeLabels.add(unavailableTimeLabel4);
        timeLabels.add(unavailableTimeLabel5);
        roomSelectPanel.setVisible(false);
        employeeButtons.add(nameButton1);
        employeeButtons.add(nameButton2);
        employeeButtons.add(nameButton3);
        employeeButtons.add(nameButton4);
        employeeButtons.add(nameButton5);
        employeeButtons.add(nameButton6);
        employeeButtons.add(nameButton7);
        employeeButtons.add(nameButton8);
        employeeButtons.add(nameButton9);
        employeeButtons.add(nameButton10);
        employeeButtons.add(nameButton11);
        employeeButtons.add(nameButton12);
        employeeButtons.add(nameButton13);
        employeeButtons.add(nameButton14);
        employeeButtons.add(nameButton15);
        nameButton1.setVisible(false);
        nameButton2.setVisible(false);
        nameButton3.setVisible(false);
        nameButton4.setVisible(false);
        nameButton5.setVisible(false);
        nameButton6.setVisible(false);
        nameButton7.setVisible(false);
        nameButton8.setVisible(false);
        nameButton9.setVisible(false);
        nameButton10.setVisible(false);
        nameButton11.setVisible(false);
        nameButton12.setVisible(false);
        nameButton13.setVisible(false);
        nameButton14.setVisible(false);
        nameButton15.setVisible(false);
        preSearchPanel.setVisible(false);
        searchPanel.setVisible(false);
       
        
    } 

    
    
    public void displayAvailableRooms(){
        bookingDetailsPanel.setVisible(false);
        jButton9.setVisible(true);
        jButton8.setVisible(true);
        displayRoomError.setVisible(true);
        roomSelectPanel.setVisible(true);
        
        unavailableRooms  = availableRooms.availableRoomsCheck();
        
        if(tickboxState == true){
            displayWheelChairRoom();
        }
        
        availableRoomsArray = availableRooms.bestRoomCheck();
        
        if(availableRoomsArray.isEmpty()){
            
        }
        else{
            int count = 0;
            int maxCount = availableRoomsArray.size();
            for(JButton RoomButton : buttons){
                RoomButton.setText("Room " + String.valueOf(availableRoomsArray.get(count)));
                RoomButton.setVisible(true);
                count++;
                if(count == maxCount){
                    break;
                }
            }
        }
        
        int count = 0;
        int maxCount = unavailableRooms.size();
        
        for(JLabel unavailableRoomsLabel : roomLabels){
            unavailableRoomsLabel.setText("Room " + String.valueOf(unavailableRooms.get(count).getUnavailableRoomNumber()));
            unavailableRoomsLabel.setVisible(true);
            count++;
            
            if(count == maxCount){
                break;
            }
        }
        
        count = 0;
 
        for(JLabel unavailableTimeLabel : timeLabels){
            unavailableTimeLabel.setText(String.valueOf(unavailableRooms.get(count).getUnavailableStartTime())+" - "+String.valueOf(unavailableRooms.get(count).getUnavailableEndTime()));
            unavailableTimeLabel.setVisible(true);
            count++;
            
            if(count == maxCount){
                break;
            }
        }
        
    }
    
    public void searchEmployee(){
        
        String employeeNameSearch = searchNameField.getText();
        namesFound = addEmployees.searchEmployees(employeeNameSearch);
        
        if(namesFound.isEmpty()){
            
        }
        else{
            int count = 0;
            int maxCount = namesFound.size();
            for(JButton nameButton : employeeButtons){
                nameButton.setText(String.valueOf(namesFound.get(count).getEmployee_Fname())+" "+String.valueOf(namesFound.get(count).getEmployee_Lname()));
                nameButton.setVisible(true);
                count++;
                if(count == maxCount){
                    break;
                }
            }
        }
        
        
    }
    
    public void addAttendees(int nameButtonNum){
        boolean alreadyThere = false;
        for (int i = 0; i < meetingAttendees.size(); i++) {
            if(meetingAttendees.get(i).equals(namesFound.get(nameButtonNum).getEmployee_Id())){
                alreadyThere = true;
            }
        }
        if(alreadyThere == false){
            meetingAttendees.add(String.valueOf(namesFound.get(nameButtonNum).getEmployee_Id()));
            System.out.println(String.valueOf(namesFound.get(nameButtonNum).getEmployee_Id()));
        }
    }
    
    public void createRoomBooking(String buttonText){
        
        for (int i = 1; i < 6; i++) {
            if(buttonText.contains(String.valueOf(i))){
                roomNumber = i;
                break;
            }
        }
        ArrayList<String> allRoomIDs = getAllRoomIDs();
        Random rand = new Random();
        roomID = 1111;
        while(allRoomIDs.contains(roomID)){
            roomID = rand.nextInt(9000)+1000;
        }
        
        try{
            
            Room nr = new Room(email,roomNumber,bookedDate,bookedStartTime,bookedEndTime,repository.currentUser.getEmployee_Id(),String.valueOf(roomID));
            repository.insertNewRoomBooking(nr);
        }catch(Exception e){
            System.out.println("Error in Room Booking "+e);
        }
        preSearchPanel.setVisible(true);
    }

    
    public void displayWheelChairRoom(){
        System.out.println("hi");
        if(numOfPeople > 15){
            displayRoomError.setText("There are too many people for the disabled access room");
            roomSelectPanel.setVisible(false);
            bookingDetailsPanel.setVisible(true);
            
        }
        
        boolean unavailable = false;
        for (int i = 0; i < unavailableRooms.size(); i++) {
            if(unavailableRooms.get(i).getUnavailableRoomNumber() == 4){
                unavailable = true;        
                    
            } 
        }
        
        if(unavailable == true){
            roomSelectPanel.setVisible(false);
            bookingDetailsPanel.setVisible(true);
        }
        
        
        RoomButton1.setText("Room 4");
        RoomButton1.setVisible(true);
        
    }
        
       
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        emailPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailBackButton = new javax.swing.JButton();
        emailConfirmButton = new javax.swing.JButton();
        invalidEmailMessage = new javax.swing.JLabel();
        bookingDetailsPanel = new javax.swing.JPanel();
        wheelchairTick = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        startTimeField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        endTimeField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailBackButton1 = new javax.swing.JButton();
        detailsConfirmButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        detailsErrorMessage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numOfPeopleField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        roomSelectPanel = new javax.swing.JPanel();
        displayRoomError = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        RoomButton1 = new javax.swing.JButton();
        RoomButton2 = new javax.swing.JButton();
        RoomButton3 = new javax.swing.JButton();
        RoomButton4 = new javax.swing.JButton();
        RoomButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        unavailableRoomsLabel1 = new javax.swing.JLabel();
        unavailableRoomsLabel2 = new javax.swing.JLabel();
        unavailableRoomsLabel3 = new javax.swing.JLabel();
        unavailableRoomsLabel4 = new javax.swing.JLabel();
        unavailableRoomsLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        unavailableTimeLabel1 = new javax.swing.JLabel();
        unavailableTimeLabel2 = new javax.swing.JLabel();
        unavailableTimeLabel3 = new javax.swing.JLabel();
        unavailableTimeLabel4 = new javax.swing.JLabel();
        unavailableTimeLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        preSearchPanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchNameField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        nameButton1 = new javax.swing.JButton();
        nameButton2 = new javax.swing.JButton();
        nameButton3 = new javax.swing.JButton();
        nameButton4 = new javax.swing.JButton();
        nameButton5 = new javax.swing.JButton();
        nameButton6 = new javax.swing.JButton();
        nameButton7 = new javax.swing.JButton();
        nameButton8 = new javax.swing.JButton();
        nameButton9 = new javax.swing.JButton();
        nameButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        nameButton11 = new javax.swing.JButton();
        nameButton12 = new javax.swing.JButton();
        nameButton13 = new javax.swing.JButton();
        nameButton14 = new javax.swing.JButton();
        nameButton15 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel25.setText("jLabel25");

        jLabel26.setText("jLabel26");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Email adress");

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        emailBackButton.setText("Back");
        emailBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailBackButtonActionPerformed(evt);
            }
        });

        emailConfirmButton.setText("Confirm");
        emailConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailConfirmButtonActionPerformed(evt);
            }
        });

        invalidEmailMessage.setText("Invalid email");

        javax.swing.GroupLayout emailPanelLayout = new javax.swing.GroupLayout(emailPanel);
        emailPanel.setLayout(emailPanelLayout);
        emailPanelLayout.setHorizontalGroup(
            emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invalidEmailMessage)
                    .addGroup(emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        emailPanelLayout.setVerticalGroup(
            emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailBackButton)
                    .addComponent(emailConfirmButton))
                .addGap(3, 3, 3)
                .addComponent(invalidEmailMessage)
                .addContainerGap())
        );

        wheelchairTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wheelchairTickActionPerformed(evt);
            }
        });

        jLabel2.setText("Wheelchair access");

        jLabel3.setText("Date");

        jLabel4.setText("Start time");

        startTimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimeFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Number of people");

        jLabel6.setText("Room Booking details");

        emailBackButton1.setText("Back");
        emailBackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailBackButton1ActionPerformed(evt);
            }
        });

        detailsConfirmButton.setText("Confirm");
        detailsConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsConfirmButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("(dd/mm/yyyy)");

        jLabel8.setText("(hh/mm)");

        detailsErrorMessage.setText("jLabel9");

        jLabel9.setText("End time");

        jLabel10.setText("(hh/mm)");

        javax.swing.GroupLayout bookingDetailsPanelLayout = new javax.swing.GroupLayout(bookingDetailsPanel);
        bookingDetailsPanel.setLayout(bookingDetailsPanelLayout);
        bookingDetailsPanelLayout.setHorizontalGroup(
            bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                        .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(emailBackButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel4))
                            .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                                .addComponent(detailsErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(146, 146, 146))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookingDetailsPanelLayout.createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookingDetailsPanelLayout.createSequentialGroup()
                                        .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(wheelchairTick)
                                            .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(detailsConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(numOfPeopleField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(82, 82, 82))
                                    .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                                        .addComponent(endTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))))))))
        );
        bookingDetailsPanelLayout.setVerticalGroup(
            bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingDetailsPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGap(43, 43, 43)
                .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(endTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(12, 12, 12)
                .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numOfPeopleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(wheelchairTick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(bookingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailBackButton1)
                    .addComponent(detailsConfirmButton)
                    .addComponent(detailsErrorMessage))
                .addContainerGap())
        );

        displayRoomError.setText("Would you like to book for another time?");

        jLabel11.setText("Available Rooms:");

        RoomButton1.setText("jButton1");
        RoomButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomButton1ActionPerformed(evt);
            }
        });

        RoomButton2.setText("jButton2");
        RoomButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomButton2ActionPerformed(evt);
            }
        });

        RoomButton3.setText("jButton3");
        RoomButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomButton3ActionPerformed(evt);
            }
        });

        RoomButton4.setText("jButton4");
        RoomButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomButton4ActionPerformed(evt);
            }
        });

        RoomButton5.setText("jButton5");
        RoomButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("Unavailable Rooms:");

        unavailableRoomsLabel1.setText("jLabel13");

        unavailableRoomsLabel2.setText("jLabel14");

        unavailableRoomsLabel3.setText("jLabel15");

        unavailableRoomsLabel4.setText("jLabel16");

        unavailableRoomsLabel5.setText("jLabel17");

        jLabel18.setText("Time Already Booked For:");

        unavailableTimeLabel1.setText("jLabel19");

        unavailableTimeLabel2.setText("jLabel20");

        unavailableTimeLabel3.setText("jLabel21");

        unavailableTimeLabel4.setText("jLabel22");

        unavailableTimeLabel5.setText("jLabel23");

        jButton8.setText("Yes");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("No");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roomSelectPanelLayout = new javax.swing.GroupLayout(roomSelectPanel);
        roomSelectPanel.setLayout(roomSelectPanelLayout);
        roomSelectPanelLayout.setHorizontalGroup(
            roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomSelectPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
            .addGroup(roomSelectPanelLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(displayRoomError, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(roomSelectPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RoomButton1)
                    .addComponent(RoomButton2)
                    .addComponent(RoomButton3)
                    .addComponent(RoomButton4)
                    .addComponent(RoomButton5)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unavailableRoomsLabel1)
                    .addComponent(unavailableRoomsLabel2)
                    .addComponent(unavailableRoomsLabel3)
                    .addComponent(unavailableRoomsLabel4)
                    .addComponent(unavailableRoomsLabel5)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(unavailableTimeLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(unavailableTimeLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unavailableTimeLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unavailableTimeLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unavailableTimeLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        roomSelectPanelLayout.setVerticalGroup(
            roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomSelectPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomButton1)
                    .addComponent(unavailableRoomsLabel1)
                    .addComponent(unavailableTimeLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomButton2)
                    .addComponent(unavailableRoomsLabel2)
                    .addComponent(unavailableTimeLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomButton3)
                    .addComponent(unavailableRoomsLabel3)
                    .addComponent(unavailableTimeLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomButton4)
                    .addComponent(unavailableRoomsLabel4)
                    .addComponent(unavailableTimeLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomButton5)
                    .addComponent(unavailableRoomsLabel5)
                    .addComponent(unavailableTimeLabel5))
                .addGap(50, 50, 50)
                .addComponent(displayRoomError)
                .addGap(28, 28, 28)
                .addGroup(roomSelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel24.setText("Would you like to add anyone to this meeting?");

        jButton6.setText("Yes");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("No");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout preSearchPanelLayout = new javax.swing.GroupLayout(preSearchPanel);
        preSearchPanel.setLayout(preSearchPanelLayout);
        preSearchPanelLayout.setHorizontalGroup(
            preSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preSearchPanelLayout.createSequentialGroup()
                .addGroup(preSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(preSearchPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(preSearchPanelLayout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addComponent(jLabel24)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        preSearchPanelLayout.setVerticalGroup(
            preSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preSearchPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel24)
                .addGap(55, 55, 55)
                .addGroup(preSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setText("Search:");

        nameButton1.setText("jButton1");
        nameButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButton1ActionPerformed(evt);
            }
        });

        nameButton2.setText("jButton2");
        nameButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButton2ActionPerformed(evt);
            }
        });

        nameButton3.setText("jButton3");
        nameButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButton3ActionPerformed(evt);
            }
        });

        nameButton4.setText("jButton4");
        nameButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButton4ActionPerformed(evt);
            }
        });

        nameButton5.setText("jButton5");
        nameButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButton5ActionPerformed(evt);
            }
        });

        nameButton6.setText("jButton10");
        nameButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButton6ActionPerformed(evt);
            }
        });

        nameButton7.setText("jButton11");
        nameButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButton7ActionPerformed(evt);
            }
        });

        nameButton8.setText("jButton12");

        nameButton9.setText("jButton13");

        nameButton10.setText("jButton14");

        jButton15.setText("search");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        nameButton11.setText("jButton14");

        nameButton12.setText("jButton14");

        nameButton13.setText("jButton14");

        nameButton14.setText("jButton14");

        nameButton15.setText("jButton14");

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameButton10)
                    .addComponent(nameButton9)
                    .addComponent(nameButton8)
                    .addComponent(nameButton7)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(searchNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton15))
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nameButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(nameButton13)
                    .addComponent(nameButton11)
                    .addComponent(nameButton12)
                    .addComponent(nameButton14)
                    .addComponent(nameButton15))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButton15))
                .addGap(31, 31, 31)
                .addComponent(nameButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(nameButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameButton14)
                .addGap(7, 7, 7)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(preSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(emailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(bookingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(roomSelectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(emailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(roomSelectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(269, 269, 269)
                        .addComponent(preSearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(bookingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void emailBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailBackButtonActionPerformed
        MainMenu main = new MainMenu();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_emailBackButtonActionPerformed

    private void emailConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailConfirmButtonActionPerformed
        email = emailField.getText();
        invalidEmailMessage.setVisible(false);
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern emailPattern = Pattern.compile(regex);
        Matcher emailMatcher = emailPattern.matcher(email);
        if(emailMatcher.matches() == true){
            emailPanel.setVisible(false);
            bookingDetailsPanel.setVisible(true);
        }else{
            invalidEmailMessage.setVisible(true);
        }
        
    }//GEN-LAST:event_emailConfirmButtonActionPerformed

    private void wheelchairTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wheelchairTickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wheelchairTickActionPerformed

    private void startTimeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTimeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startTimeFieldActionPerformed

    private void emailBackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailBackButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailBackButton1ActionPerformed

    private void detailsConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsConfirmButtonActionPerformed
        detailsErrorMessage.setVisible(false);
        
        try{
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            bookedDate = LocalDate.parse(dateField.getText(), dateFormatter);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH/mm");
            bookedStartTime = LocalTime.parse(startTimeField.getText(), timeFormatter);
            bookedEndTime = LocalTime.parse(endTimeField.getText(), timeFormatter);
            
            if(Integer.parseInt(numOfPeopleField.getText())>50){
            detailsErrorMessage.setText("Too many people (50 max)");
            detailsErrorMessage.setVisible(true);
            }else if(Integer.parseInt(numOfPeopleField.getText())<0){
                detailsErrorMessage.setText("Need at least one person");
                detailsErrorMessage.setVisible(true);
            }else{
                    
                numOfPeople = Integer.parseInt(numOfPeopleField.getText());
                tickboxState = wheelchairTick.isSelected();
                displayAvailableRooms();
            }
        }catch(Exception e){
            detailsErrorMessage.setText("Invalid time or date format");
            detailsErrorMessage.setVisible(true);
        }
        
        
        
        
    }//GEN-LAST:event_detailsConfirmButtonActionPerformed

    private void RoomButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomButton1ActionPerformed
        String buttonText = RoomButton1.getText();
        createRoomBooking(buttonText);
    }//GEN-LAST:event_RoomButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        searchPanel.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setVisible(false);
        jButton8.setVisible(false);
        displayRoomError.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        roomSelectPanel.setVisible(false);
        bookingDetailsPanel.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        nameButton1.setVisible(false);
        nameButton2.setVisible(false);
        nameButton3.setVisible(false);
        nameButton4.setVisible(false);
        nameButton5.setVisible(false);
        nameButton6.setVisible(false);
        nameButton7.setVisible(false);
        nameButton8.setVisible(false);
        nameButton9.setVisible(false);
        nameButton10.setVisible(false);
        nameButton11.setVisible(false);
        nameButton12.setVisible(false);
        nameButton13.setVisible(false);
        nameButton14.setVisible(false);
        nameButton15.setVisible(false);
        
        searchEmployee();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void nameButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButton1ActionPerformed
        int nameButtonNum = 0;
        addAttendees(nameButtonNum);
    }//GEN-LAST:event_nameButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        repository.insertNewEmployeeRooms(meetingAttendees, roomID);
        MainMenu main = new MainMenu();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
        ArrayList<String> allRoomIDs = getAllRoomIDs();
        Random rand = new Random();
        roomID = 1111;
        while(allRoomIDs.contains(roomID)){
            roomID = rand.nextInt(9000)+1000;
        }
        
        meetingAttendees.add(currentUser.getEmployee_Id());
        repository.insertNewEmployeeRooms(meetingAttendees, roomID);
        MainMenu main = new MainMenu();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void RoomButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomButton2ActionPerformed
        String buttonText = RoomButton2.getText();
        createRoomBooking(buttonText);        
    }//GEN-LAST:event_RoomButton2ActionPerformed

    private void RoomButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomButton3ActionPerformed
        String buttonText = RoomButton3.getText();
        createRoomBooking(buttonText);
    }//GEN-LAST:event_RoomButton3ActionPerformed

    private void RoomButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomButton4ActionPerformed
        String buttonText = RoomButton4.getText();
        createRoomBooking(buttonText);
    }//GEN-LAST:event_RoomButton4ActionPerformed

    private void RoomButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomButton5ActionPerformed
        String buttonText = RoomButton5.getText();
        createRoomBooking(buttonText);
    }//GEN-LAST:event_RoomButton5ActionPerformed

    private void nameButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButton2ActionPerformed
        int nameButtonNum = 1;
        addAttendees(nameButtonNum);
    }//GEN-LAST:event_nameButton2ActionPerformed

    private void nameButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButton3ActionPerformed
        int nameButtonNum = 2;
        addAttendees(nameButtonNum);
    }//GEN-LAST:event_nameButton3ActionPerformed

    private void nameButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButton4ActionPerformed
        int nameButtonNum = 3;
        addAttendees(nameButtonNum);
    }//GEN-LAST:event_nameButton4ActionPerformed

    private void nameButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButton5ActionPerformed
        int nameButtonNum = 4;
        addAttendees(nameButtonNum);
    }//GEN-LAST:event_nameButton5ActionPerformed

    private void nameButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButton6ActionPerformed
        int nameButtonNum = 5;
        addAttendees(nameButtonNum);
    }//GEN-LAST:event_nameButton6ActionPerformed

    private void nameButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButton7ActionPerformed
        int nameButtonNum = 6;
        addAttendees(nameButtonNum);
    }//GEN-LAST:event_nameButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(roomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(roomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(roomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(roomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new roomBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RoomButton1;
    private javax.swing.JButton RoomButton2;
    private javax.swing.JButton RoomButton3;
    private javax.swing.JButton RoomButton4;
    private javax.swing.JButton RoomButton5;
    private javax.swing.JPanel bookingDetailsPanel;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton detailsConfirmButton;
    private javax.swing.JLabel detailsErrorMessage;
    private javax.swing.JLabel displayRoomError;
    private javax.swing.JButton emailBackButton;
    private javax.swing.JButton emailBackButton1;
    private javax.swing.JButton emailConfirmButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel emailPanel;
    private javax.swing.JTextField endTimeField;
    private javax.swing.JLabel invalidEmailMessage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton nameButton1;
    private javax.swing.JButton nameButton10;
    private javax.swing.JButton nameButton11;
    private javax.swing.JButton nameButton12;
    private javax.swing.JButton nameButton13;
    private javax.swing.JButton nameButton14;
    private javax.swing.JButton nameButton15;
    private javax.swing.JButton nameButton2;
    private javax.swing.JButton nameButton3;
    private javax.swing.JButton nameButton4;
    private javax.swing.JButton nameButton5;
    private javax.swing.JButton nameButton6;
    private javax.swing.JButton nameButton7;
    private javax.swing.JButton nameButton8;
    private javax.swing.JButton nameButton9;
    private javax.swing.JTextField numOfPeopleField;
    private javax.swing.JPanel preSearchPanel;
    private javax.swing.JPanel roomSelectPanel;
    private javax.swing.JTextField searchNameField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField startTimeField;
    private javax.swing.JLabel unavailableRoomsLabel1;
    private javax.swing.JLabel unavailableRoomsLabel2;
    private javax.swing.JLabel unavailableRoomsLabel3;
    private javax.swing.JLabel unavailableRoomsLabel4;
    private javax.swing.JLabel unavailableRoomsLabel5;
    private javax.swing.JLabel unavailableTimeLabel1;
    private javax.swing.JLabel unavailableTimeLabel2;
    private javax.swing.JLabel unavailableTimeLabel3;
    private javax.swing.JLabel unavailableTimeLabel4;
    private javax.swing.JLabel unavailableTimeLabel5;
    private javax.swing.JCheckBox wheelchairTick;
    // End of variables declaration//GEN-END:variables

}
