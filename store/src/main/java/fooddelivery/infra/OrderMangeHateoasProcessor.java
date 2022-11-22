package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class OrderMangeHateoasProcessor implements RepresentationModelProcessor<EntityModel<OrderMange>>  {

    @Override
    public EntityModel<OrderMange> process(EntityModel<OrderMange> model) {

        
        return model;
    }
    
}
