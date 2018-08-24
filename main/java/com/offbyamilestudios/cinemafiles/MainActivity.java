package com.offbyamilestudios.cinemafiles;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private static final String CALLBACK_Q = "callbackQuery";
	private static final String CALLBACK_SORT = "callbackMovieSort";
	public static final String KEY = "movies";


	private String queryMovie = "popular";
	private String movieSort = "Popular Movies";
	private List<Movie> movieList;
	private RecyclerView mRecycler;
	ProgressBar mProgressBar;
	private TextView error_display_tv;
	private MaterialButton reload_button;
	private Toolbar mToolbar;
	private MovieAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
    setTitle(movieSort);
    if (!isOnline()) {
      networkError();
    }
      }




	private boolean isOnline() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context
				.CONNECTIVITY_SERVICE);
		assert connectivityManager != null;
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();
		return info != null && info.isConnectedOrConnecting();
	}

	private void initView() {
		mProgressBar = findViewById(R.id.progress_circular);
		error_display_tv = findViewById(R.id.error_text_view);
		mRecycler = findViewById(R.id.poster_rv);
		movieList = new ArrayList<>();
		mAdapter = new MovieAdapter(movieList, getApplicationContext());

				reload_button = findViewById(R.id.reload_button);
				mToolbar = findViewById(R.id.toolbar);
				setSupportActionBar(mToolbar);

				if (mRecycler.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
					mRecycler.setLayoutManager(new GridLayoutManager(this, 4));
				} else {
					mRecycler.setLayoutManager(new GridLayoutManager(this, 2));
				}
				mRecycler.setItemAnimator(new DefaultItemAnimator());
				mRecycler.setHasFixedSize(true);
				mRecycler.setAdapter(mAdapter);

				mAdapter.setMovieList(movieList);
		loadPopular();
	}

	private void loadUpcoming() {
				NetworkUtils NetworkUtils = new NetworkUtils();
							ApiService apiService = NetworkUtils.getClient().create(ApiService.class);
							Call<MovieResponse> call =
									apiService.getUpcoming(BuildConfig.MOVIE_API_KEY); call.enqueue(new Callback<MovieResponse>() {
					@Override
					public void onResponse(Call<MovieResponse> call , Response<MovieResponse> response) {
						List<Movie> movies = response.body().getResults();
						mRecycler.setAdapter(new MovieAdapter(movies, getApplicationContext()));
						mRecycler.smoothScrollToPosition(0);
					}

					@Override
					public void onFailure(Call<MovieResponse> call , Throwable t) {
						Log.d("Error", t.getMessage());

					}

			});
		}






	private void loadPopular() {
		NetworkUtils NetworkUtils = new NetworkUtils();
					ApiService apiService = NetworkUtils.getClient().create(ApiService.class);
					Call<MovieResponse> call =
							apiService.getPopularMovies(BuildConfig.MOVIE_API_KEY); call.enqueue(new Callback<MovieResponse>() {
			@Override
			public void onResponse(Call<MovieResponse> call , Response<MovieResponse> response) {
				List<Movie> movies = response.body().getResults();
				mRecycler.setAdapter(new MovieAdapter(movies, getApplicationContext()));
				mRecycler.smoothScrollToPosition(0);
			}

			@Override
			public void onFailure(Call<MovieResponse> call , Throwable t) {
				Log.d("Error", t.getMessage());

			}

	});
}

	private void loadTopRated() {
			NetworkUtils NetworkUtils = new NetworkUtils();
						ApiService apiService = NetworkUtils.getClient().create(ApiService.class);
						Call<MovieResponse> call =
								apiService.getTopRated(BuildConfig.MOVIE_API_KEY); call.enqueue(new Callback<MovieResponse>() {
				@Override
				public void onResponse(Call<MovieResponse> call , Response<MovieResponse> response) {
					List<Movie> movies = response.body().getResults();
					mRecycler.setAdapter(new MovieAdapter(movies, getApplicationContext()));
					mRecycler.smoothScrollToPosition(0);
				}

				@Override
				public void onFailure(Call<MovieResponse> call , Throwable t) {
					Log.d("Error", t.getMessage());

				}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.bottom_menu , menu);
		return true;
	}

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();
    if (id == R.id.popular_choice) {
      loadPopular();
      setTitle("Popular Movies");
    }
    if (id == R.id.top_rated) {
      loadTopRated();
      setTitle("Top Rated");
    }
    if (id== R.id.upcoming_movie) {
    	loadUpcoming();
    	setTitle("Upcoming");
	}

    return super.onOptionsItemSelected(item);
	}




	public void networkError() {
		error_display_tv.setVisibility(View.VISIBLE);
		reload_button.setVisibility(View.VISIBLE);
	}

	public void clickReload(View view) {
		if (!isOnline()) {
			Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
			view.startAnimation(shake);
      Toast.makeText(this, "Refreshing connection!", Toast.LENGTH_SHORT).show();
			return;
		}
		reload_button.setVisibility(View.INVISIBLE);
		error_display_tv.setVisibility(View.INVISIBLE);
		loadPopular();
	}

	private void hideProgressBar() {
		reload_button.setVisibility(View.INVISIBLE);
		error_display_tv.setVisibility(View.INVISIBLE);

	}



	@Override
	public void onSaveInstanceState(Bundle outState) {
  		outState.getParcelable(KEY);
  		super.onSaveInstanceState(outState);

 }
 	@Override
	public void onResume() {
  	super.onResume();

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putParcelable(KEY, Bundle.EMPTY);
		super.onRestoreInstanceState(savedInstanceState);
	}
}


