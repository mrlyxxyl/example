package gui;
import java.io.IOException;  
  
public class useNotepad {  
    public static void main(String[] args) {  
          
        try {  
            Runtime.getRuntime().exec("notepad");
        } catch (IOException e) {  
            e.printStackTrace();
        }  
    }  
}  