package co.edu.javeriana.tais2020.laurel.marketplace.controllers;

import co.edu.javeriana.tais2020.laurel.marketplace.MarketplaceApplication;
import co.edu.javeriana.tais2020.laurel.marketplace.entities.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarketplaceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemsControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {}

    @Test
    public void it_should_find_items() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/items?q=something",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void it_should_get_item_by_id() {
        Item item = restTemplate.getForObject(getRootUrl() + "/items/1", Item.class);
        System.out.println(item.getName());
        assertNotNull(item);
    }

    @Test
    public void it_should_create_item() {
        Item item = new Item();
        item.setName("Zapatos");
        item.setPrice(54.23f);
        item.setInStock(200);
        item.setDescription("Lindos zapatos");
        item.setPhotos(Arrays.asList("https://carapalmer.com/wp-content/uploads/2019/09/free-shoes.jpg", "https://i.ebayimg.com/images/g/ES8AAOSwOZZfK2ba/s-l1600.jpg"));

        ResponseEntity<Item> postResponse = restTemplate.postForEntity(getRootUrl() + "/items", item, Item.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void it_should_update_item() {
        int id = 1;
        Item item = restTemplate.getForObject(getRootUrl() + "/items/" + id, Item.class);
        item.setName("mod1");
        item.setPrice(584.41f);


        restTemplate.put(getRootUrl() + "/items/" + id, item);

        Item updatedItem = restTemplate.getForObject(getRootUrl() + "/items/" + id, Item.class);
        assertNotNull(updatedItem);
    }

    @Test
    public void it_should_delete_item() {
        int id = 2;
        Item item = restTemplate.getForObject(getRootUrl() + "/items/" + id, Item.class);
        assertNotNull(item);

        restTemplate.delete(getRootUrl() + "/items/" + id);

        try {
            restTemplate.getForObject(getRootUrl() + "/items/" + id, Item.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}