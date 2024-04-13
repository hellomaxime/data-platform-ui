package data.platform.backendAPI.controller;

import data.platform.backendAPI.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    KafkaService kafkaService;

    @GetMapping("/topics")
    public List<String> getListTopics() {
        return kafkaService.getListTopics();
    }

    @GetMapping("/create/{topic}")
    public void createTopic(@PathVariable String topic) {
        kafkaService.createTopic(topic);
    }

}