/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Objects.Room;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libraryFunctions.repository;

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
    
    public roomBooking() {
        initComponents();
        emailPanel.setVisible(true);  
        bookingDetailsPanel.setVisible(false);
        invalidEmailMessage.setVisible(false);
    } 

    public static void availableRoomsCheck(){
        
        ArrayList<Room> roomBookingList = repository.getAllRoomBookings();
        
        for (int i = 0; i < roomBookingList.size(); i++) {
            if(roomBookingList.get(i).getBookedDate().equals(bookedDate) && ((bookedStartTime.isAfter(roomBookingList.get(i).getBookedStartTime().minusMinutes(30)) && bookedStartTime.isBefore(roomBookingList.get(i).getBookedEndTime().plusMinutes(30))) || (bookedEndTime.isAfter(roomBookingList.get(i).getBookedStartTime().minusMinutes(30)) && bookedEndTime.isBefore(roomBookingList.get(i).getBookedEndTime().plusMinutes(30))))){
                
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(emailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(bookingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(emailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(bookingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
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
                
            }
        }catch(Exception e){
            detailsErrorMessage.setText("Invalid time or date format");
            detailsErrorMessage.setVisible(true);
        }
        
        
        
        
    }//GEN-LAST:event_detailsConfirmButtonActionPerformed

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
    private javax.swing.JPanel bookingDetailsPanel;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton detailsConfirmButton;
    private javax.swing.JLabel detailsErrorMessage;
    private javax.swing.JButton emailBackButton;
    private javax.swing.JButton emailBackButton1;
    private javax.swing.JButton emailConfirmButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel emailPanel;
    private javax.swing.JTextField endTimeField;
    private javax.swing.JLabel invalidEmailMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField numOfPeopleField;
    private javax.swing.JTextField startTimeField;
    private javax.swing.JCheckBox wheelchairTick;
    // End of variables declaration//GEN-END:variables
}