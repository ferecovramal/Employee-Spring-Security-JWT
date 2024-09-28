package net.javaguides.java_ems.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.java_ems.dto.LanguageDTO;
import net.javaguides.java_ems.entity.Employee;
import net.javaguides.java_ems.entity.Language;
import net.javaguides.java_ems.exception.ResourceNotFoundException;
import net.javaguides.java_ems.repository.EmployeeRepository;
import net.javaguides.java_ems.repository.LanguageRepository;
import net.javaguides.java_ems.service.LanguageService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public LanguageDTO createLanguage(LanguageDTO languageDTO) {
        Language language = new Language();
        language.setRu(languageDTO.getRu());
        language.setTr(languageDTO.getTr());
        language.setAz(languageDTO.getAz());
        language.setEn(languageDTO.getEn());

        Language savedLanguage = languageRepository.save(language);

        return new LanguageDTO(
                savedLanguage.getId(),
                savedLanguage.getRu(),
                savedLanguage.getTr(),
                savedLanguage.getAz(),
                savedLanguage.getEn());
    }

    @Override
    public LanguageDTO getLanguageById(Long id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        return new LanguageDTO(
                language.getId(),
                language.getRu(),
                language.getTr(),
                language.getAz(),
                language.getEn());
    }

    @Override
    public LanguageDTO updateLanguage(Long id, LanguageDTO languageDTO) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        language.setRu(languageDTO.getRu());
        language.setTr(languageDTO.getTr());
        language.setAz(languageDTO.getAz());
        language.setEn(languageDTO.getEn());

        Language updatedLanguage = languageRepository.save(language);

        return new LanguageDTO(
                updatedLanguage.getId(),
                updatedLanguage.getRu(),
                updatedLanguage.getTr(),
                updatedLanguage.getAz(),
                updatedLanguage.getEn());
    }

    @Override
    public void addLanguagesToEmployee(Long employeeId, Long languageId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        Language language = languageRepository.findById(languageId)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + languageId));

        employee.setLanguage(language);

        employeeRepository.save(employee);
    }

    @Override
    public Language findLanguageById(Long languageId) {
        return languageRepository.findById(languageId)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + languageId));
    }

    @Override
    public void deleteLanguage(Long id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        languageRepository.delete(language);
    }
}
