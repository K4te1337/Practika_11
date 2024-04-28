package com.example.myapplication.DATA.DataSources.Files;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import androidx.core.content.ContextCompat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CommonFileDataSources {
    private final String fileName;
    private final Context context;
    private File file;
    public CommonFileDataSources(Context context, String fileName) {
        this.fileName = fileName;
        this.context = context;
    }
    public boolean writeContent(String inputContent) {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            if (checkPermission()) {
                File sdcard = Environment.getExternalStorageDirectory();
                File dir = new File(sdcard.getAbsolutePath() + "/MyDir/");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                file = new File(dir, fileName + ".txt");
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file);
                    fos.write(inputContent.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public String readFile() {
        if (file == null || !file.exists() || file.length() == 0) {
            return "";
        }

        FileInputStream fis = null;
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }
}