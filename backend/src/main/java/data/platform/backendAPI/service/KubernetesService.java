package data.platform.backendAPI.service;

import org.springframework.stereotype.Service;

@Service
public class KubernetesService {

    public String[] getAllPods() {
        return new String[] {"pod1", "pod2", "pod3ns"};
    }

    public String[] getPodsByNamespace(String namespace) {
        return new String[] {"pod3ns"};
    }
}
