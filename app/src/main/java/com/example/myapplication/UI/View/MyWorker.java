package com.example.myapplication.UI.View;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.TimeUnit;
public class MyWorker extends Worker {
    private final static String TAG = "MyTag";
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }
    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "Приложение запустилось");
        try {
            TimeUnit.SECONDS.sleep(60);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "Приложение запущено уже 1 минуту, покорми кота");
        return Result.success();
    }
}