package data.user_info.service;

import data.user_info.model.Date;
import data.user_info.model.Wifi;

import java.util.List;

public interface WifiService {
    Wifi saveWifi(Wifi wifi);
    List<Wifi> getAllWifi();
    Wifi getWifiById(long id);
    Wifi updateWifi(Wifi wifi, long id);
    void deleteWifi(long id);
}
