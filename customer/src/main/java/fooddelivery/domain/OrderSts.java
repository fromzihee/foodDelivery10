package fooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="OrderSts_table")
@Data
public class OrderSts {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String foodid;
        private String orderid;


}