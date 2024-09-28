package net.javaguides.java_ems.repository;

import net.javaguides.java_ems.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address , Long> {

}
