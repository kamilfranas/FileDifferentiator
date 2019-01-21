package main;

import main.extensions.ExtensionWarehouse;
import main.files.FileChecker;
import main.comparisons.FileToNameComparison;

import java.io.File;
import java.util.Scanner;

public class FileDifferentiator {

    public static void main(String[] args) {
        while(true) {
            System.out.println("File Differentiator");
            System.out.println("Enter the files path");
            Scanner sc = new Scanner(System.in);
            String filePath = sc.nextLine();
            File f = new File(filePath);

            while (!FileChecker.checkFile(filePath) || f.length() < 1 ) {
                if(f.length() < 1) {
                    System.out.println("File has 0 bytes. Try another one.");
                } else System.out.println("File path is incorrect. Try another one.");
                filePath = sc.nextLine();
                f = new File(filePath);
            }

            FileToNameComparison ftnc = new FileToNameComparison(filePath, new ExtensionWarehouse().getExtensions());
            String exFileName = ftnc.getFromName();
            String exFile = ftnc.getFromFile();

            if (ftnc.compareNameToFileExtension()) {
                System.out.println("Extension is true (" + exFileName + ")");
            } else {
                if(exFile!=null){
                    System.out.println("Extension is " + exFileName + " while actually is " + exFile);
                }
            }

            System.out.println("To check another files enter Y and press enter\n" +
                    "To close the program press any key and enter");
            if (!sc.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Goodbye!");
                sc.close();
                break;
            }
        }
    }

}
