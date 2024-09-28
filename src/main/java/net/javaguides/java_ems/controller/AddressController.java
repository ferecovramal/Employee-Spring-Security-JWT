package net.javaguides.java_ems.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.javaguides.java_ems.dto.AddressDto;
import net.javaguides.java_ems.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@ModelAttribute AddressDto addressDto) {
       AddressDto savedAddress = addressService.createAddress(addressDto);
       return new ResponseEntity<>(savedAddress , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Long id){
       AddressDto addressDto = addressService.getAddressById(id);
       return ResponseEntity.ok(addressDto);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
       List<AddressDto> addresses = addressService.getAllAddresses();
       return ResponseEntity.ok(addresses);
    }

   @PutMapping("{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Long addressId ,
                                                    @RequestParam AddressDto updateAddress){
      AddressDto addressDto = addressService.updateAddress(addressId , updateAddress);
      return  ResponseEntity.ok(addressDto);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long addressId){
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok("Address deleted successfully!");
   }
}
