import com.example.MyMessage;
import io.confluent.kafka.serializers.KafkaAvroSerializer;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("acks", "all");
        properties.setProperty("retries", "10");

        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");

        org.apache.kafka.clients.producer.Producer<String, MyMessage> producer = new KafkaProducer<String, MyMessage>(properties);

        String topic = "message-avro";


        MyMessage message = MyMessage.newBuilder().
                setMessage("HelloFromProducer").
                build();

        ProducerRecord<String, MyMessage> producerRecord = new ProducerRecord<String, MyMessage>(
                topic, message
        );

        System.out.println(message);

        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
                    System.out.println(metadata);
                } else {
                    exception.printStackTrace();
                }
            }
        });

        producer.flush();
        producer.close();

    }
}
