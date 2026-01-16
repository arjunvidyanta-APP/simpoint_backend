package com.simpoint_enterprice.simpoint.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question_links")
public class AssessmentQuestionLink {
    @EmbeddedId
    private QuestionLinkId id;

//    ******************Question mapping***************
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;
//    ******Assessment mapping************
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("assessmentId")
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    @Column(name = "question_score")
    private Integer questionScore;
}
