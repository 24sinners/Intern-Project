package data.user_info.service.impl;

import data.user_info.exception.ResourceNotFoundException;
import data.user_info.model.Wifi;
import data.user_info.repository.WifiRepository;
import data.user_info.service.WifiService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WifiServiceImpl implements WifiService {

    private WifiRepository wifiRepository;
    public WifiServiceImpl(WifiRepository wifiRepository){
        this.wifiRepository = wifiRepository;

    }
    //save wifi
    @Override
    public Wifi saveWifi(Wifi wifi) {

        return wifiRepository.save(wifi);
    }

    //select wifi
    @Override
    public List<Wifi> getAllWifi() {
        return wifiRepository.findAll() ;
    }

    //select by id
    @Override
    public Wifi getWifiById(long id) {
        return wifiRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Wifi","Id",id));
    }


    @Override
    public Wifi updateWifi(Wifi wifi, long id) {
        Wifi existingWifi =  wifiRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Wifi","Id",id));
        existingWifi.setType(wifi.getType());
        existingWifi.setBandwidth(wifi.getBandwidth());

        wifiRepository.save(existingWifi);
        return existingWifi;
    }

    @Override
    public void deleteWifi(long id) {
        wifiRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Wifi","Id",id));
        wifiRepository.deleteById(id);
    }
}
