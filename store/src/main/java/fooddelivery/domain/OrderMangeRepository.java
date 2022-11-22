package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="orderManges", path="orderManges")
public interface OrderMangeRepository extends PagingAndSortingRepository<OrderMange, Long>{

}
