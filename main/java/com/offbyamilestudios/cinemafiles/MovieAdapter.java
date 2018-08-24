package com.offbyamilestudios.cinemafiles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
  private static final String IMAGE_URL_PATH = "http://image.tmdb.org/t/p/w500";
  Context mContext;
  private List<Movie> movieList;
  Movie mMovie;

  public MovieAdapter(List<Movie> movieList, Context context) {
    this.movieList = movieList;
    this.mContext = context;
  }

  @Override
  public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.grid_items, parent, false);
    final MovieViewHolder viewHolder = new MovieViewHolder(view);
    view.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
			int position = viewHolder.getAdapterPosition();
        	Intent intent = new Intent(mContext, DetailsActivity.class);
			  Bundle bundle = new Bundle();
			  bundle.putString("EXTRA_MOVIE", "movies");
			  intent.putExtras(bundle);
			  		intent.putExtra("title", movieList.get(position).getmTitle());
			  		intent.putExtra("poster", movieList.get(position).getmMoviePoster());
			  		intent.putExtra("overview", movieList.get(position).getmPlot());
			  		intent.putExtra("rating", movieList.get(position).getmRating());
			  		intent.putExtra("release_date", movieList.get(position).getmReleaseDate());
			  		intent.putExtra("backdrop_path", movieList.get(position).getBackdrop());
					mContext.startActivity(intent);
          }
        });
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(MovieViewHolder holder, int position) {
  	Movie movies = movieList.get(position);

    Picasso.with(mContext)
        .load(IMAGE_URL_PATH.concat(movieList.get(position).getmMoviePoster()))
        .fit()
        .into(holder.imageViewHolder);
  }

  @Override
  public int getItemCount() {
    return movieList.size();
  }

  class MovieViewHolder extends RecyclerView.ViewHolder {
    ImageView imageViewHolder;

    MovieViewHolder(final View itemView) {
      super(itemView);
      imageViewHolder = itemView.findViewById(R.id.poster_iv);
    }
  }
	public void setMovieList(List<Movie> movieList) {
	            this.movieList = new ArrayList<>();
	            this.movieList.addAll(movieList);
	            notifyDataSetChanged();
	        }
}



