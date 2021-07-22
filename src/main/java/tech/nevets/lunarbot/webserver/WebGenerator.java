package tech.nevets.lunarbot.webserver;

import java.io.File;
import java.util.Scanner;

public class WebGenerator {

    public static void generator(String args[]) {

        System.out.println();
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        //Using Scanner class to get the folder name from the user
        System.out.println("WebAPI");
        path = path+sc.next();
        //Instantiate the File class
        File f1 = new File(path);
        //Creating a folder using mkdir() method
        boolean bool = f1.mkdir();
        if(bool){
            System.out.println("Folder is created successfully");
        }else{
            System.out.println("Error Found!");
        }

    }
}

