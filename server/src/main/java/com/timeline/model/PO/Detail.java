package com.timeline.model.PO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
@Table(name = "DETAIL")
public class Detail {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "subjectID", nullable = false)
    private Integer subjectID;
}
