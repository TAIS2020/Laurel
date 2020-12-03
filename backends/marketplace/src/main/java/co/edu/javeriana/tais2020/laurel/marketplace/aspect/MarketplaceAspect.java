package co.edu.javeriana.tais2020.laurel.marketplace.aspect;

import co.edu.javeriana.tais2020.laurel.marketplace.entities.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class MarketplaceAspect {

    @AfterReturning(pointcut = "execution(* co.edu.javeriana.tais2020.laurel.marketplace.services.ItemsServiceImpl.createItem(..)) && args(item)")
    public void afterAdvice(JoinPoint joinPoint, Item item) {
        System.out.println("DEBUG: " + "[After Advice] / publish to Queue");

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
}
