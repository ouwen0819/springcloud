package pers.jmu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pers.jmu.springcloud.entities.Person;
import pers.jmu.springcloud.lb.LoadBalancer;

import java.net.URI;
import java.util.List;

@RestController
public class OrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/getPerson/{classCn}")
    public Person getPerson(@PathVariable("classCn") String classCn) {
        System.out.println("-----------consumer----------");
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/getPerson/" + classCn, Person.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("------element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId());
            System.out.println(instance.getInstanceId());
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/consumer/payment/getEntity/{classCn}")
    public Person getPerson2(@PathVariable("classCn") String classCn) {
        System.out.println("-----------consumer-----getEntity-----");
        ResponseEntity<Person> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPerson/" + classCn, Person.class);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getStatusCodeValue());
        System.out.println(entity.getHeaders());
        return entity.getBody();
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    @GetMapping(value = "/gateWay/test1/{id}")
    public String getGateWay(@PathVariable("id") String id) {
        System.out.println("-------gateway--------" + id);
        return id;
    }

    @GetMapping(value = "/gateWay/test2")
    public String getGateWayRoute() {
        System.out.println("***********gateway*************");
        return null;
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {

        String template = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
        return template;
    }

}
