package data.user_info.controller;

import data.user_info.model.Date;
import data.user_info.model.Invoice;
import data.user_info.service.DateService;
import data.user_info.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @PostMapping()
    public ResponseEntity<Invoice> saveDate(@RequestBody Invoice invoice){
        return new ResponseEntity<Invoice>(invoiceService.saveInvoice(invoice), HttpStatus.CREATED);

    }
    //build get invoice REST API
    //http://localhost:8080/api/date/1
    @GetMapping
    public List<Invoice> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @GetMapping("{id}")
    public ResponseEntity<Invoice>getInvoiceById(@PathVariable("id") long invoiceid){
        return new ResponseEntity<Invoice>(invoiceService.getInvoiceById(invoiceid),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateInvoice(@PathVariable ("id") long invoiceId, @RequestBody Invoice invoice){
        invoiceService.updateInvoice(invoice,invoiceId);

        return new ResponseEntity<String>("Invoice Updated Successfully!.",HttpStatus.OK);
    }

    //build delete date REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable ("id") long invoiceid){

        return new ResponseEntity<String>("Invoice deleted successfully!.", HttpStatus.OK);

    }
}
