package com.timeline.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.timeline.model.PO.DetailPO;

@Transactional
public interface DetailRepository extends JpaRepository<DetailPO, Integer> {

    static final String ALL_FIELD = "ID, SubjectID, Title, Content, PicUrl, PicDes, AuthorID, ContributorID, "
            + "OccurrenceTime, Language, ReplyCount, LikeCount, IsValid, CreateTime, UpdateTime";

    @Query("SELECT b FROM DetailPO b WHERE b.ID = :id")
    DetailPO findByID(@Param("id") Integer id);

    //TODO: add pagingAndSort
    @Query("SELECT b FROM DetailPO b WHERE b.SubjectID = :subjectID")
    List<DetailPO> findBySubjectID(@Param("subjectID")Integer subjectID);

    //TODO: add pagingAndSort
    @Query("SELECT b FROM DetailPO b WHERE b.OccurrenceTime = :occurrenceTime")
    List<DetailPO> findByOccurrenceTime(@Param("occurrenceTime")Date occurrenceTime);

/*    @Query("SELECT " + ALL_FIELD + " FROM DETAIL WHERE subjectID = :subjectID AND occurrenceTime = :occurrenceTime")
    DetailPO findBySubjectIDAndOccurrenceTime(@Param("subjectID")Integer subjectID, @Param("occurrenceTime")Date occurrenceTime);*/
}
