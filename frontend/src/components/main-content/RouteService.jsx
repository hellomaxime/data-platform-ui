import Airbyte from "../services/Airbyte";
import Airflow from "../services/Airflow";
import ArgoWorkflows from "../services/ArgoWorkflows";
import Cassandra from "../services/Cassandra";
import ClickHouse from "../services/ClickHouse";
import Dbt from "../services/Dbt";
import Debezium from "../services/Debezium";
import Documentation from "../services/Documentation";
import Druid from "../services/Druid";
import Flink from "../services/Flink";
import GreatExpectations from "../services/GreatExpectations";
import Home from "../services/Home";
import Kafka from "../services/Kafka";
import Metabase from "../services/Metabase";
import MinIO from "../services/MinIO";
import MongoDB from "../services/MongoDB";
import MySQL from "../services/MySQL";
import Nifi from "../services/Nifi";
import PostgreSQL from "../services/PostgreSQL";
import RabbitMQ from "../services/RabbitMQ";
import Spark from "../services/Spark";
import Trino from "../services/Trino";

export default function RouteService({openService}) {
    return (
        <>
            {openService === "home" && <Home />}
            {openService === "documentation" && <Documentation/>}
            {openService === "jupyterhub" && <iframe className="w-full flex-grow" src="http://dataplatform.jupyterhub.io" title="jupyterhub"/>}
            {openService === "kubernetes" && <iframe className="w-full flex-grow" src="http://127.0.0.1:8001/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/" title="kubernetes"/>}
            {openService === "superset" && <iframe className="w-full flex-grow" src="http://dataplatform.superset.io" title="superset"/>}
            {openService === "grafana" && <iframe className="w-full flex-grow" src="http://dataplatform.grafana.io" title="grafana"/>}
            {openService === "minio" && <MinIO />}
            {openService === "airflow" && <Airflow />}
            {openService === "argoworkflows" && <ArgoWorkflows />}
            {openService === "airbyte" && <Airbyte />}
            {openService === "cassandra" && <Cassandra />}
            {openService === "spark" && <Spark />}
            {openService === "druid" && <Druid />}
            {openService === "flink" && <Flink />}
            {openService === "kafka" && <Kafka />}
            {openService === "nifi" && <Nifi />}
            {openService === "clickhouse" && <ClickHouse />}
            {openService === "dbt" && <Dbt />}
            {openService === "debezium" && <Debezium />}
            {openService === "greatexpectations" && <GreatExpectations />}
            {openService === "mongodb" && <MongoDB />}
            {openService === "mysql" && <MySQL />}
            {openService === "metabase" && <Metabase />}
            {openService === "postgresql" && <PostgreSQL />}
            {openService === "rabbitmq" && <RabbitMQ />}
            {openService === "trino" && <Trino />}
        </>
    )
}