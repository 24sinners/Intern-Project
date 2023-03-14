package data.user_info.repository;

import data.user_info.model.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long> {
}
