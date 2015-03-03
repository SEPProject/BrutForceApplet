/*
 * Created by JFormDesigner on Sun Feb 22 17:37:23 CET 2015
 */

package view;

import controller.Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class View implements ViewBehaviour {

    private Controller controller;

    private StyledDocument info;
    private StyledDocument hackerView;
    private Style  errorStyle, infoStyle;

    public View() {
        /* init */
        System.out.println("*** View init ***");
        initComponents();

        /*
        * styles' initialization
        * Red for error printed for user
        */
        info = infoPane.getStyledDocument();

        errorStyle = infoPane.addStyle("errStyle", null);
        infoStyle = infoPane.addStyle("infoStyle", null);

        StyleConstants.setForeground(infoStyle, Color.BLACK);
        StyleConstants.setForeground(errorStyle, Color.RED);


        hackerView = attackPane.getStyledDocument();



        /* managing first pane */
        mainPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPage.setVisible(false);
        firstPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        missionDialog.setVisible(false);
    }

    @Override
    public JFrame getFirstPage(){
        return firstPage;
    }

    @Override
    public void setController(Controller c) {
        this.controller=c;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    /*
        FUNCTION CALLED FROM CONTROLLER : SETTING THE VIEW
     */

    @Override
    public void setAppletDescriptionText(String s){
        appletDescriptionText.setText(s);
    }

    @Override
    public void setMissionDescriptionText(String s){
        missionDescriptionText.setText(s);
    }

    @Override
    public void setMissionPart1 (String s){
        missionPart1.setText(s);
    }


    /*
        FUNCTION CALLED FROM USER
    */

    private void beginButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("*** beginButton pressed ***");
        firstPage.setVisible(false);
        mainPage.setVisible(true);
    }

    private void missionButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        System.out.println("*** missionButton pressed ***");
        missionDialog.setVisible(true);
    }

    private void passwordButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("*** passwordButton pressed ***");
        try{
            info.insertString(info.getLength(),"see password file",infoStyle);
        } catch(BadLocationException error) {
            System.err.println(error);
        }
    }

    private void addWordButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("*** passwordButton pressed ***");
        //infoPane.add
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - fgd efeg
        mainPage = new JFrame();
        userPane = new JPanel();
        missionButton = new JToggleButton();
        wordTextArea = new JTextField();
        addWordButton = new JButton();
        passwordButton = new JButton();
        scrollAttackpane = new JScrollPane();
        attackPane = new JTextPane();
        scrollInfoPane = new JScrollPane();
        infoPane = new JTextPane();
        attackLabel = new JLabel();
        infoLabel = new JLabel();
        firstPage = new JFrame();
        firstPagePane = new JPanel();
        appletDescriptionText = new JTextArea();
        welcomeLabel = new JLabel();
        beginButton = new JButton();
        missionDialog = new JDialog();
        missionDialogPanel = new JPanel();
        missionLabel = new JLabel();
        missionDescriptionText = new JTextArea();
        missionPart1 = new JTextArea();

        //======== mainPage ========
        {
            Container mainPageContentPane = mainPage.getContentPane();
            mainPageContentPane.setLayout(new BorderLayout());

            //======== userPane ========
            {

                // JFormDesigner evaluation mark
                userPane.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), userPane.getBorder())); userPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- missionButton ----
                missionButton.setText("Mission");
                missionButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        missionButtonMouseClicked(e);
                    }
                });

                //---- addWordButton ----
                addWordButton.setText("add word to dictionnary");
                addWordButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addWordButtonActionPerformed(e);
                    }
                });

                //---- passwordButton ----
                passwordButton.setText("passwordFile");
                passwordButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        passwordButtonActionPerformed(e);
                    }
                });

                //======== scrollAttackpane ========
                {
                    scrollAttackpane.setViewportView(attackPane);
                }

                //======== scrollInfoPane ========
                {
                    scrollInfoPane.setViewportView(infoPane);
                }

                //---- attackLabel ----
                attackLabel.setText("Attacker view");

                //---- infoLabel ----
                infoLabel.setText("More information");

                GroupLayout userPaneLayout = new GroupLayout(userPane);
                userPane.setLayout(userPaneLayout);
                userPaneLayout.setHorizontalGroup(
                    userPaneLayout.createParallelGroup()
                        .addGroup(userPaneLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(attackLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                            .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                            .addGap(135, 135, 135))
                        .addGroup(GroupLayout.Alignment.TRAILING, userPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(userPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addComponent(wordTextArea, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addWordButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
                                    .addComponent(missionButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addComponent(scrollAttackpane, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                    .addComponent(scrollInfoPane, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)))
                            .addGap(24, 24, 24))
                        .addGroup(GroupLayout.Alignment.TRAILING, userPaneLayout.createSequentialGroup()
                            .addContainerGap(692, Short.MAX_VALUE)
                            .addComponent(passwordButton)
                            .addGap(14, 14, 14))
                );
                userPaneLayout.setVerticalGroup(
                    userPaneLayout.createParallelGroup()
                        .addGroup(userPaneLayout.createSequentialGroup()
                            .addGroup(userPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(attackLabel)
                                .addComponent(infoLabel))
                            .addGap(2, 2, 2)
                            .addGroup(userPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollInfoPane, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollAttackpane, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
                            .addGroup(userPaneLayout.createParallelGroup()
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addGroup(userPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(wordTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addWordButton))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(missionButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passwordButton)
                                    .addGap(63, 63, 63))))
                );
            }
            mainPageContentPane.add(userPane, BorderLayout.CENTER);
            mainPage.setSize(820, 505);
            mainPage.setLocationRelativeTo(mainPage.getOwner());
        }

        //======== firstPage ========
        {
            Container firstPageContentPane = firstPage.getContentPane();
            firstPageContentPane.setLayout(new BorderLayout());

            //======== firstPagePane ========
            {

                // JFormDesigner evaluation mark
                firstPagePane.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), firstPagePane.getBorder())); firstPagePane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- appletDescriptionText ----
                appletDescriptionText.setBackground(new Color(238, 238, 238));
                appletDescriptionText.setLineWrap(true);
                appletDescriptionText.setWrapStyleWord(true);
                appletDescriptionText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                appletDescriptionText.setFocusable(false);
                appletDescriptionText.setCaretColor(new Color(238, 238, 238));

                //---- welcomeLabel ----
                welcomeLabel.setText("WELCOME TO THE BRUTE FORCE APPLET");
                welcomeLabel.setFont(new Font("Malayalam Sangam MN", Font.BOLD | Font.ITALIC, 13));

                //---- beginButton ----
                beginButton.setText("start");
                beginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        beginButtonActionPerformed(e);
                    }
                });

                GroupLayout firstPagePaneLayout = new GroupLayout(firstPagePane);
                firstPagePane.setLayout(firstPagePaneLayout);
                firstPagePaneLayout.setHorizontalGroup(
                    firstPagePaneLayout.createParallelGroup()
                        .addGroup(firstPagePaneLayout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(firstPagePaneLayout.createParallelGroup()
                                .addGroup(firstPagePaneLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(appletDescriptionText, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
                                .addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                                .addGroup(firstPagePaneLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(beginButton, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(51, Short.MAX_VALUE))
                );
                firstPagePaneLayout.setVerticalGroup(
                    firstPagePaneLayout.createParallelGroup()
                        .addGroup(firstPagePaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(appletDescriptionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(beginButton)
                            .addContainerGap(77, Short.MAX_VALUE))
                );
            }
            firstPageContentPane.add(firstPagePane, BorderLayout.CENTER);
            firstPage.setSize(360, 225);
            firstPage.setLocationRelativeTo(firstPage.getOwner());
        }

        //======== missionDialog ========
        {
            missionDialog.setResizable(false);
            Container missionDialogContentPane = missionDialog.getContentPane();
            missionDialogContentPane.setLayout(new BorderLayout());

            //======== missionDialogPanel ========
            {

                // JFormDesigner evaluation mark
                missionDialogPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), missionDialogPanel.getBorder())); missionDialogPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- missionLabel ----
                missionLabel.setText("Mission : ");

                //---- missionDescriptionText ----
                missionDescriptionText.setBackground(new Color(238, 238, 238));
                missionDescriptionText.setLineWrap(true);
                missionDescriptionText.setWrapStyleWord(true);
                missionDescriptionText.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                missionDescriptionText.setFocusable(false);
                missionDescriptionText.setCaretColor(new Color(238, 238, 238));

                //---- missionPart1 ----
                missionPart1.setBackground(new Color(238, 238, 238));
                missionPart1.setLineWrap(true);
                missionPart1.setWrapStyleWord(true);
                missionPart1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                missionPart1.setFocusable(false);
                missionPart1.setCaretColor(new Color(238, 238, 238));

                GroupLayout missionDialogPanelLayout = new GroupLayout(missionDialogPanel);
                missionDialogPanel.setLayout(missionDialogPanelLayout);
                missionDialogPanelLayout.setHorizontalGroup(
                    missionDialogPanelLayout.createParallelGroup()
                        .addGroup(missionDialogPanelLayout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addGroup(missionDialogPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(missionDescriptionText, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                                .addGroup(missionDialogPanelLayout.createSequentialGroup()
                                    .addComponent(missionLabel)
                                    .addGap(150, 150, 150)))
                            .addContainerGap(72, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, missionDialogPanelLayout.createSequentialGroup()
                            .addContainerGap(90, Short.MAX_VALUE)
                            .addComponent(missionPart1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63))
                );
                missionDialogPanelLayout.setVerticalGroup(
                    missionDialogPanelLayout.createParallelGroup()
                        .addGroup(missionDialogPanelLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(missionLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(missionDescriptionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(missionPart1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(243, Short.MAX_VALUE))
                );
            }
            missionDialogContentPane.add(missionDialogPanel, BorderLayout.CENTER);
            missionDialog.setSize(505, 365);
            missionDialog.setLocationRelativeTo(missionDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - fgd efeg
    private JFrame mainPage;
    private JPanel userPane;
    private JToggleButton missionButton;
    private JTextField wordTextArea;
    private JButton addWordButton;
    private JButton passwordButton;
    private JScrollPane scrollAttackpane;
    private JTextPane attackPane;
    private JScrollPane scrollInfoPane;
    private JTextPane infoPane;
    private JLabel attackLabel;
    private JLabel infoLabel;
    private JFrame firstPage;
    private JPanel firstPagePane;
    private JTextArea appletDescriptionText;
    private JLabel welcomeLabel;
    private JButton beginButton;
    private JDialog missionDialog;
    private JPanel missionDialogPanel;
    private JLabel missionLabel;
    private JTextArea missionDescriptionText;
    private JTextArea missionPart1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
