package com.offbyamilestudios.cinemafiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NetworkUtils {

	private static URL createUrl(String stringUrl) {
		URL url = null;
		try {
			url = new URL(stringUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
	private static String makeHttpRequest(URL url) throws IOException {
		String jsonResponse = "";
		if (url == null) {
			return jsonResponse;
		}
		HttpURLConnection urlConnection = null;
		BufferedReader bufferedReader = null;

		try {
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			InputStream inputStream = urlConnection.getInputStream();
			StringBuilder stringBuffer = null;
			if (urlConnection.getResponseCode() == 200) {
				inputStream = urlConnection.getInputStream();
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				String line;
				stringBuffer = new StringBuilder();
				while ((line = bufferedReader.readLine()) != null) ;
				stringBuffer.append(line);
			}
			jsonResponse = stringBuffer.toString();

		} else {
	}
	} catch (IOException e) {
} finally {
		if (urlConnection != null) {
			urlConnection.disconnect();
		}
			return jsonResponse;
	}

	private static ArrayList<Review> extractReviewsFromJson(String url) {
	        ArrayList<Review> reviewList = new ArrayList<>();
	        final String MOVIE_ID = "id";
	        final String RESULTS = "results";
	        final String AUTHOR = "author";
	        final String CONTENT = "content";
}




