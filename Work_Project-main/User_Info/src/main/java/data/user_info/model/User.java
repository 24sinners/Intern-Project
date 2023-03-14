package data.user_info.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "usersinfo")
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "Image")
    private byte[] user_image;
    @Column(name = "User_Id", nullable = false)
    private String user_id;
    @Column(name = "User_Name", nullable = false)
    private String user_name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Address" , nullable = false)
    private String address;
    @Column(name = "Phone_No", nullable = false)
    private String phone_no;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Township", nullable = false)
    private String township;
    @Column(name = "Timestamp")
    private Timestamp time_stamp;


}
