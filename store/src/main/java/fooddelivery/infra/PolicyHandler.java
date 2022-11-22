package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderMangeRepository orderMangeRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_AddToOrderList(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener AddToOrderList : " + rejected + "\n\n");


        

        // Sample Logic //
        OrderMange.addToOrderList(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_AddToOrderList(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener AddToOrderList : " + paid + "\n\n");


        

        // Sample Logic //
        OrderMange.addToOrderList(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_AlertOrderCancel(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener AlertOrderCancel : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        OrderMange.alertOrderCancel(event);
        

        

    }

}


