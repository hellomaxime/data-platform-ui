package data.platform.backendAPI.controller;

import data.platform.backendAPI.service.KubernetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class KubernetesController {

    @Autowired
    private KubernetesService kubernetesService;

    @GetMapping("pods")
    public List<String> getAllpods() {
        return kubernetesService.getAllPods();
    }

    @GetMapping("pods/{namespace}")
    public List<String> getPodsByNamespace(@PathVariable String namespace) {
        return kubernetesService.getPodsByNamespace(namespace);
    }

    @GetMapping("deployments")
    public List<String> getAllDeployments() {
        return kubernetesService.getAllDeployments();
    }

    @GetMapping("deployments/{namespace}")
    public List<String> getDeploymentsByNamespace(@PathVariable String namespace) {
        return kubernetesService.getDeploymentsByNamespace(namespace);
    }
}
