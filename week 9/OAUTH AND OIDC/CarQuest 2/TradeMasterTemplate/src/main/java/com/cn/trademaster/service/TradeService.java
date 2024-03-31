package com.cn.trademaster.service;

import com.cn.trademaster.dto.TradeDto;
import com.cn.trademaster.model.Trade;
import com.cn.trademaster.repository.TradeRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepo tradeRepo;

    Logger logger = LoggerFactory.getLogger(TradeService.class);
    
    /**

     1. Create a logger object here from LoggerFactory and pass tradeService class
       as parameter for the getLogger() method.

     2. Implement logger in the methods below wherever required.

     **/

    public void executeTrade(TradeDto tradeDto) {
        Trade trade = new Trade();
        trade.setStockHolderUserName(tradeDto.getStockHolderUserName());
        trade.setPrice(tradeDto.getPrice());
        trade.setBuyTrade(tradeDto.isBuyTrade());
        trade.setQuantity(tradeDto.getQuantity());
        trade.setStockId(tradeDto.getStockId());
        trade.setStockName(tradeDto.getStockName());
        if(tradeDto.getQuantity() > 1500) {
        	logger.error("Trade quantity exceeds the maximum allowed quantity : 1500");
        } else {
        	
        	logger.warn("Remember your unique username");
        	tradeRepo.save(trade);
        	logger.info("Success: Stock with id '{}' added in portfolio for '{}'\", tradeDto.getStockId(), trade.getStockHolderUserName()");
        }
        
    /**
     1. First map the tradeDto object with the trade entity object before saving.

     2. After mapping tradeDto write the logic for printing an "ERROR" level log
        with an appropriate message whenever the quantity of stock exceeds the value
        of 1500 thus ending the execution of executeTrade() method.

     3. If quantity is in required range i.e. (less than 1500 ) then provide a "WARN"
        level log asking user to remember their unique username.
    **/
        
    /**
     4. Lastly, provide an "INFO" level log displaying a success message after the trade
        is successfully executed/saved.
    **/
        }


    public List<Trade> getTradeHistory(String username) {
        List<Trade> tradesByUsername = tradeRepo.findByStockHolderUserName(username);
        
        if(tradesByUsername.isEmpty()) {
        	logger.error("No trades found for the username : '{}'" , username);
        	
        }else {
        	logger.info("Fetching trade history for '{}'", username);
        }
        /**

         1. Use the findByStockHolderUserName() method of TradeRepo for fetching
            the list of Trade by username and save the returned value from this method
            to the tradesByUsername object declared above.

         2. Implement an "ERROR" level log if no trades are found by the username.

         3. Provide a simple "INFO" level log with a meaningful message if trades are found.

         4. Lastly, return tradesByUsername object.

         **/

        return tradesByUsername;
        }
}
