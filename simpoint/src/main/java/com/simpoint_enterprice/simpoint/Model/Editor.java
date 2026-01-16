package com.simpoint_enterprice.simpoint.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "editors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editor_id")
    private Long EditorId;
    @Column(name = "editor_name")
    String editorName;
    @Column(name = "editor_email")
    String editorEmail;
    @Column(name = "first_name")
    String FirstName;
    @Column(name = "last_name")
    String LastName;
    @Column(name = "phone_number")
    String phoneNumber;

}
