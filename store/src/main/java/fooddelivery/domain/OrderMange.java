package fooddelivery.domain;

import fooddelivery.domain.Accepted;
import fooddelivery.domain.Rejected;
import fooddelivery.domain.CookStart;
import fooddelivery.domain.Cooked;
import fooddelivery.domain.CouponPublished;
import fooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="OrderMange_table")
@Data

public class OrderMange  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodid;
    
    
    
    
    
    private String customerid;
    
    
    
    
    
    private String orderid;
    
    
    
    
    
    private String sts;
    
    
    
    
    
    private String count;

    @PostPersist
    public void onPostPersist(){


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        CookStart cookStart = new CookStart(this);
        cookStart.publishAfterCommit();



        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();



        CouponPublished couponPublished = new CouponPublished(this);
        couponPublished.publishAfterCommit();

    }

    public static OrderMangeRepository repository(){
        OrderMangeRepository orderMangeRepository = StoreApplication.applicationContext.getBean(OrderMangeRepository.class);
        return orderMangeRepository;
    }




    public static void addToOrderList(Rejected rejected){

        /** Example 1:  new item 
        OrderMange orderMange = new OrderMange();
        repository().save(orderMange);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(orderMange->{
            
            orderMange // do something
            repository().save(orderMange);


         });
        */

        
    }
    public static void addToOrderList(Paid paid){

        /** Example 1:  new item 
        OrderMange orderMange = new OrderMange();
        repository().save(orderMange);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(orderMange->{
            
            orderMange // do something
            repository().save(orderMange);


         });
        */

        
    }
    public static void alertOrderCancel(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        OrderMange orderMange = new OrderMange();
        repository().save(orderMange);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(orderMange->{
            
            orderMange // do something
            repository().save(orderMange);


         });
        */

        
    }


}
