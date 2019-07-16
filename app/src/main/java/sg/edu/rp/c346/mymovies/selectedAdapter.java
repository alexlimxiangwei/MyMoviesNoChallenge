package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class selectedAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Movie> objects;

    public selectedAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(resource, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvGenre = rowView.findViewById(R.id.tvGenre);
        ImageView ivRated = rowView.findViewById(R.id.ivRated);

        TextView tvWatched = rowView.findViewById(R.id.tvWatched);
        TextView tvTheatre = rowView.findViewById(R.id.tvTheatre);
        TextView tvDesc = rowView.findViewById(R.id.tvDesc);

        RatingBar rb =rowView.findViewById(R.id.ratingBar);

        // Obtain the Android Version information based on the position
        Movie movie = objects.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(movie.getTitle());
        tvYear.setText(movie.getYear() + " - ");
        tvGenre.setText(movie.getGenre());



        if(movie.getRated().equalsIgnoreCase("g")) {
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if(movie.getRated().equalsIgnoreCase("pg")){
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if(movie.getRated().equalsIgnoreCase("pg13")){
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else if(movie.getRated().equalsIgnoreCase("nc16")){
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if(movie.getRated().equalsIgnoreCase("m18")){
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else{
            ivRated.setImageResource(R.drawable.rating_r21);
        }

        tvDesc.setText("\n" + movie.getDescription());
        tvWatched.setText("\nWatched on : " + new SimpleDateFormat("dd/MM/yyyy").format(movie.getWatched_on().getTime()));
        tvTheatre.setText("In Theatre : " + movie.getIn_theatre());
        rb.setRating(movie.getRating());

        return rowView;
    }


}
