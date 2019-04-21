package shubham.sts.com.rmscomment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentHolder> {

    ArrayList<Comment> commentsList;
    LayoutInflater inflater;
    Context context;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("USER");

    public CommentAdapter(@NonNull Context context,ArrayList<Comment> commentsList) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.commentsList =commentsList;
        this.context = context;

    }
    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View output=inflater.inflate(R.layout.comment_layout,viewGroup,false);
        return new CommentHolder(output);
    }

    @Override
    public void onBindViewHolder(@NonNull final CommentHolder commentHolder, int i) {
        Comment comment=commentsList.get(i);
        commentHolder.tvComment.setText(comment.getCommentText());
        commentHolder.tvDate.setText(comment.getCreateDate());
        final DatabaseReference reference=ref.child(comment.getUserId());
        reference.child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                commentHolder.tvName.setText(dataSnapshot.getValue(String.class));
                reference.removeEventListener(this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }
}
