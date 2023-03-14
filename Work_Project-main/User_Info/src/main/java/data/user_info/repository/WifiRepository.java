package data.user_info.repository;

import data.user_info.model.Wifi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WifiRepository extends JpaRepository<Wifi, Long> {
}
