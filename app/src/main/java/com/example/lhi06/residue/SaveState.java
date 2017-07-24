package com.example.lhi06.residue;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lhi06 on 24/07/2017.
 */

public class SaveState implements Serializable {

    private static SaveState instance = null;

    public static SaveState getInstance() {
        if (instance == null) {
            instance = new SaveState();
        }
        return instance;
    }

        public static void saveData(final List<AlbumReview> reviews, Context context) {
            ObjectOutput out;
            try {
                File outFile = new File(Environment.getExternalStorageDirectory(), "albumReviews.data");
                out = new ObjectOutputStream(new FileOutputStream(outFile));
                out.writeObject(instance);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(context, R.string.load_exception, Toast.LENGTH_SHORT).show();
            }
    }

    public static List<AlbumReview> loadData(Context context) {
        ObjectInput in;
        List<AlbumReview> ss = null;
        try {
            in = new ObjectInputStream(new FileInputStream("albumReviews.data"));
            ss = (List<AlbumReview>) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.load_exception, Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context, R.string.class_exception, Toast.LENGTH_SHORT).show();
        }
        return ss;
    }
}