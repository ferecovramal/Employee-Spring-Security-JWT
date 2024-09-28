package net.javaguides.java_ems.repository;

import net.javaguides.java_ems.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
