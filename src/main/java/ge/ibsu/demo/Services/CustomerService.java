package ge.ibsu.demo.Services;

import ge.ibsu.demo.Entities.Customer;
import ge.ibsu.demo.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) throws Exception{
        return customerRepository.findById(id).orElseThrow(() -> new Exception("RECORD_NOT_FOUND"));
    }
}
