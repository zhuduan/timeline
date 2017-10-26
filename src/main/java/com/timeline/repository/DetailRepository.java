package com.timeline.repository;

import com.timeline.model.PO.DetailPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DetailRepository extends JpaRepository<DetailPO, Integer> {

    static final String ALL_FIELD = "ID, SubjectID, Title, Content, PicUrl, PicDes, AuthorID, ContributorID, "
            + "OccurrenceTime, Language, ReplyCount, LikeCount, IsValid, CreateTime, UpdateTime";

    @Query("SELECT " + ALL_FIELD +" FROM DetailPO WHERE ID = :id")
    DetailPO findByID(@Param("id") Integer id);

    //TODO: add pagingAndSort
    List<DetailPO> findBySubjectID(Integer subjectID);

    //TODO: add pagingAndSort
    List<DetailPO> findByOccurrenceTime(Date occurrenceTime);

    DetailPO findBySubjectIDAndOccurrenceTime(Integer subjectID, Date occurrenceTime);
}
