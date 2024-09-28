package net.javaguides.java_ems.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "en")
    private String En;

    @Column(name = "tr")
    private String Tr;

    @Column(name = "az")
    private String Az;

    @Column(name = "ru")
    private String Ru;
}
