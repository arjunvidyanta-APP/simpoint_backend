package com.simpoint_enterprice.simpoint.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "subcategories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private Long id;

    @Column(name = "subcategory_name", nullable = false)
    private String subcategoryName;

    @Lob
    @Column(name = "subcategory_description")
    private String subcategoryDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @OneToMany(
            mappedBy = "subCategory",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<TopicCategory>topicCategories;


}
