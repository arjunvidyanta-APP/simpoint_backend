package com.simpoint_enterprice.simpoint.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @Column(name = "publish_date", nullable = false)
    private LocalDateTime publishDate;

    @Column(name = "course_description", nullable = false, columnDefinition = "LONGTEXT")
    private String courseDescription;

    @Column(name = "course_title", nullable = false, unique = true)
    private String courseTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CourseStatus status;
    @Column(name = "slug")
    private String slug;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "guid")
    private String guid;

    @Column(name = "course_duration")
    private Long courseDuration;

    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "enroll_by")
    private LocalDateTime enrollBy;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "certification", nullable = false)
    private CertificationStatus CertificationStatus;

    @Column(name = "accredited_by")
    private String accreditedBy;
    @Column(name = "tags", length = 500)
    private String tags;

    @Column(name = "section_identifier", nullable = false)
    private String sectionIdentifier;

    @Column(name = "short_code", nullable = false)
    private String shortCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
//    @JoinColumn(name = "topic_id")
    private TopicCategory topicCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Editor createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_edited_by")
    private Editor lastEditedBy;

    @OneToMany(
            mappedBy = "course",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("menuOrder ASC")
    private List<Modules>modules;

    }
