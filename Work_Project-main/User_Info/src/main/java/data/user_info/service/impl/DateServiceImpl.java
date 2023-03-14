package data.user_info.service.impl;

import data.user_info.exception.ResourceNotFoundException;
import data.user_info.model.Date;
import data.user_info.repository.DateRepository;
import data.user_info.service.DateService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DateServiceImpl implements DateService {
    private DateRepository dateRepository;
    public DateServiceImpl(DateRepository dateRepository){
        this.dateRepository = dateRepository;
    }

    @Override
    public Date saveDate(Date date) {
        return dateRepository.save(date);
    }

    @Override
    public List<Date> getAllDate() {
        return dateRepository.findAll();
    }

    @Override
    public Date getDateById(long id) {
        return dateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Date","Id",id));
    }

    @Override
    public Date updateDate(Date date, long id) {
        Date existingDate = dateRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Date","Id",id));

        existingDate.setDuration(date.getDuration());
        existingDate.setStart_date(date.getStart_date());
        existingDate.setEnd_date(date.getEnd_date());

        //save existing employee to DB
        dateRepository.save(existingDate);
        return existingDate;
    }

    @Override
    public void deleteDate(long id) {
        dateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Date", "Id",id));
        dateRepository.deleteById(id);
    }
}
