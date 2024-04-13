package data.platform.backendAPI.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaService {

    private AdminClient client;

    public KafkaService() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("client.id","java-admin-client");

        this.client = AdminClient.create(properties);
    }

    public List<String> getListTopics() {
        try {
            return client.listTopics().listings().get().stream().map(topic -> topic.name()).toList();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTopic(String topic) {
        NewTopic newTopic = new NewTopic(topic, 1, (short) 1);
        client.createTopics(Collections.singleton(newTopic));
    }
}
