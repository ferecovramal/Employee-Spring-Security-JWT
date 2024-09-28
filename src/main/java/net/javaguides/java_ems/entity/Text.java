package net.javaguides.java_ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "texts")
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content_az")
    private String contentAz;

    @Column(name = "content_ru")
    private String contentRu;

    @Column(name = "content_en")
    private String contentEn;

    @Column(name = "content_tr")
    private String contentTr;

}
