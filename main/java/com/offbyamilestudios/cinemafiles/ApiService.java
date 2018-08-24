package com.offbyamilestudios.cinemafiles;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

	@GET("movie/popular")
	Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);

	@GET("movie/top_rated")
	Call<MovieResponse> getTopRated(@Query("api_key") String apiKey);

	@GET("movie/upcoming")
	Call<MovieResponse> getUpcoming(@Query("api_key") String apiKey);

	@GET("movie/{movie_id}/videos?")
	Call<TrailerResponse> getMovieTrailer(@Path("movie_id") int movie_id, @Query("api_key") String apiKey);

    @GET( "movie/{movie_id}/reviews?" )
    Call<ReviewResponse> getMovieReviews(@Path("movie_id") int movie_id, @Query("api_key") String apiKey);


}
