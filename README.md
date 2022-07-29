<p align="center">
    <samp>
        실전 카프카 개발부터 운영까지
    </samp>
</p>


<p>

```
# stand alone

# start zookeeper
~/kafka_2.13-3.2.0
sudo bin/zookeeper-server-start.sh config/zookeeper.properties

# start kafka 
~/kafka_2.13-3.2.0
sudo bin/kafka-server-start.sh config/server.properties

# create topic
~/kafka_2.13-3.2.0
sudo bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092

# detail
sudo bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
```

</p>