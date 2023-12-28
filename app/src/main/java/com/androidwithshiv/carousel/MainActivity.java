package com.androidwithshiv.carousel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidwithshiv.carousel.adapter.BatDetailsAdapter;
import com.androidwithshiv.carousel.model.BatDetails;
import com.jackandphantom.carouselrecyclerview.CarouselLayoutManager;
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private TextView batName, batPrice;
    private ImageView favrtIcon;
    private BatDetailsAdapter batDetailsAdapter;
    private CarouselRecyclerview carouselRecyclerview;
    private List<BatDetails> batDetailsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        carouselRecyclerview.setAdapter(batDetailsAdapter);
        carouselRecyclerview.setInfinite(true);
        carouselRecyclerview.setAlpha(true);

        carouselRecyclerview.setItemSelectListener(new CarouselLayoutManager.OnSelected() {
            @Override
            public void onItemSelected(int i) {
                batName.setText(batDetailsList.get(i).getName());
                batPrice.setText(batDetailsList.get(i).getPrice());
                if(batDetailsList.get(i).isFavrt())
                    favrtIcon.setImageResource(R.drawable.favorite);
                else favrtIcon.setImageResource(R.drawable.unfavorite);
            }
        });
    }
    public void init(){
        context = MainActivity.this;
        batName = findViewById(R.id.bat_name);
        batPrice = findViewById(R.id.bat_price);
        favrtIcon = findViewById(R.id.favrt_icon);
        carouselRecyclerview = findViewById(R.id.carousel_rv);
        batDetailsList = new ArrayList<>();
        batDetailsList.add(new BatDetails(R.drawable.adidas, "Adidas", "₹7000 /-", false));
        batDetailsList.add(new BatDetails(R.drawable.mrf, "MRF Grand Edition", "₹12000 /-", true));
        batDetailsList.add(new BatDetails(R.drawable.gray_nicolls, "Gray Nicolls", "₹9400 /-", true));
        batDetailsList.add(new BatDetails(R.drawable.kookaburra, "Kookaburra", "₹10900 /-", false));
        batDetailsList.add(new BatDetails(R.drawable.sg, "SG Army", "₹8500 /-", false));
        batDetailsList.add(new BatDetails(R.drawable.ss, "SS ", "₹9900 /-", true));
        batDetailsList.add(new BatDetails(R.drawable.sparten, "Sparten", "₹11000 /-", false));

        batDetailsAdapter = new BatDetailsAdapter(context, batDetailsList);

        batName.setText(batDetailsList.get(0).getName());
        batPrice.setText(batDetailsList.get(0).getPrice());
        if(batDetailsList.get(0).isFavrt())
            favrtIcon.setImageResource(R.drawable.favorite);
        else favrtIcon.setImageResource(R.drawable.unfavorite);
    }
}