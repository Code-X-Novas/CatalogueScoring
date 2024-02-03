package com.example.cataloguescoring;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // Retrieve the NLP result and catalog score from the intent
        String nlpResult = getIntent().getStringExtra("NLP_RESULT");
        int catalogScore = getIntent().getIntExtra("CATALOG_SCORE", 0);

        // Now you can use these values in your UI
        // For example, display in TextViews, show in a dialog, etc.
        displayResultsInUI(nlpResult, catalogScore);
    }

    private void displayResultsInUI(String nlpResult, int catalogScore) {
    }

}
