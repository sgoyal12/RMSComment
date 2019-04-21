package shubham.sts.com.rmscomment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddComment extends AppCompatActivity {
EditText etComment;
Button submit;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference cref = database.getReference("COMMENT");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
        etComment=findViewById(R.id.editText);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etComment.getText().toString().equals(""))
                {
                    Calendar calendar=Calendar.getInstance();
                    Date date=calendar.getTime();
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate = df.format(date);
                    Comment comment=new Comment(etComment.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getUid()
                    ,formattedDate);
                    cref.push().getRef().setValue(comment);
                    finish();
                }
                else
                {
                    Toast.makeText(AddComment.this,"Please Enter Some Text",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
