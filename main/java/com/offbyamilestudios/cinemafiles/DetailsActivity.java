package com.offbyamilestudios.cinemafiles;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

  ImageView imageView;
  ImageView posterView;
  TextView text_title;
  TextView plot_tv;
  TextView release_view;
  TextView ratings_tv;
  TextView credits_tv;
  TextView genre_tv;
  FloatingActionButton mFab;

  private List<Review> reviewList;
  public static final String EXTRA_MOVIE = "movies";
  Bundle arguments;

  private ReviewAdapter reviewAdapter;
  private RecyclerView reviewRecycler;
  String  title, overview, rating, release_date, backdrop_path;
  Movie movies;
  //int movie_id;

  private static final String URL_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";
  private static final String URL_BACKDROP_PATH = "http://image.tmdb.org/t/p/w1280";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_details);

	Intent intent = getIntent().getParcelableExtra(Movie.TAG);



    mFab = findViewById(R.id.fab_add);
    imageView = findViewById(R.id.image_view);
    text_title = findViewById(R.id.title_tv);
    plot_tv = findViewById(R.id.plot_overview);
    release_view = findViewById(R.id.release_view);
    ratings_tv = findViewById(R.id.rating_view);
    //genre_tv = findViewById(R.id.genre_text_view);



	  		String title = getIntent().getStringExtra("title");
	  		//String poster_path = getIntent().getStringExtra("poster");
	  		String overview = getIntent().getStringExtra("overview");
	  		String rating = getIntent().getStringExtra("rating");
	  		String release_date = getIntent().getStringExtra("release_date").substring(0, 4);
	  		String backdrop_path = getIntent().getStringExtra("backdrop_path");


      text_title.setText(title);
      plot_tv.setText(overview);
      release_view.setText(release_date);
      ratings_tv.setText(rating.concat("/10"));

      Picasso.with(this).load(URL_BACKDROP_PATH.concat(backdrop_path)).into(imageView);
    /*  initReviews();

}

  private void initReviews() {
    reviewList = new ArrayList<>();
    reviewAdapter = new ReviewAdapter(this, reviewList);

    reviewRecycler = findViewById(R.id.rv_reviews);
    LinearLayoutManager reviewLayoutManager = new LinearLayoutManager(getApplicationContext());
    reviewRecycler.setLayoutManager(reviewLayoutManager);
    reviewRecycler.setAdapter(reviewAdapter);
    reviewAdapter.notifyDataSetChanged();

     loadReview();



       }

     public void loadReview() {
       NetworkUtils NetworkUtils = new NetworkUtils();
       ApiService apiService =
           com.offbyamilestudios.cinemafiles.NetworkUtils.getClient().create(ApiService.class);
       Call<ReviewResponse> call = apiService.getMovieReviews(movie_id, BuildConfig.MOVIE_API_KEY);
       call.enqueue(
           new Callback<ReviewResponse>() {
             @Override
             public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
               List<Review> reviewList = response.body().getResults();
               reviewRecycler.setAdapter(new ReviewAdapter(getApplicationContext(), reviewList));
               reviewRecycler.smoothScrollToPosition(0);
             }

             @Override
             public void onFailure(Call<ReviewResponse> call, Throwable t) {
               Log.d("Error", t.getMessage());
               Toast.makeText(DetailsActivity.this, "Error fetching reviews data", Toast.LENGTH_SHORT)
                   .show();
             }
           }); */
    }
  }









