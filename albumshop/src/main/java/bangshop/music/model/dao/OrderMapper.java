package bangshop.music.model.dao;

import bangshop.music.model.dto.OrderDTO;

public interface OrderMapper {
    OrderDTO getById(int orderId);
}
