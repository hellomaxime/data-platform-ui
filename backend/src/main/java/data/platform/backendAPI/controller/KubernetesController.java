package data.platform.backendAPI.controller;

import data.platform.backendAPI.service.KubernetesService;
import io.kubernetes.client.openapi.models.V1Pod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pods")
public class KubernetesController {

    @Autowired
    private KubernetesService kubernetesService;

    @GetMapping("/")
    public List<V1Pod> getAllpods() {
        return kubernetesService.getAllPods();
    }

    @GetMapping("/{namespace}")
    public String[] getPodsByNamespace(@PathVariable String namespace) {
        return kubernetesService.getPodsByNamespace(namespace);
    }

}
