package gui;
import java.io.IOException;  
import java.net.MalformedURLException;  
import java.net.URL;  
  
public class UseBrowser {  
    public static void main(String[] args) {  
        URL url = null;  
        try {  
            url = new URL("http://www.baidu.com");  
        } catch (MalformedURLException e1) {  
            e1.printStackTrace();  
        }  
        try {  
            Runtime.getRuntime().exec(  
                    "rundll32 url.dll,FileProtocolHandler "  
                            + url);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  