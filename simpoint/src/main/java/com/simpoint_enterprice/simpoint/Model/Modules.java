package com.simpoint_enterprice.simpoint.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "modules",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"course_id", "menu_order"})
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private Long id;

    @Column(name = "module_name", nullable = false)
    private String moduleName;

    @Column(name = "module_description", columnDefinition = "LONGTEXT")
    private String moduleDescription;

    @Column(name = "menu_order", nullable = false)
    private Long menuOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ModuleStatus status;

    @Column(name = "publish_date", nullable = false)
    private LocalDateTime publishDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "guid")
    private String guid;

    @Column(name = "slug")
    private String slug;

    // connected with Course
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;

    // Connected with Author table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_edited_by")
    private Editor lastEditedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Editor createdBy;

    @OneToMany(
            mappedBy = "module",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<ModuleContent> moduleContents;





}
