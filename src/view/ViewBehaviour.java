package view;

import controller.*;
import javax.swing.*;

/**
 * view interface
 */
public interface ViewBehaviour {

    /**
     * set the controller of the view
     * @param p
     */
    public void setController(Controller p);

    /**
     * return the controller of the view
     * @return
     */
    public Controller getController();

    /**
     * return the first page : description of the applet and starting one
     * @return
     */
    public JFrame getFirstPage();

    /**
     * set the applet description on the first page
     * @param s
     */
    public void setAppletDescriptionText(String s);

    /**
     * set the description of the mission
     * @param s
     */
    public void setMissionDescriptionText(String s);

    /**
     * set the part1 of the mission
     * @param s
     */
    public void setMissionPart1 (String s);

}
