package data.user_info.service;

import data.user_info.model.Date;
import data.user_info.model.User;

import java.util.List;


public interface DateService {
    Date saveDate(Date date);
    List<Date> getAllDate();
    Date getDateById(long id);
    Date updateDate(Date date, long id);
    void deleteDate(long id);
}
