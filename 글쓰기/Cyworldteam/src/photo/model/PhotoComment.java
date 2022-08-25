package photo.model;

import java.util.Date;

public class PhotoComment {
   private int commentNum;
   private String comment;
   private Date commentRegDate;
   private Date commentModDate;
   private int photoNum;
   private String userId;
   public PhotoComment() {
      
   }
   public PhotoComment(int commentNum, String comment, Date commentRegDate, Date commentModDate, int photoNum,
         String userId) {
      super();
      this.commentNum = commentNum;
      this.comment = comment;
      this.commentRegDate = commentRegDate;
      this.commentModDate = commentModDate;
      this.photoNum = photoNum;
      this.userId = userId;
   }
   public int getCommentNum() {
      return commentNum;
   }
   public void setCommentNum(int commentNum) {
      this.commentNum = commentNum;
   }
   public String getComment() {
      return comment;
   }
   public void setComment(String comment) {
      this.comment = comment;
   }
   public Date getCommentRegDate() {
      return commentRegDate;
   }
   public void setCommentRegDate(Date commentRegDate) {
      this.commentRegDate = commentRegDate;
   }
   public Date getCommentModDate() {
      return commentModDate;
   }
   public void setCommentModDate(Date commentModDate) {
      this.commentModDate = commentModDate;
   }
   public int getPhotoNum() {
      return photoNum;
   }
   public void setPhotoNum(int photoNum) {
      this.photoNum = photoNum;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   @Override
   public String toString() {
      return "PhotoComment [commentNum=" + commentNum + ", comment=" + comment + ", commentRegDate=" + commentRegDate
            + ", commentModDate=" + commentModDate + ", photoNum=" + photoNum + ", userId=" + userId + "]";
   }
   
   

}