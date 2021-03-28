/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Objects.unavailableRoomTimes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    public static int numOfPeople;
    public static boolean tickboxState;
            
    
    public static ArrayList<Integer> availableRoomsArray;
    public static ArrayList<unavailableRoomTimes> unavailableRooms;
    public static ArrayList<unavailableRoomTimes> unavailableRoomTimesArray;
    public static ArrayList<JButton> buttons = new ArrayList<JButton>();
    public static ArrayList<JLabel> roomLabels = new ArrayList<JLabel>();
    public static ArrayList<JLabel> timeLabels = new ArrayList<JLabel>();
    
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
        System.out.println(availableRoomsArray);
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
    
    

    
    public void displayWheelChairRoom(){
        
        if(numOfPeople > 15){
            displayRoomError.setText("There are too many people for the disabled access room");
            resetSystem();
        }
        
//        if(unavailableRooms.contains(4)){
//            resetSystem();
//        }
        
        
        RoomButton1.setText("Room 4");
        RoomButton1.setVisible(true);
        
    }
        
    public void resetSystem(){
        System.out.println("hi");
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
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

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

        RoomButton3.setText("jButton3");

        RoomButton4.setText("jButton4");

        RoomButton5.setText("jButton5");

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
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel24.setText("jLabel24");

        jButton6.setText("Yes");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("No");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel24)
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(emailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(bookingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roomSelectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(emailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(bookingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(roomSelectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                System.out.println("hi");    
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
        
    }//GEN-LAST:event_RoomButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField numOfPeopleField;
    private javax.swing.JPanel roomSelectPanel;
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
