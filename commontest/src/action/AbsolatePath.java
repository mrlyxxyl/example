package action;

import java.io.File;

public class AbsolatePath {
    public static void main(String[] args) {
        String dd = AbsolatePath.class.getClassLoader().getResource("lock.png").getPath(); //how to get the local file's path
//        String path = request.getServletContext().getRealPath("/index.jsp");//how to get the jsp file's path
        String ddd = "src/lock.png";
        File file = new File(ddd);
//       FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
        System.out.println(dd);
    }
}
