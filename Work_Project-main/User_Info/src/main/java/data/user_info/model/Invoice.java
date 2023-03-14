package data.user_info.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "invoices")
public class Invoice {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "Invoice_No", nullable = false)
    private String invoice_no;
    @Column(name = "Amount")
    private int amount;
    @Column(name = "PaidStatus")
    private boolean paid;

}
