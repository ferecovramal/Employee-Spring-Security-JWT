package net.javaguides.java_ems.controller;

import net.javaguides.java_ems.dto.LanguageDTO;
import net.javaguides.java_ems.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public ResponseEntity<LanguageDTO> createLanguage(@RequestBody LanguageDTO languageDTO) {
        LanguageDTO savedLanguage = languageService.createLanguage(languageDTO);
        return new ResponseEntity<>(savedLanguage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDTO> getLanguageById(@PathVariable Long id) {
        LanguageDTO languageDTO = languageService.getLanguageById(id);
        return new ResponseEntity<>(languageDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageDTO> updateLanguage(@PathVariable Long id, @RequestBody LanguageDTO languageDTO) {
        LanguageDTO updatedLanguage = languageService.updateLanguage(id, languageDTO);
        return new ResponseEntity<>(updatedLanguage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
