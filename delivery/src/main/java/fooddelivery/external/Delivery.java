package fooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Delivery {

    private Long id;
    private String orderid;
    private String deliverymanid;
    private String address;
    private String sts;
}


