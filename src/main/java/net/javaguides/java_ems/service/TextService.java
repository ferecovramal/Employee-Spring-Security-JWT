package net.javaguides.java_ems.service;

import net.javaguides.java_ems.dto.TextDTO;

import java.util.List;

public interface TextService {
    TextDTO createText(TextDTO textDTO);
    TextDTO getTextById(Long id);
    List<TextDTO> getAllText();

}
