package com.simpoint_enterprice.simpoint.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "subCategories")
@EqualsAndHashCode(exclude = "subCategories")
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

//    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
//    private List<SubCategory> subCategories = new ArrayList<>();

//    public void setSubCategories(List<SubCategory> subCategories) {
//        this.subCategories.clear();
//        if (subCategories != null) {
//            subCategories.forEach(sc -> sc.setCategory(this));
//            this.subCategories.addAll(subCategories);
//        }
    }

