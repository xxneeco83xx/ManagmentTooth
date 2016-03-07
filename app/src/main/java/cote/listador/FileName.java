package cote.listador;

import android.provider.MediaStore;

import java.util.List;

/**
 * Created by Nicolas Buzzi on 3/6/2016.
 */
public class FileName {

    private String contentType;
    private String fileName;
    private String extensionType;
    private String fullPath;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getExtensionType() {
        return extensionType;
    }

    public void setExtensionType(String extensionType) {
        this.extensionType = extensionType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
