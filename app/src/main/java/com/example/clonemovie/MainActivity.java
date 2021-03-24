package com.example.clonemovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView likeButton, dislikeButton;
    TextView likeCountView, dislikeCountView;
    ListView listView;

    CommentAdapter adapter;

    int likeCount = 15;
    int dislikeCount = 1;
    boolean likeState = false;
    boolean dislikeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (ImageView) findViewById(R.id.thumbUp);
        dislikeButton = (ImageView) findViewById(R.id.thumbDown);
        likeCountView = (TextView) findViewById(R.id.thumbUpCount);
        dislikeCountView = (TextView) findViewById(R.id.thumbDownCount);

        listView = (ListView) findViewById(R.id.commentListView);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(likeState || dislikeState)) {
                    // 둘 다 안눌린 상태
                    increaseLikeCount();

                } else {
                    // 둘 중 하나 눌린 상태
                    if (likeState) {
                        // 좋아요 눌린 상태
                        decreaseLikeCount();
                    } else {
                        // 싫어요 눌린 상태
                        decreaseDislikeCount();
                        increaseLikeCount();
                    }
                }
            }
        });
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(likeState || dislikeState)) {
                    // 둘 다 안눌린 상태
                    increaseDislikeCount();
                } else {
                    // 둘 중 하나 눌린 상태
                    if (dislikeState) {
                        // 싫어요 눌린 상태
                        decreaseDislikeCount();
                    } else {
                        // 좋아요 눌린 상태
                        decreaseLikeCount();
                        increaseDislikeCount();
                    }
                }
            }
        });
        ScrollView scrollView = (ScrollView) findViewById(R.id.commentScrollView);
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        adapter = new CommentAdapter();

        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));

        listView.setAdapter(adapter);
    }

    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<>();

        public void addItem(CommentItem item) {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*CommentView view = null;
            if (convertView == null) {
                new CommentView(getApplicationContext());
            } else {
                view = (CommentView) convertView;
            }*/
            CommentView view = new CommentView(getApplicationContext());

            CommentItem comment = items.get(position);

            view.setNickname(comment.getUserNickname());
            view.setComment(comment.getComment());

            return view;
        }
    }

    public void increaseLikeCount() {
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setImageResource(R.drawable.ic_thumb_up_selected);
        likeState = true;
    }

    public void decreaseLikeCount() {
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setImageResource(R.drawable.thumb_up);
        likeState = false;
    }

    public void increaseDislikeCount() {
        dislikeCount += 1;
        dislikeCountView.setText(String.valueOf(dislikeCount));
        dislikeButton.setImageResource(R.drawable.ic_thumb_down_selected);
        dislikeState = true;
    }

    public void decreaseDislikeCount() {
        dislikeCount -= 1;
        dislikeCountView.setText(String.valueOf(dislikeCount));
        dislikeButton.setImageResource(R.drawable.thumb_down);
        dislikeState = false;
    }

}