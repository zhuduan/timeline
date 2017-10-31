package com.timeline.model.PO;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DETAIL")
public class Detail {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "subjectID", nullable = false)
    private Integer subjectID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public Detail() {
        
    }

    public Detail(Integer id, Integer subjectID) {
        this.id = id;
        this.subjectID = subjectID;
    }
}
