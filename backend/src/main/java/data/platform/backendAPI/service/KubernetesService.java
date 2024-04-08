package data.platform.backendAPI.service;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class KubernetesService {

    private ApiClient client;
    private CoreV1Api api;

    public KubernetesService() {
        try {
            this.client = Config.defaultClient();
            this.api = new CoreV1Api(this.client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<V1Pod> getAllPods() {
        V1PodList podList = null;
        try {
            podList = api.listPodForAllNamespaces().execute();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        return podList.getItems();
    }

    public String[] getPodsByNamespace(String namespace) {
        return new String[] {"pod3ns"};
    }
}
