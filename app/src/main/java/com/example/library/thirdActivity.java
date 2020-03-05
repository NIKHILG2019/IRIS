package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class thirdActivity extends AppCompatActivity {
    private EditText enter_author;
    private EditText enter_edition;
    private EditText editText;
    private EditText enter_title;
    private Button submit;

    //keys
    public static final String KEY_TITLE = "title";
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_EDITION = "edition";
    public static final String KEY_EMAIL = "email";
    private static final String TAG = "thirdActivity";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private DocumentReference  Booksref = db.collection("Books").document("First book");
    private CollectionReference collectionReference = db.collection("Books");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        submit = findViewById(R.id.submit);
        enter_title = findViewById(R.id.enter_title);
        enter_author = findViewById(R.id.enter_author);
        enter_edition = findViewById(R.id.enter_edition);
        editText = findViewById(R.id.editText);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = enter_title.getText().toString().trim();
                String edition = enter_edition.getText().toString().trim();
                String author = enter_author.getText().toString().trim();
                String email = editText.getText().toString().trim();

                Map<String, Object> data = new HashMap<>();
                data.put(KEY_TITLE,title);
                data.put(KEY_AUTHOR,author);
                data.put(KEY_EDITION,edition);
                data.put(KEY_EMAIL,email);

                db.collection("Books")
                        .document("First book")
                        .set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(thirdActivity.this,"success",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG,"onFailure:" + e.toString());



                            }
                        });

            }
        });
    }
}
