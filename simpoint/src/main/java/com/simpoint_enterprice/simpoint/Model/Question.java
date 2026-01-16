package com.simpoint_enterprice.simpoint.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "publish_date", nullable = false)
    private LocalDateTime publishDate;

    @Column(name = "question_content", columnDefinition = "LONGTEXT", nullable = false)
    private String questionContent;

    @Column(name = "question_title", nullable = false, unique = true)
    private String questionTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private QuestionStatus status;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "guid")
    private String guid;

    @Column(name = "menu_order")
    private Long menuOrder;

    @Column(name = "correct_msg", columnDefinition = "LONGTEXT")
    private String correctMsg;

    @Column(name = "incorrect_msg", columnDefinition = "LONGTEXT")
    private String incorrectMsg;

    @Column(name = "correct_same_text", nullable = false)
    private Boolean correctSameText;

    @Column(name = "hint_enabled", nullable = false)
    private Boolean hintEnabled;

    @Column(name = "hint_msg", columnDefinition = "LONGTEXT")
    private String hintMsg;

    @Enumerated(EnumType.STRING)
    @Column(name = "answer_type", nullable = false)
    private AnswerType answerType;
    @Column(name = "answer_data", columnDefinition = "LONGTEXT", nullable = false)
    private String answerData;

    @Column(name = "question_type", nullable = false)
    private String questionType;

    @Column(name = "question_category")
    private Long questionCategory;

    // Created by editor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Editor createdBy;

    // Last edited by editor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_edited_by")
    private Editor lastEditedBy;

    @OneToMany(
            mappedBy = "question",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<AssessmentQuestionLink> questionLinks;
}
