package bangshop.music.model.dao;

import bangshop.music.model.dto.StorageDTO;

import java.util.Optional;

public interface StorageMapper {
    Optional<StorageDTO> findByType(String type);
}
