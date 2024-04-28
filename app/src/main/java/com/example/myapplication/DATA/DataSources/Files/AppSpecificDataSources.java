package com.example.myapplication.DATA.DataSources.Files;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
public class AppSpecificDataSources {
    private final Context context;
    private final File file;
    private final String fileName;
    public AppSpecificDataSources(Context context, String filename) {
        this.context = context;
        this.fileName = filename;
        this.file = new File(context.getFilesDir(), filename);
        File directory = context.getFilesDir();
        String path = directory.getAbsolutePath();
        Log.e("FILEEEEEEEEEEEEEEEE", path);
    }
    public String readAppSpecificDS() {
        if (!file.exists()) return null;
        FileInputStream fis = null;

        try {
            fis = context.openFileInput(fileName);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String contents = null;
        InputStreamReader istr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(istr)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            contents = stringBuilder.toString();
        }
        return contents;
    }
    public void writeAppSpecificDS(@NonNull String fileContents) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(fileContents.getBytes());
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}