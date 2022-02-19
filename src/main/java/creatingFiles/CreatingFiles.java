package creatingFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreatingFiles {

    public static void addOrderFile(String order, double price, LocalDateTime localDateTime){
        File file = new File("orders.txt");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(order + " ,"+ price + " , "+ localDateTime + " \n" );
        }
        catch(IOException e ){
            System.out.println("Order dismissed ");
            e.printStackTrace();
        }
    }
}
