package co.edu.javeriana.tais2020.laurel.marketplace.services;

import co.edu.javeriana.tais2020.laurel.marketplace.entities.Item;
import co.edu.javeriana.tais2020.laurel.marketplace.repositories.MarketplaceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private MarketplaceRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Item getItem(Long id) {
        return findItem(id);
    }

    @Override
    public List<Item> getItems(String searchTerms) {
        return repository.findByNameLikeIgnoreCase(searchTerms);
    }

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Item updateItem(Item item) {
        Item itemFound = findItem(item.getId());
        if (itemFound == null) return null;

        itemFound.setDescription(item.getDescription());
        itemFound.setInStock(item.getInStock());
        itemFound.setName(item.getName());
        itemFound.setPhotos(item.getPhotos());
        itemFound.setPrice(item.getPrice());

        return repository.save(itemFound);
    }

    @Override
    public Item createItem(Item item) {
        item.setId(sequenceGeneratorService.generateSequence(Item.SEQUENCE_NAME));
        Item savedItem = repository.save(item);

        String projectId = "dsbp-smap-gateway";
        String topicId = "marketplace";

        try {
            publishToTopic(projectId, topicId, item);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return savedItem;
    }

    public static void publishToTopic(String projectId, String topicId, Item item)
            throws IOException, ExecutionException, InterruptedException {
        TopicName topicName = TopicName.of(projectId, topicId);

        Publisher publisher = null;
        try {
            // Create a publisher instance with default settings bound to the topic
            publisher = Publisher.newBuilder(topicName).build();
            ObjectMapper mapper = new ObjectMapper();

            item.setPhotos(null);

            String message = mapper.writeValueAsString(item);

            System.out.println("Published message: " + message);

            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

            // Once published, returns a server-assigned message id (unique within the topic)
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            System.out.println("Published message ID: " + messageId);
        } finally {
            if (publisher != null) {
                // When finished with the publisher, shutdown to free up resources.
                publisher.shutdown();
                publisher.awaitTermination(1, TimeUnit.MINUTES);
            }
        }
    }

    @Override
    public boolean deleteItem(Long id) {
        Item itemFound = findItem(id);
        if (itemFound == null) return false;

        repository.delete(itemFound);
        return true;
    }

    private Item findItem(Long id) {
        Optional<Item> itemOptional = repository.findById(id);
        if (itemOptional.isEmpty()) return null;

        return itemOptional.get();
    }
}
