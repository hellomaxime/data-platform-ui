package data.platform.backendAPI.service;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1DeploymentList;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class KubernetesService {

    private ApiClient client;
    private CoreV1Api apiV1;
    private AppsV1Api apiAppsV1;

    public KubernetesService() {
        try {
            this.client = Config.defaultClient();
            this.apiV1 = new CoreV1Api(this.client);
            this.apiAppsV1 = new AppsV1Api(this.client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAllPods() {
        V1PodList podList = null;
        try {
            podList = apiV1.listPodForAllNamespaces().execute();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        return podList.getItems().stream().map(pod -> pod.getMetadata().getName()).toList();
    }

    public List<String> getPodsByNamespace(String namespace) {
        V1PodList podList = null;
        try {
            podList = apiV1.listNamespacedPod(namespace).execute();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        return podList.getItems().stream().map(pod -> pod.getMetadata().getName()).toList();
    }

    public List<String> getAllDeployments() {
        V1DeploymentList deployList = null;
        try {
            deployList = apiAppsV1.listDeploymentForAllNamespaces().execute();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        return deployList.getItems().stream().map(deploy -> deploy.getMetadata().getName()).toList();
    }

    public List<String> getDeploymentsByNamespace(String namespace) {
        V1DeploymentList deployList = null;
        try {
            deployList = apiAppsV1.listNamespacedDeployment(namespace).execute();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        return deployList.getItems().stream().map(deploy -> deploy.getMetadata().getName()).toList();
    }
}
