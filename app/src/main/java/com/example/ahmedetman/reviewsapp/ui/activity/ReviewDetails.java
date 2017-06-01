package com.example.ahmedetman.reviewsapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ahmedetman.reviewsapp.R;
import com.example.ahmedetman.reviewsapp.models.Datum;

public class ReviewDetails extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);

        getUIControls();
        Bundle bundle = getIntent().getExtras().getBundle(MainActivity.EXTRA_REVIEW_OBJECT);

        if (bundle != null)
        {
            bindingDataToUI((Datum) bundle.getSerializable(MainActivity.BUNDLE_REVIEW_OBJECT));
        }

    }

    TextView title, author,date,message, reviewerCountry;
    RatingBar authorRate;

    /**
     * getting the UI widgets for this activity
     */
    void getUIControls()
    {
        title = (TextView) findViewById(R.id.reviewTitleTextView);
        date = (TextView) findViewById(R.id.dateTextView);
        author = (TextView) findViewById(R.id.authorTextView);
        message = (TextView) findViewById(R.id.messageTextView);
        reviewerCountry = (TextView) findViewById(R.id.reviewerCountryTextView);
        authorRate = (RatingBar) findViewById(R.id.authorRateRatingBar);
    }

    void bindingDataToUI(Datum reviewData)
    {
        title.setText(reviewData.getTitle());
        date.setText(reviewData.getDate());
        author.setText(reviewData.getAuthor());
        message.setText(reviewData.getMessage());
        reviewerCountry.setText(reviewData.getReviewerCountry());
        authorRate.setRating(Float.parseFloat(reviewData.getRating()));
    }
}
