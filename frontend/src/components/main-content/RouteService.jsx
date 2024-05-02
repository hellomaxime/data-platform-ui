import Documentation from "../services/Documentation";
import Home from "../services/Home";
import Minio from "../services/Minio";

export default function RouteService({openService}) {
    return (
        <>
            {openService === "jupyterhub" && <iframe className="w-full flex-grow" src="http://dataplatform.jupyterhub.io" title="jupyterhub"/>}
            {openService === "kubernetes" && <iframe className="w-full flex-grow" src="http://127.0.0.1:8001/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/" title="kubernetes"/>}
            {openService === "superset" && <iframe className="w-full flex-grow" src="http://dataplatform.superset.io" title="superset"/>}
            {openService === "grafana" && <iframe className="w-full flex-grow" src="http://dataplatform.grafana.io" title="grafana"/>}
            {openService === "minio" && <Minio />}
            {openService === "home" && <Home />}
            {openService === "documentation" && <Documentation/>}
        </>
    )
}