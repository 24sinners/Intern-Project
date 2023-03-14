package data.user_info.controller;

import data.user_info.model.Date;
import data.user_info.model.Wifi;
import data.user_info.service.DateService;
import data.user_info.service.WifiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/wifi")
public class WifiController {
    private WifiService wifiService;

    public WifiController(WifiService wifiService){
        this.wifiService = wifiService;
    }

    @PostMapping()
    public ResponseEntity<Wifi> saveWifi(@RequestBody Wifi wifi){
        return new ResponseEntity<Wifi>(wifiService.saveWifi(wifi), HttpStatus.CREATED);

    }
    //build get wifi REST API
    //http://localhost:8080/api/date/1
    @GetMapping
    public List<Wifi> getAllWifi(){
        return wifiService.getAllWifi();
    }

    @GetMapping("{id}")
    public ResponseEntity<Wifi>getWifiById(@PathVariable("id") long wifiid){
        return new ResponseEntity<Wifi>(wifiService.getWifiById(wifiid),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateWifi(@PathVariable ("id") long wifiId, @RequestBody Wifi wifi){
        wifiService.updateWifi(wifi,wifiId);

        return new ResponseEntity<String>("Wifi Updated Successfully!.",HttpStatus.OK);
    }

    //build delete wifi REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWifi(@PathVariable ("id") long wifiid){
        wifiService.deleteWifi(wifiid);
        return new ResponseEntity<String>("Wifi deleted successfully!.", HttpStatus.OK);

    }
}
