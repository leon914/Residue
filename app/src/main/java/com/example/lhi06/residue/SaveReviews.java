package com.example.lhi06.residue;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SaveReviews {

    private final static String FILENAME = "albumReviews.json";
    private final static Gson gson = new Gson();
    private final static Type type = new TypeToken<List<AlbumReview>>() {}.getType();
    private static SaveReviews instance = null;

    public static SaveReviews getInstance() {
        if (instance == null) {
            instance = new SaveReviews();
        }
        return instance;
    }

    public static String toJsonString(@NonNull final List<AlbumReview> reviews) {
        return gson.toJson(reviews, type);
    }

    public static List<AlbumReview> toListOfReviews(final String jsonString) {
        return gson.fromJson(jsonString, type);
    }

    public static void saveData(final List<AlbumReview> reviews, final Context context) {
        try {
            final FileOutputStream streamOut = context.openFileOutput(FILENAME, context.MODE_PRIVATE);
            streamOut.write(toJsonString(reviews).getBytes());
            streamOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.save_exception, Toast.LENGTH_SHORT).show();
        }
    }

    public static List<AlbumReview> loadData(final Context context) {
        List<AlbumReview> reviews = new ArrayList<>();
        try {
            final FileInputStream streamIn = context.openFileInput(FILENAME);
            final BufferedReader streamReader = new BufferedReader(new InputStreamReader(streamIn));
            final StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = streamReader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reviews = toListOfReviews(jsonBuilder.toString());
            streamIn.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.load_exception, Toast.LENGTH_SHORT).show();
        }
        return reviews;

    }

}