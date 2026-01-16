package com.simpoint_enterprice.simpoint.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "subCategories")
//@EqualsAndHashCode(exclude = "subCategories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_title", nullable = false, unique = true, length = 255)
    private String categoryName;

    @Lob
    @Column(name = "category_description")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SubCategory> subCategories;


    }

