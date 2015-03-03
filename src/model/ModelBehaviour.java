package model;
import controller.*;
import java.io.*;

/**
 * model interface
 */
public interface ModelBehaviour {

    /**
     * set the controller of the model
     * @param c
     */
    public void setController(Controller c);

    /**
     * return the worst password file
     * @return
     */
    public File getFile();

    /**
     * return the password manager of the model
     * @return
     */
    public PasswordManager getPasswordManager();

    /**
     * return the mission class of the model
     * @return
     */
    public Mission getMission();

    /**
     * return the description of the applet
     * @return
     */
    public String getDescription();

    /**
     * set the description of the applet
     * @param s
     */
    public void setDescription(String s);
}
