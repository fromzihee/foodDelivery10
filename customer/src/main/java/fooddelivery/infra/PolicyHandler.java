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
    @Autowired NotificationLogRepository notificationLogRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_AlertKakao(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener AlertKakao : " + rejected + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_AlertKakao(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener AlertKakao : " + paid + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookStart'")
    public void wheneverCookStart_AlertKakao(@Payload CookStart cookStart){

        CookStart event = cookStart;
        System.out.println("\n\n##### listener AlertKakao : " + cookStart + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponPublished'")
    public void wheneverCouponPublished_AlertKakao(@Payload CouponPublished couponPublished){

        CouponPublished event = couponPublished;
        System.out.println("\n\n##### listener AlertKakao : " + couponPublished + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_AlertKakao(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener AlertKakao : " + cooked + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_AlertKakao(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener AlertKakao : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivereid'")
    public void wheneverDelivereid_AlertKakao(@Payload Delivereid delivereid){

        Delivereid event = delivereid;
        System.out.println("\n\n##### listener AlertKakao : " + delivereid + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakao(event);
        

        

    }

}


