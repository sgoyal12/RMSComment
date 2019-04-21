package shubham.sts.com.rmscomment;

public class Comment {
    String commentText;
    String userId;
    String createDate;


    public Comment() {
    }

    public Comment(String commentText, String userId, String createDate) {
        this.commentText = commentText;
        this.userId = userId;
        this.createDate = createDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
