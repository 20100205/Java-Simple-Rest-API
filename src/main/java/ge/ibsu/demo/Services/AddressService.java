package ge.ibsu.demo.Services;

import ge.ibsu.demo.Entities.Address;
import ge.ibsu.demo.Repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List <Address> getAll(){
        return addressRepository.findAll();
    }

    public Address getByID(Long id) throws Exception{
        return addressRepository.findById(id).orElseThrow(() -> new Exception("RECORD NOT FOUND!"));
    }
}
