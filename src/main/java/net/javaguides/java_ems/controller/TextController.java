package net.javaguides.java_ems.controller;

import net.javaguides.java_ems.dto.TextDTO;
import net.javaguides.java_ems.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/texts")
public class TextController {

    @Autowired
    private TextService textService;

    @PostMapping
    public ResponseEntity<TextDTO> createText(@RequestBody TextDTO textDTO) {
        TextDTO createdText = textService.createText(textDTO);
        return new ResponseEntity<>(createdText, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TextDTO> getTextById(@PathVariable Long id) {
        TextDTO textDTO = textService.getTextById(id);
        return new ResponseEntity<>(textDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TextDTO>> getAllText() {
        List<TextDTO> textDTOS = textService.getAllText();
        return new ResponseEntity<>(textDTOS, HttpStatus.OK);
    }



}
