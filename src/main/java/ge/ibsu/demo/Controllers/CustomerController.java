package ge.ibsu.demo.Controllers;

import ge.ibsu.demo.DTO.AddCustomer;
import ge.ibsu.demo.DTO.Request.RequestData;
import ge.ibsu.demo.DTO.SearchCustomer;
import ge.ibsu.demo.Entities.Customer;
import ge.ibsu.demo.Services.CustomerService;
import ge.ibsu.demo.Utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Customer> getAll(){
        return customerService.getAllCustomer();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Customer getByID(@PathVariable Long id) throws Exception{
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public Customer add(@RequestBody AddCustomer addCustomer) throws Exception{
        GeneralUtil.checkRequiredProperties(addCustomer, Arrays.asList("firstName", "lastName", "addressID"));
        return customerService.add(addCustomer);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public Customer edit(@PathVariable Long id, @RequestBody AddCustomer addCustomer) throws Exception{
        GeneralUtil.checkRequiredProperties(addCustomer, Arrays.asList("firstName", "lastName", "addressID"));
        return customerService.edit(id, addCustomer);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    public Slice<Customer> search(@RequestBody RequestData<SearchCustomer> rd) throws Exception{
        return customerService.search(rd.getData(), rd.getPaging());
    }
}

