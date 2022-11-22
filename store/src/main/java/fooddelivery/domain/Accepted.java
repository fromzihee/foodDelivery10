package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Accepted extends AbstractEvent {

    private Long id;
    private String foodid;
    private String orderid;
    private String sts;
    private String customerid;

    public Accepted(OrderMange aggregate){
        super(aggregate);
    }
    public Accepted(){
        super();
    }
}
