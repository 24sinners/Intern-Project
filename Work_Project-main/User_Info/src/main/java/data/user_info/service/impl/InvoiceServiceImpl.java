package data.user_info.service.impl;

import data.user_info.exception.ResourceNotFoundException;
import data.user_info.model.Invoice;
import data.user_info.repository.InvoiceRepository;
import data.user_info.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(long id) {
        return invoiceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Invoice","Id",id));
    }

    @Override
    public Invoice updateInvoice(Invoice invoice, long id) {
        Invoice existingInvoice = invoiceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Invoice","Id",id));
        existingInvoice.setInvoice_no(invoice.getInvoice_no());
        existingInvoice.setPaid(invoice.isPaid());
        existingInvoice.setAmount(invoice.getAmount());

        invoiceRepository.save(existingInvoice);
        return existingInvoice;
    }

    @Override
    public void deleteInvoice(long id) {
        invoiceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Invoice","Id",id));
        invoiceRepository.deleteById(id);
    }
}
