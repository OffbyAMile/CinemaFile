package com.offbyamilestudios.cinemafiles;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {
    public static final String TAG = "Movie";

    public static final Creator<Movie> CREATOR =
         new Creator<Movie>() {
           @Override
           public Movie createFromParcel(Parcel in) {
             return new Movie(in);
           }

           @Override
           public Movie[] newArray(int size) {
             return new Movie[size];
           }
         };

    private static final SparseArray<String> genre = new SparseArray<String>() {{
            put(28, "Action");
            put(12, "Adventure");
            put(16, "Animation");
            put(35, "Comedy");
            put(80, "Crime");
            put(99, "Documentary");
            put(18, "Drama");
            put(14, "Fantasy");
            put(36, "History");
            put(37, "Western");
            put(27, "Horror");
            put(53, "Thriller");
            put(878, "Science Fiction");
            put(9648, "Mystery");
            put(10402, "Music");
            put(10749, "Romance");
            put(10769, "Foreign");
            put(10770, "TV Movie");
            put(10751, "Family");
            put(10752, "War");
        }};

 @Expose
 @SerializedName("id")
 private Integer mId;

@Expose
@SerializedName("genre_ids")
private List<Integer> genreIds = new ArrayList<>();

 @Expose
  @SerializedName("title")
  private String mTitle;

  @Expose
  @SerializedName("poster_path")
  private String mMoviePoster;

  @Expose
  @SerializedName("overview")
  private String mPlot;

  @Expose
  @SerializedName("vote_average")
  private String mRating;

  @Expose
  @SerializedName("release_date")
  private String mReleaseDate;

  @Expose
  @SerializedName("backdrop_path")
  private String mBackdrop;

    /* Parcelable Methods */
    private Movie(Parcel in) {
       mId = in.readInt();
       genreIds = new ArrayList<>();
       in.readList(genreIds, List.class.getClassLoader());
       mTitle = in.readString();
       mMoviePoster = in.readString();
       mPlot = in.readString();
       mRating = in.readString();
       mReleaseDate = in.readString();
       mBackdrop = in.readString();
     }

	@Override
 public int describeContents() {
   return 0;
 }

	@Override
 public void writeToParcel(Parcel dest, int flags) {
   dest.writeInt(mId);
   dest.writeList(genreIds);
   dest.writeString(mTitle);
   dest.writeString(mMoviePoster);
   dest.writeString(mPlot);
   dest.writeString(mRating);
   dest.writeString(mReleaseDate);
   dest.writeString(mBackdrop);
 }



  public Integer getmId() {
 return mId;
  }

  public void setmId(Integer mId) {
   this.mId = mId;
  }

	public List<Integer> getGenreIds() {
	        return genreIds;
	    }

	    public void setGenreIds(List<Integer> genreIds) {
	        this.genreIds = genreIds;
	    }

	    public String getGenres() {
	        String genreString = "";
	        for (Integer id : genreIds) {
	            genreString += genre.get(id) + ", ";
	        }

	        return genreString.substring(0, genreString.lastIndexOf(","));
	    }

  public String getmTitle() {
    return mTitle;
  }

  public void setmTitle(String mTitle) {
    this.mTitle = mTitle;
  }

  public String getmMoviePoster() {
    return mMoviePoster;
  }

  public void setmMoviePoster(String mMoviePoster) {
    this.mMoviePoster = mMoviePoster;
  }

  public String getmPlot() {
    return mPlot;
  }

  public void setmPlot(String mPlot) {
    this.mPlot = mPlot;
  }

  public String getmRating() {
    return mRating;
  }

  public void setmRating(String mRating) {
    this.mRating = mRating;
  }

  public String getmReleaseDate() {
    return mReleaseDate;
  }

  public void setmReleaseDate(String mReleaseDate) {
    this.mReleaseDate = mReleaseDate;
  }

  public String getBackdrop() {
    return mBackdrop;
  }

  public void setBackdrop(String mBackdrop) {
    this.mBackdrop = mBackdrop;
  }

	@Override
	    public String toString() {
	        return "Title : " + getmTitle() +
					"\nId : " + getmId() +
	                "\nGenre : " + getGenres() +
	                "\nRating : " + getmRating() + "/10" +
	                "\nRelease Date : " + getmReleaseDate() +
	                "\n\n\n" + getmPlot();
	    }
}


