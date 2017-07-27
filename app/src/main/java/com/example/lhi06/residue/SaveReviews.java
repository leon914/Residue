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

final class SaveReviews {

    private static final String FILENAME = "albumReviews.json";
    private static final Gson GSON = new Gson();
    private static final Type TYPE_OF_LIST = new TypeToken<List<AlbumReview>>() {}.getType();

    private SaveReviews() {}

    public static String toJsonString(@NonNull final List<AlbumReview> reviews) {
        return GSON.toJson(reviews, TYPE_OF_LIST);
    }

    public static List<AlbumReview> toListOfReviews(@NonNull final String jsonString) {
        return GSON.fromJson(jsonString, TYPE_OF_LIST);
    }

    public static void saveData(@NonNull final List<AlbumReview> reviews, @NonNull final Context context) {
        try {
            final FileOutputStream streamOut = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            streamOut.write(toJsonString(reviews).getBytes());
            streamOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.save_exception, Toast.LENGTH_SHORT).show();
        }
    }

    public static List<AlbumReview> loadData(@NonNull final Context context) {
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
        } catch (final IOException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.load_exception, Toast.LENGTH_SHORT).show();
        }
        return reviews;

    }

}