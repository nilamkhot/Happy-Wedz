package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.dataversity.happywedz.adapter.FrequentlyQuestionAdapter;
import com.dataversity.happywedz.adapter.GenieServiceAdapter;
import com.dataversity.happywedz.utils.Tools;

public class FrequentlyAskedQuestionActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerview;
    LinearLayoutManager category_layoutManager;
    FrequentlyQuestionAdapter frequentlyQuestionAdapter;

    private String question_array[] = {
            "Why should I choose Genie Services?",
            "Do I have to pay for this service?",
            "How can I get the best price for a vendor?",
            "How do I make payment for booking the vendor?",
            "Can I get recommendations for other services as well?"
    };

    private String ans_array[] = {
            "Happywedz Genie services can help you find the right vendor that fits your budget & style! Our genie experts saves you the time & hassle of browsing through hundreds of profiles by suggesting only the most relevant vendors after hearing your requirements. Moreover, HappyWedz has best price guarantees for some of its vendor partners & you can avail of this through the genie service.",
            "The cost for services are flat INR 250 per category for multiple categories, you can avail our package at a nominal rate of INR 800 which includes all categories.",
            "The Happywedz team has pre-negotiated best deals for some of our vendor partners. Once you shortlist some of your favourite vendors, you can reach to your assigned genie expert and they can check back & tell you if the best deal is available for your chosen vendor.",
            "Once you have finalized on the amount & deliverable with your chosen vendor, you can simply pay an advance to the vendor directly as per their payment terms.",
            "Recommendations are available for venues, photographers, makeup artist, mehendi artist, wedding planners, decorators, sangeet choreographers, DJ & catering."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequently_asked_question);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        recyclerview = findViewById(R.id.recyclerview);
        category_layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        frequentlyQuestionAdapter = new FrequentlyQuestionAdapter(context, question_array, ans_array);
        // and adapter for items
        // of the parent recyclerview
        recyclerview.setAdapter(frequentlyQuestionAdapter);
        recyclerview.setLayoutManager(category_layoutManager);

    }
}