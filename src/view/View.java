/*
 * Created by JFormDesigner on Sun Feb 22 17:37:23 CET 2015
 */
// format fichier password : nom_hote:port:database:nomutilisateur:motdepasse:
package view;

import controller.Controller;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class View extends Applet implements ViewBehaviour {

    private Controller controller;

    private StyledDocument info;
    private StyledDocument hackerView;
    private Style  errorStyle, infoStyle, attackStyle, cmdStyle;

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

        hackerView = attackPane.getStyledDocument();
        attackStyle = attackPane.addStyle("attackStyle",null);
        cmdStyle = attackPane.addStyle("cmdStyle",null);

        StyleConstants.setForeground(infoStyle, Color.BLACK);
        StyleConstants.setForeground(errorStyle, Color.RED);
        StyleConstants.setForeground(attackStyle,Color.BLACK);
        StyleConstants.setForeground(cmdStyle,Color.GRAY);


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
        String hash = controller.getModel().getPasswordManager().getHashStored();
        try{
            info.insertString(info.getLength(),"<< see how hackers actually do\n",infoStyle);
            hackerView.insertString(hackerView.getLength(),"hacker~$ cat ./hashcaptured\n\n",cmdStyle);
            hackerView.insertString(hackerView.getLength(),"admin:"+hash+"::\n\n",attackStyle);
        } catch(BadLocationException error) {
            System.err.println(error);
        }
    }

    private void addWordButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("*** passwordButton pressed ***");
        try {
            if (wordTextArea.getText().equals("")) {
                info.insertString(info.getLength(),"empty word\n",errorStyle);
            }else {
                info.insertString(info.getLength(),"word added\n",infoStyle);
            }
        }catch(BadLocationException error){
            System.err.println(error);
        }
    }

    private void enterHashButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
            if (controller.getModel().getPasswordManager().testHashUser(providedHashArea.getText())){
                info.insertString(info.getLength(),"good hash\n",infoStyle);
                mission1Panel.setVisible(false);
                mission2panel.setVisible(true);
                missionDialog.setVisible(true);
                nextButton.setVisible(true);
            }else{
                info.insertString(info.getLength(),"wrong hash\n",errorStyle);
            }
        }catch(BadLocationException error){
            System.out.println(error);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - fgd efeg
        mainPage = new JFrame();
        userPane = new JPanel();
        missionButton = new JToggleButton();
        passwordButton = new JButton();
        scrollAttackpane = new JScrollPane();
        attackPane = new JTextPane();
        scrollInfoPane = new JScrollPane();
        infoPane = new JTextPane();
        attackLabel = new JLabel();
        infoLabel = new JLabel();
        panel1 = new JPanel();
        mission1Panel = new JPanel();
        enterHashButton = new JButton();
        providedHashArea = new JTextField();
        mission2panel = new JPanel();
        addWordButton = new JButton();
        wordTextArea = new JTextField();
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
        nextButton = new JButton();

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

                //======== panel1 ========
                {
                    panel1.setLayout(new CardLayout());

                    //======== mission1Panel ========
                    {

                        //---- enterHashButton ----
                        enterHashButton.setText("enter hash");
                        enterHashButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                enterHashButtonActionPerformed(e);
                            }
                        });

                        GroupLayout mission1PanelLayout = new GroupLayout(mission1Panel);
                        mission1Panel.setLayout(mission1PanelLayout);
                        mission1PanelLayout.setHorizontalGroup(
                            mission1PanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, mission1PanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(providedHashArea, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                    .addComponent(enterHashButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25))
                        );
                        mission1PanelLayout.setVerticalGroup(
                            mission1PanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, mission1PanelLayout.createSequentialGroup()
                                    .addContainerGap(21, Short.MAX_VALUE)
                                    .addGroup(mission1PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(enterHashButton)
                                        .addComponent(providedHashArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(17, 17, 17))
                        );
                    }
                    panel1.add(mission1Panel, "card1");

                    //======== mission2panel ========
                    {

                        //---- addWordButton ----
                        addWordButton.setText("add word to dictionnary");
                        addWordButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                addWordButtonActionPerformed(e);
                            }
                        });

                        GroupLayout mission2panelLayout = new GroupLayout(mission2panel);
                        mission2panel.setLayout(mission2panelLayout);
                        mission2panelLayout.setHorizontalGroup(
                            mission2panelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, mission2panelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(wordTextArea, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addWordButton)
                                    .addGap(18, 18, 18))
                        );
                        mission2panelLayout.setVerticalGroup(
                            mission2panelLayout.createParallelGroup()
                                .addGroup(mission2panelLayout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(mission2panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addWordButton)
                                        .addComponent(wordTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(19, Short.MAX_VALUE))
                        );
                    }
                    panel1.add(mission2panel, "card2");
                }

                GroupLayout userPaneLayout = new GroupLayout(userPane);
                userPane.setLayout(userPaneLayout);
                userPaneLayout.setHorizontalGroup(
                    userPaneLayout.createParallelGroup()
                        .addGroup(userPaneLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(attackLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                            .addGap(135, 135, 135))
                        .addGroup(userPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(userPaneLayout.createParallelGroup()
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addComponent(scrollAttackpane, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addComponent(scrollInfoPane, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                    .addGroup(userPaneLayout.createParallelGroup()
                                        .addComponent(passwordButton, GroupLayout.Alignment.TRAILING)
                                        .addComponent(missionButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap())
                );
                userPaneLayout.setVerticalGroup(
                    userPaneLayout.createParallelGroup()
                        .addGroup(userPaneLayout.createSequentialGroup()
                            .addGroup(userPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(attackLabel)
                                .addComponent(infoLabel))
                            .addGap(2, 2, 2)
                            .addGroup(userPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollAttackpane, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollInfoPane, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
                            .addGroup(userPaneLayout.createParallelGroup()
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(missionButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passwordButton)
                                    .addGap(66, 66, 66))
                                .addGroup(userPaneLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51))))
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

                //---- nextButton ----
                nextButton.setText("next");
                nextButton.setVisible(false);

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
                            .addGroup(missionDialogPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, missionDialogPanelLayout.createSequentialGroup()
                                    .addComponent(missionPart1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63))
                                .addGroup(GroupLayout.Alignment.TRAILING, missionDialogPanelLayout.createSequentialGroup()
                                    .addComponent(nextButton)
                                    .addGap(203, 203, 203))))
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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                            .addComponent(nextButton)
                            .addGap(45, 45, 45))
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
    private JButton passwordButton;
    private JScrollPane scrollAttackpane;
    private JTextPane attackPane;
    private JScrollPane scrollInfoPane;
    private JTextPane infoPane;
    private JLabel attackLabel;
    private JLabel infoLabel;
    private JPanel panel1;
    private JPanel mission1Panel;
    private JButton enterHashButton;
    private JTextField providedHashArea;
    private JPanel mission2panel;
    private JButton addWordButton;
    private JTextField wordTextArea;
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
    private JButton nextButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
