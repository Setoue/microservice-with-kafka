# microservice-with-kafka

> Um exemplo de arquitetura de microsserviços em Java com Spring Boot e Apache Kafka, dividido em dois módulos:
>
> * **api**: microsserviço produtor (REST API para cadastrar e consultar “CarPosts” e publicar eventos no Kafka)
> * **store-car**: microsserviço consumidor (escuta o tópico de “CarPosts” e persiste/mostra as mensagens)

---

## Índice

* [Visão Geral](#vis%C3%A3o-geral)
* [Tecnologias e Pré-requisitos](#tecnologias-e-pr%C3%A9-requisitos)
* [Estrutura do Projeto](#estrutura-do-projeto)
* [Configuração](#configura%C3%A7%C3%A3o)
* [Como Executar](#como-executar)
* [Endpoints REST](#endpoints-rest)
* [Como Testar](#como-testar)
* [Contribuição](#contribui%C3%A7%C3%A3o)
* [Licença](#licen%C3%A7a)

---

## Visão Geral

Este repositório demonstra um padrão básico de microsserviços em Java que se comunicam via Kafka. O módulo **api** proporciona uma API HTTP para criar e consultar anúncios de carros, persistindo no banco e publicando eventos no Kafka. O módulo **store-car** consome essas mensagens e as processa (por exemplo, gravando em outro banco ou log).

---

## Tecnologias e Pré-requisitos

* Java 17+
* Maven 3.6+
* Apache Kafka 3.x (KRaft ou com ZooKeeper)
* (Opcional) Docker & Docker Compose para orquestrar Kafka/ZooKeeper

---

## Estrutura do Projeto

```
microservice-with-kafka/
├── pom.xml                  ← _Parent POM multimódulo_
├── api/                     ← Microsserviço produtor
│   ├── src/main/java/…  
│   ├── src/main/resources/
│   │   └── application.properties  
│   └── pom.xml  
└── store-car/               ← Microsserviço consumidor
    ├── src/main/java/…  
    ├── src/main/resources/
    │   └── application.properties  
    └── pom.xml  
```

---

## Configuração

Em cada módulo, configure em `src/main/resources/application.properties`:

```properties
# Porta HTTP da aplicação
server.port=8085           # (api), 8086 (store-car)

# Endereço do Kafka
spring.kafka.bootstrap-servers=localhost:9092

# Producer (api)
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
app.topic.car-posts=car-posts

# Consumer (store-car)
spring.kafka.consumer.group-id=store-car-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.consumer.properties.spring.json.trusted-packages=*
```

> **Dica:** Você pode sobrescrever essas propriedades via variáveis de ambiente (`SPRING_KAFKA_BOOTSTRAP_SERVERS`, etc.) ou `–Dspring-boot.run.arguments`.

---

## Como Executar

1. **Clone o repositório**

   ```bash
   git clone https://github.com/Setoue/microservice-with-kafka.git
   cd microservice-with-kafka
   ```

2. **Inicie o Kafka** (com ZooKeeper ou KRaft)

   ```bash
   # Exemplo com KRaft
   bin/kafka-storage.sh format -t $(uuidgen) -c config/kraft/server.properties
   bin/kafka-server-start.sh config/kraft/server.properties
   ```

3. **Crie o tópico**

   ```bash
   bin/kafka-topics.sh --create \
     --topic car-posts \
     --bootstrap-server localhost:9092 \
     --partitions 1 --replication-factor 1
   ```

4. **Construa e rode o módulo API (produtor)**

   ```bash
   cd api
   mvn clean spring-boot:run
   ```

5. **Construa e rode o módulo STORE-CAR (consumidor)**

   ```bash
   cd ../store-car
   mvn clean spring-boot:run
   ```

---

## Endpoints REST (módulo **api**)

| Método | Rota        | Descrição                                                              |
| ------ | ----------- | ---------------------------------------------------------------------- |
| POST   | `/api/cars` | Cria um novo anúncio de carro (e publica evento no Kafka). Corpo JSON: |

````json
{
  "brand": "Toyota",
  "model": "Corolla",
  "price": 45000.0
}
```  |
| GET    | `/api/cars`         | Retorna todos os anúncios cadastrados.  |
| GET    | `/api/cars/{id}`    | Retorna anúncio por ID.                |
| PUT    | `/api/cars/{id}`    | Atualiza anúncio existente.            |

> **Exemplo de uso**  
```bash
curl -X POST http://localhost:8085/api/cars \
  -H "Content-Type: application/json" \
  -d '{"brand":"Honda","model":"Civic","price":35000}'
````

## Licença

Este projeto está sob a licença **MIT**. Veja o arquivo [LICENSE](LICENSE) para detalhes.
