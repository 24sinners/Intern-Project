package data.user_info.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "dates")
public class Date {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "Duration")
    private String duration;
    @Column(name = "Start_Date", nullable = false)
    private java.sql.Date start_date;
    @Column(name = "End_Date")
    private java.sql.Date end_date;
}
