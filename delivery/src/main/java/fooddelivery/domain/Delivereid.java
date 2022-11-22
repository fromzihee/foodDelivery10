package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Delivereid extends AbstractEvent {

    private Long id;
    private String foodid;
    private String orderid;
    private String sts;
    private String address;

    public Delivereid(Delivery aggregate){
        super(aggregate);
    }
    public Delivereid(){
        super();
    }
}
