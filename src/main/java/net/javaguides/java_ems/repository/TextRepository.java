package net.javaguides.java_ems.repository;

import net.javaguides.java_ems.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextRepository extends JpaRepository<Text , Long> {

}
