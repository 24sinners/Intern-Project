package data.user_info.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "wifii")
public class Wifi {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "Type" , nullable = false)
    private String type;
    @Column(name = "Bandwidth", nullable = false)
    private String bandwidth;
}
