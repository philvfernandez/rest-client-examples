package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    //private final Object HttpClients;
    private RestTemplate restTemplate;

    public ApiServiceImpl(@Qualifier("jacksonObjectMapper") Object httpClients, RestTemplate restTemplate) {
        //HttpClients = httpClients;
        //ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        User[] user = restTemplate.getForObject("https://fakestoreapi.com/users?limit=" + limit,User[].class);

        List<User> userData = new ArrayList<User>(Arrays.asList(user));
        return userData;
    }
}
