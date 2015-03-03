package controller;

import model.*;
import view.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Controller implements Controller2Model, Controller2View {

    private Model model ;
    private View view;

    public Controller(Model m ,View v){
        this.model = m;
        this.view = v;
    }

    @Override
    public void setModel(Model m){
        this.model=m;
    }

    @Override
    public Model getModel(){
        return model;
    }

    @Override
    public void setView(View v){
        this.view=v;
    }

    @Override
    public View getView(){
        return view;
    }


    /**
     * set the description of the applet
     */
    public void setAppletDescription(){
        model.setDescription("Through this applet, you will discover" +
                " how \"Brute force\" attacks are performed by Hackers. You" +
                " will also see how you can have a good password.");
        view.setAppletDescriptionText(getModel().getDescription());
    }


    /**
     * set the mission description + parts
     */
    public void setMissionApplet(){

        model.getMission().setDescription("We lost the password of our computer, but we" +
                " have the file where it's stored in the computer that you can see" +
                " clicking on the : passwordfile button. To retrieve it we propose to you" +
                " to use a Brute force attack. ");

        view.setMissionDescriptionText(getModel().getMission().getDescription());

        model.getMission().setPart(0, "1) As you can see the passwordFile is unreadable." +
                " That's because the computer stores encrypted password. Hopefully" +
                " you know the encryption algorithm, then you just need to try words," +
                " encrypt them then compare them to the stored encrypted password. Hopefully" +
                " the encryption is made by the applet. The next step is to build a dictionnary." +
                " It's a file where every suggestion of password are stored and will be browsed " +
                "to be tried. Now add words that you think can be the password. ");

        view.setMissionPart1(getModel().getMission().getPart(0));

    }







    public boolean bruteforceAttempt() {

        String password = "" ;
        String passHashed = "";
        Scanner sc = new Scanner(System.in);
        FileReader fr ;
        BufferedReader br ;
        String attempt;
        Boolean found = false;

        System.out.println("### Starting TEST ###");
        System.out.println(">> Aim of this is to provide a password and the attack is launched !");

        do {
            System.out.println(">> chose a password to Test : ");
            password = sc.nextLine();
        }while (password.equals(""));

        System.out.println(">> hashing the password...");
        model.getPasswordManager().setHashStored(password);
        passHashed = model.getPasswordManager().getHashStored();
        System.out.println(">> password hashed : " + passHashed);
        System.out.println(">> now the aim is to find the password from the hash you succeed to find :" + passHashed);
        System.out.println(" choosing dictionary : worstlist...");

        try{

            fr = new FileReader(model.getFile());
            br = new BufferedReader(fr);

            System.out.println(">> Attack starting... ");

            while (((attempt = br.readLine())!= null) && !found)  {
                System.out.println(">> attempting :" + attempt );
                if (model.getPasswordManager().hash(attempt).equals(passHashed)){
                    found = true;
                    System.out.println(">> SUCCEED password = " + attempt );
                }
            }

            if(!found){
                System.out.println(">> FAILED password not found");
            }
            br.close();

            System.out.println(">> done !");
        }catch(IOException e){
            System.err.println(e);
        }

        return found ;



    }

}
