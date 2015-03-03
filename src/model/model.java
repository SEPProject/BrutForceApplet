package model;

import controller.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * model : manage the stored data of the application
 */
public class Model implements ModelBehaviour {

    public Controller controller;

    /**
     * a list of the worst password
     */
    public File worstList;

    /**
     * the file where the password to find is stored
     */
    private File passwordFile;

    /**
     * the password manager
     */
    private PasswordManager passManager;

    /**
     * the description of the applet : summary
     */
    private String description;

    /**
     * mission of the applet
     */
    private Mission appletMission ;

    public Model(){
        init();
    }

    /**
     * initialize the model :
     * set the worst password file
     * set the password manager
     * set the mission
     */
    public void init(){
            worstList = new File("./data/worstList.txt");
            passManager = new PasswordManager();
            appletMission = new Mission();

    }

    public File getWorstList() {
        return worstList;
    }

    @Override
    public void setController(Controller c){
        this.controller = c;
    }

    @Override
    public File getFile(){
        return worstList;
    }

    @Override
    public PasswordManager getPasswordManager(){
        return passManager;
    }

    @Override
    public Mission getMission(){
        return appletMission;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public void setDescription(String s){
        description = s;
    }


}
