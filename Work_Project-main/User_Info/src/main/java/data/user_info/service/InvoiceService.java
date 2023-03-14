package data.user_info.service;

import data.user_info.model.Invoice;
import data.user_info.model.User;

import java.util.List;

public interface InvoiceService {
    Invoice saveInvoice(Invoice invoice);
    List<Invoice> getAllInvoice();
    Invoice getInvoiceById(long id);
    Invoice updateInvoice(Invoice invoice, long id);
    void deleteInvoice(long id);
}
