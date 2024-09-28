package net.javaguides.java_ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextDTO {
    private Long id;
    private String contentAz;
    private String contentRu;
    private String contentEn;
    private String contentTr;

}
