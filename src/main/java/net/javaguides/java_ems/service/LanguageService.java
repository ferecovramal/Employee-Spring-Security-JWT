package net.javaguides.java_ems.service;

import net.javaguides.java_ems.dto.LanguageDTO;

public interface LanguageService {
    LanguageDTO createLanguage(LanguageDTO languageDTO);
    LanguageDTO getLanguageById(Long id);
    LanguageDTO updateLanguage(Long id, LanguageDTO languageDTO);
    void deleteLanguage(Long id);
}
