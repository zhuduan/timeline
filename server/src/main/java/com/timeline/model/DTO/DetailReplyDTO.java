package com.timeline.model.DTO;

import com.timeline.support.common.ControllerException;
import com.timeline.support.common.ErrorType;
import com.timeline.support.utils.LogUtil;
import com.timeline.support.utils.NumberUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class DetailReplyDTO {

    private Integer ID;

    private Integer DetailID;

    private String Title;

    private String Content;

    private Integer AuthorID;

    private UserDTO User;

    private Integer ToReplyID;

    private Date CreateTime;

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

    public UserDTO getUser() {
        return User;
    }

    public void setUser(UserDTO user) {
        User = user;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public void validate() throws ControllerException {
        if (!NumberUtil.isPositiveAndValid(DetailID) || !NumberUtil.isPositiveAndValid(AuthorID)) {
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: detailID=" + DetailID + ", authorID=" + AuthorID));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
        if (StringUtils.isEmpty(Title) && StringUtils.isEmpty(Content)) {
            LogUtil.appLog.info(LogUtil.getMsg("wrong input for: title=" + Title + ", content=" + Content));
            throw new ControllerException(ErrorType.INVALID_INPUT_PARAM);
        }
        if (ToReplyID == null) {
            ToReplyID = 0;
        }
    }
}