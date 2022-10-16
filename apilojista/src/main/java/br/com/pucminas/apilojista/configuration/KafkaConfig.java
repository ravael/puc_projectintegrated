package br.com.pucminas.apilojista.configuration;

//@Configuration
public class KafkaConfig {

//     @Value("${spring.kafka.bootstrap-servers}")
//     private String bootstrapServers;
//
//     @Bean
//     public Map<String, Object> producerConfigs() {
//          Map<String, Object> props = new HashMap<>();
//          props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//          props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//          props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//          return props;
//     }
//
//     @Bean
//     public ProducerFactory<String, Store> producerFactory() {
//          return new DefaultKafkaProducerFactory<>(producerConfigs());
//     }
//
//     @Bean
//     public KafkaTemplate<String, Store> kafkaTemplate() {
//          return new KafkaTemplate<>(producerFactory());
//     }
//
//     @Bean
//     public Map<String, Object> consumerConfigs() {
//          Map<String, Object> props = new HashMap<>();
//          props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//          props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//          props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//          props.put(ConsumerConfig.GROUP_ID_CONFIG, "json");
//          return props;
//     }
//
//     @Bean
//     public ConsumerFactory<String, Store> consumerFactory() {
//          return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
//                 new JsonDeserializer<>(Store.class));
//     }
//
//     @Bean
//     public ConcurrentKafkaListenerContainerFactory<String, Store> kafkaListenerContainerFactory() {
//           ConcurrentKafkaListenerContainerFactory<String, Store> factory =
//               new ConcurrentKafkaListenerContainerFactory<>();
//           factory.setConsumerFactory(consumerFactory());
//           return factory;
//     }

}