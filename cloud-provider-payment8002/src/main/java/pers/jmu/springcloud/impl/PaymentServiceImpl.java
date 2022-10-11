package pers.jmu.springcloud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.jmu.springcloud.dao.PersonDao;
import pers.jmu.springcloud.entities.Person;
import pers.jmu.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PersonDao personDao;

    @Override
    public Person getPerson(String classCn) {
        return personDao.getPerson(classCn);
    }
}
