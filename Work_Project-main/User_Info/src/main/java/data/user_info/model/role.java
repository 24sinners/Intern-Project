package data.user_info.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user")
    private Enum user;
    @Column(name = "admin")
    private Enum admin;
}
