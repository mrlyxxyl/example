package action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

public class UploadAction {
    private File[] image;
    private String[] imageFileName;

    public String execute() throws IOException {
        String filePath = ServletActionContext.getServletContext().getRealPath("/images");
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (int i = 0; i < image.length; i++) {
            FileUtils.copyFile(image[i], new File(file, imageFileName[i]));
        }
        return "success";
    }

    public File[] getImage() {
        return image;
    }

    public void setImage(File[] image) {
        this.image = image;
    }

    public String[] getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String[] imageFileName) {
        this.imageFileName = imageFileName;
    }
}
