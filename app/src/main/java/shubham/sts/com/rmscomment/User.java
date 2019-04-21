package shubham.sts.com.rmscomment;

public class User {

    String name;
    int commentCount;

    public User(String name,int commentCount) {
        this.name=name;
        this.commentCount = commentCount;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
