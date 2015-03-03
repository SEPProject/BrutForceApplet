package main;

import controller.Controller;
import model.Model;
import view.View;
import java.util.Scanner;


public class Main {



    public static void main (String argv[]){

        Test test = new Test();
        Model model = new Model();
        View view = new View();
        Controller ctrl = new Controller(model,view);
        ctrl.setAppletDescription();
        ctrl.setMissionApplet();
        ctrl.getView().getFirstPage().setVisible(true);

        /*Scanner sc = new Scanner(System.in);
        boolean succeed = false ;
        boolean finished = false ;

      // test.parseFile();

        while (!finished){
            succeed = ctrl.bruteforceAttempt();
            System.out.println("opération : " + succeed);
            System.out.println( "# enter something to continue #");
            if(sc.nextLine().equals("")){
                finished = true;
            }
        }
        System.out.println("*** END ***");
        */

    }



}
