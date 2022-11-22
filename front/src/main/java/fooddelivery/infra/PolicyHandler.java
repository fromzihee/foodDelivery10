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
    @Autowired OrderRepository orderRepository;
    @Autowired PaymentRepository paymentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_OrderCancel(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener OrderCancel : " + accepted + "\n\n");


        

        // Sample Logic //
        Order.orderCancel(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_UpdateSts(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener UpdateSts : " + accepted + "\n\n");


        

        // Sample Logic //
        Order.updateSts(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_UpdateSts(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener UpdateSts : " + cooked + "\n\n");


        

        // Sample Logic //
        Order.updateSts(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_UpdateSts(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener UpdateSts : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Order.updateSts(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivereid'")
    public void wheneverDelivereid_UpdateSts(@Payload Delivereid delivereid){

        Delivereid event = delivereid;
        System.out.println("\n\n##### listener UpdateSts : " + delivereid + "\n\n");


        

        // Sample Logic //
        Order.updateSts(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_CancelPayment(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener CancelPayment : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        Payment.cancelPayment(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_CancelPayment(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener CancelPayment : " + rejected + "\n\n");


        

        // Sample Logic //
        Payment.cancelPayment(event);
        

        

    }

}


