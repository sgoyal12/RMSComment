package shubham.sts.com.rmscomment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CommentHolder extends RecyclerView.ViewHolder {

    public TextView tvName,tvDate,tvComment;
    public CommentHolder(@NonNull View itemView) {
        super(itemView);
        tvName=itemView.findViewById(R.id.name);
        tvDate=itemView.findViewById(R.id.date);
        tvComment=itemView.findViewById(R.id.comment);
    }
}
