package com.timeline.repository;

import java.util.List;

import com.timeline.model.PO.Detail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DetailRepository extends JpaRepository<Detail, Integer> {

//    static final String ALL_FIELD = "ID, SubjectID, Title, Content, PicUrl, PicDes, AuthorID, ContributorID, "
//            + "OccurrenceTime, Language, ReplyCount, LikeCount, IsValid, CreateTime, UpdateTime";

    Detail findByid(@Param("id") Integer id);

    @Query("SELECT b FROM Detail b WHERE b.subjectID = :subjectID")
    List<Detail> findBysubjectID(Pageable pageable, @Param("subjectID") Integer subjectID);

/*    @Query("SELECT " + ALL_FIELD + " FROM DETAIL WHERE subjectID = :subjectID AND occurrenceTime = :occurrenceTime")
    Detail findBySubjectIDAndOccurrenceTime(@Param("subjectID")Integer subjectID, @Param("occurrenceTime")Date occurrenceTime);*/
}
