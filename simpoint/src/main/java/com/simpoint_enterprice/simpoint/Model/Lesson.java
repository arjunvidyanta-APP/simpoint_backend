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
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;

    @Column(name = "publish_date", nullable = false)
    private LocalDateTime publishDate;

    @Column(name = "lesson_content", nullable = false, columnDefinition = "LONGTEXT")
    private String lessonContent;

    @Column(name = "lesson_name", nullable = false)
    private String lessonName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private LessonStatus status; // published / draft
    @Column(name = "slug")
    private String slug;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "tags", length = 500)
    private String tags;

    @Column(name = "guid")
    private String guid;
    @Column(name = "video_url", length = 500)
    private String videoUrl;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Editor createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_edited_by")
    private Editor lastEditedBy;

    @OneToMany(
            mappedBy = "lesson",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<ModuleContent> moduleContents;


}
