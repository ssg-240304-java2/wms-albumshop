package bangshop.music.model.dao;

import bangshop.music.model.dto.OrderDTO;

public interface OrderMapper {
    OrderDTO order(String albumNo, int quantity);

    OrderDTO getById(int orderId);
}