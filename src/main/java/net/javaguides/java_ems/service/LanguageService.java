package net.javaguides.java_ems.service;

import net.javaguides.java_ems.dto.LanguageDTO;
import net.javaguides.java_ems.entity.Language;

import java.util.List;

public interface LanguageService {
    LanguageDTO createLanguage(LanguageDTO languageDTO);
    LanguageDTO getLanguageById(Long id);
    LanguageDTO updateLanguage(Long id, LanguageDTO languageDTO);
    void addLanguagesToEmployee(Long employeeId,Long languageId);
    void deleteLanguage(Long id);
    Language findLanguageById(Long languageId);
}
