package com.simpoint_enterprice.simpoint.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assessments")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Long assessmentId;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "publish_date", nullable = false)
    private LocalDateTime publishDate;

    @Lob
    @Column(name = "assessment_content", columnDefinition = "LONGTEXT")
    private String assessmentContent;

    @Column(name = "assessment_name", unique = true)
    private String assessmentName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssessmentStatus status;

    @Column(name = "slug")
    private String slug;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "last_edited_by")
    private Long lastEditedBy;

    @Column(name = "guid")
    private String guid;


//      Module → Assessment link

    @OneToMany(
            mappedBy = "assessment",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<ModuleContent> moduleContents;

//      Assessment → Questions
//      via question_link table

    @OneToMany(
            mappedBy = "assessment",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<AssessmentQuestionLink> questionLinks;

}
