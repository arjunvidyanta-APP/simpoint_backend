package com.simpoint_enterprice.simpoint.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "topic_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long id;
    @Column(name = "topic_name", nullable = false)
    String topicName;
    @Column(name = "topic_description")
    String topicDescription;
    @Column(name = "short_code")
    private String shortCode;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "subcategory_id",nullable = false)
   @JsonIgnore
    private SubCategory subCategory;

}
