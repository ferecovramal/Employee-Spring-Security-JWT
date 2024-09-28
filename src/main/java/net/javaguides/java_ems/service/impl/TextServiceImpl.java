package net.javaguides.java_ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.java_ems.dto.TextDTO;
import net.javaguides.java_ems.entity.Text;
import net.javaguides.java_ems.exception.ResourceNotFoundException;
import net.javaguides.java_ems.repository.TextRepository;
import net.javaguides.java_ems.service.TextService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TextServiceImpl implements TextService {

    private final TextRepository textRepository;

    @Override
    public TextDTO createText(TextDTO textDTO) {
        Text text = new Text();
        text.setContentAz(textDTO.getContentAz());
        text.setContentRu(textDTO.getContentRu());
        text.setContentEn(textDTO.getContentEn());
        text.setContentTr(textDTO.getContentTr());

        Text savedText = textRepository.save(text);

        return new TextDTO(
                savedText.getId(),
                savedText.getContentAz(),
                savedText.getContentRu(),
                savedText.getContentEn(),
                savedText.getContentTr()
        );
    }

    @Override
    public TextDTO getTextById(Long id) {
        Text text = textRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Text not found with id: " + id));

        return new TextDTO(
                text.getId(),
                text.getContentAz(),
                text.getContentRu(),
                text.getContentEn(),
                text.getContentTr()
        );
    }

    @Override
    public List<TextDTO> getAllText() {
        return textRepository.findAll().stream()
                .map(text -> new TextDTO(
                        text.getId(),
                        text.getContentAz(),
                        text.getContentRu(),
                        text.getContentEn(),
                        text.getContentTr()
                ))
                .collect(Collectors.toList());
    }

}
