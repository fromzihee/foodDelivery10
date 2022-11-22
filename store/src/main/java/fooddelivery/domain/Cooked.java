package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cooked extends AbstractEvent {

    private Long id;
    private String foodid;
    private String orderid;
    private String sts;
    private String customerid;

    public Cooked(OrderMange aggregate){
        super(aggregate);
    }
    public Cooked(){
        super();
    }
}
