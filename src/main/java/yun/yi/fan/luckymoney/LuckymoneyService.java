package yun.yi.fan.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;

    @Transactional
    public void createTwo(){
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("赵双红");
        luckymoney1.setMoney(new BigDecimal("520"));
        luckymoneyRepository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("李潘");
        luckymoney2.setMoney(new BigDecimal("1314"));
        luckymoneyRepository.save(luckymoney2);
    }



}

