package data.user_info.controller;

import data.user_info.model.Date;
import data.user_info.service.DateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/date")
public class DateController {
    private DateService dateService;

    public DateController(DateService dateService){
        this.dateService = dateService;
    }

    @PostMapping()
    public ResponseEntity<Date> saveDate(@RequestBody Date date){
        return new ResponseEntity<Date>(dateService.saveDate(date), HttpStatus.CREATED);

    }
    //build get date REST API
    //http://localhost:8080/api/date/1
    @GetMapping
    public List<Date> getAllDate(){
        return dateService.getAllDate();
    }

    @GetMapping("{id}")
    public ResponseEntity<Date>getUserById(@PathVariable("id") long dateid){
        return new ResponseEntity<Date>(dateService.getDateById(dateid),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateDate(@PathVariable ("id") long dateId, @RequestBody Date date){
        dateService.updateDate(date,dateId);

        return new ResponseEntity<String>("Date Updated Successfully!.",HttpStatus.OK);
    }

    //build delete date REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDate(@PathVariable ("id") long dateid){
        dateService.deleteDate(dateid);
        return new ResponseEntity<String>("Date deleted successfully!.", HttpStatus.OK);

    }

}
