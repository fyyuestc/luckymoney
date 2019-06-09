package yun.yi.fan.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;

    @Autowired
    private LuckymoneyService luckymoneyService;

    /**
     *
     * 查询红包
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> getList() {
        return luckymoneyRepository.findAll();
    }

    /**
     *
     * 创建红包
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return luckymoneyRepository.save(luckymoney);
    }

    /**
     *
     * 查询红包(id)
     */
    @GetMapping("/luckymoney/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return luckymoneyRepository.findById(id).orElse(null);
    }

    /**
     *
     * 更新红包(领红包)
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@RequestParam("consumer") String consumer,
                             @PathVariable("id") Integer id) {
        //先查询到id对应的红包
        Optional<Luckymoney> optional = luckymoneyRepository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            luckymoney.setId(id);
            return luckymoneyRepository.save(luckymoney);
        }else {
            return null;
        }
    }

    /**
     *
     * 数据库并发事务
     */
    @PostMapping("/two")
    public void createTwo(){
        luckymoneyService.createTwo();
    }

}
