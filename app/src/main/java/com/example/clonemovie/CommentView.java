package com.example.clonemovie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class CommentView extends LinearLayout {
    TextView nickname, comment, recommandCount;

    public CommentView(Context context) {
        super(context);
        init(context);
    }

    public CommentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_view, this, true);

        nickname = (TextView) findViewById(R.id.userNickname);
        comment = (TextView) findViewById(R.id.comment);
        recommandCount = (TextView) findViewById(R.id.recommandCount);
    }

    public void setComment(String text) {
        comment.setText(text);
    }

    public void setNickname(String user) {
        nickname.setText(user);
    }

    public TextView getNickname() {
        return nickname;
    }

    public void setRecommandCount(String num) {
        recommandCount.setText(num);
    }
}
