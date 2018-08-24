package com.offbyamilestudios.cinemafiles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {

	private Context mContext;
	private List<Review> reviewList;

	public ReviewAdapter(Context context, List<Review> reviewList) {
		this.mContext = context;
		this.reviewList = reviewList;
	}
	@Override
	public ReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_items, parent, false);
		return new ReviewHolder(view);
	}
	@Override
	public void onBindViewHolder(ReviewHolder holder, final int position) {
		holder.mAuthor.setText(reviewList.get(position).getAuthor());
		holder.mContent.setText(reviewList.get(position).getContent());
		holder.mUrl.setText(reviewList.get(position).getUrl());
}
	@Override
	public int getItemCount() {
		return reviewList.size();
	}

	public class ReviewHolder extends RecyclerView.ViewHolder {
		public TextView mAuthor;
		public TextView mContent;
		public TextView mUrl;

		public ReviewHolder(View itemView) {
			super(itemView);
			mAuthor = itemView.findViewById(R.id.author_tv);
			mContent = itemView.findViewById(R.id.content_tv);
			mUrl = itemView.findViewById(R.id.url_text);
		}

	}
}
