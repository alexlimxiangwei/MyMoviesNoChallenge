package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    CustomAdapter caMovie;
    ArrayList<Movie> alMovie;
    SimpleDateFormat sdf;
    Calendar cal1;
    Calendar cal2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sdf = new SimpleDateFormat("dd/MM/yyyy");
        cal1 = Calendar.getInstance();
        cal2 = cal1;


        lvMovie = findViewById(R.id.lvMovies);
        alMovie = new ArrayList<>();

        try {
            cal1.setTime((sdf.parse("15/11/2014")));
            alMovie.add(new Movie("The Avengers","2012","pg13","Action | Sci-Fi",cal1 ,"Golden Vilage - Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.",4));
            cal2.setTime((sdf.parse("15/5/2015")));
            alMovie.add(new Movie("Planes","2013","pg","Animation | Comedy",cal2,"Cathay - AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        caMovie = new CustomAdapter(this,R.layout.row,alMovie);
        lvMovie.setAdapter(caMovie);



        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,selectedMovie.class);
                intent.putExtra("title",alMovie.get(position).getTitle());
                intent.putExtra("year",alMovie.get(position).getYear());
                intent.putExtra("rated",alMovie.get(position).getRated());
                intent.putExtra("genre",alMovie.get(position).getGenre());
                intent.putExtra("watched_on",alMovie.get(position).getWatched_on().toString());
                intent.putExtra("in_theatre",alMovie.get(position).getIn_theatre());
                intent.putExtra("desc",alMovie.get(position).getDescription());
                intent.putExtra("rating",alMovie.get(position).getRating());
                startActivity(intent);

            }
        });

    }

}
