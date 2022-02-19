package creatingFiles;


import database.DatabaseOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class OperatingFiles {

    public static void readAndInsertToDB(){
        File file = new File("orders.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String []orders = sc.nextLine().split(",");
                String breadType = orders[0];
                String meatType = orders[1];
                String saladType = orders[2];
                String price = orders[3];
                String date = orders[4];
                int bread_id = breadID(breadType);
                int meat_id = meatID(meatType);
                int salad_id = saladID(saladType);
                DatabaseOperation.insertInfoToDB(3,bread_id,meat_id,salad_id, LocalDateTime.now());

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    private static int breadID (String b){
        if (b.equals("whole")){
            return 2;
        }else {
            return 1;
        }
    }

    private static int saladID(String k){
        return switch (k) {
            case "russian" -> 1;
            case "lyutenica" -> 2;
            case "snejanka" -> 3;
            case "Cabbage and Carrots" -> 4;
            case "tomatoes and cucumber" -> 5;
        };
    }
    private static int meatID(String m){
        return switch (m){
          case "meatball" -> 1;
          case "pleskavica" -> 2;
          case "steak"-> 3;
        };
    }
}
