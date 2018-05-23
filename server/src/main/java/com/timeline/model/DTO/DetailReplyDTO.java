package com.timeline.model.DTO;

import java.util.List;

public class DetailReplyDTO {
  
  private Integer ID;

  private Integer DetailID;

  private String Title;

  private String Content;

  private Integer AuthorID;
  
  private Integer ToReplyID;
  
  private List<DetailReplyDTO> subReplies;
  
  public Integer getID() {
    return ID;
  }

  public void setID(Integer ID) {
    this.ID = ID;
  }

  public Integer getDetailID() {
    return DetailID;
  }

  public void setDetailID(Integer detailID) {
    DetailID = detailID;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public String getContent() {
    return Content;
  }

  public void setContent(String content) {
    Content = content;
  }

  public Integer getAuthorID() {
    return AuthorID;
  }

  public void setAuthorID(Integer authorID) {
    AuthorID = authorID;
  }

  public List<DetailReplyDTO> getSubReplies() {
    return subReplies;
  }

  public void setSubReplies(List<DetailReplyDTO> subReplies) {
    this.subReplies = subReplies;
  }

  public Integer getToReplyID() {
    return ToReplyID;
  }

  public void setToReplyID(Integer toReplyID) {
    ToReplyID = toReplyID;
  }
}