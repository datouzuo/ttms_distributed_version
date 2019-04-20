package xin.mengzuo.business.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.mengzuo.business.pojo.DayStatist;
import xin.mengzuo.business.pojo.MouthStatist;
import xin.mengzuo.business.repository.DayStatistRepository;
import xin.mengzuo.business.repository.MouthStatistRepository;

/**
 * 统计处理类
 * @author 左利伟
 *
 */
@Service
@Transactional
public class StatistServiceImp implements StatistService {
@Autowired
	private DayStatistRepository dsr;
 
 @Autowired 
 private MouthStatistRepository msr;
 /**
  * 存储统计
  */
	@Override
	public void saveStatis(DayStatist dayS, MouthStatist mouS) {
        //查找是否有对应的天	 
		DayStatist dS = null;
		dS = dsr.findByMovieIdAndDateDay(dayS.getMovieId(), dayS.getDateDay());
		if(dS!=null) {
		 double money =   dS.getDayMoney()+dayS.getDayMoney();
		 dS.setDayMoney(money);
		}else {
			dsr.save(dayS);
		}
		//查找是否有对应的月
		MouthStatist mS = null;
		mS = msr.findByMovieIdAndDateMouth(mouS.getMovieId(), mouS.getDateMouth());
		if(mS!=null) {
			double mmoney =   mS.getMouthMoney()+mouS.getMouthMoney();
			 mS.setMouthMoney(mmoney);
		}else {
			msr.save(mS);
		}
		
		
		
	}
	/**
	 * 获得某天的所有电影销售
	 */
@Override
public List<DayStatist> findByDateDayOrderMouthMoneyDesc(String dateDay) {


	return dsr.findByDateDayOrderMouthMoneyDesc(dateDay);
}
/**
 * 获得电影所有天数销售
 */
@Override
public List<DayStatist> findByMovieIdOrderDateDesc(String movieId) {
	
	return dsr.findByMovieIdOrderDateDesc(movieId);
}
/**
 * 获得所有天数
 */
@Override
public List<String> findDateDay() {

	return dsr.findDateDay();
}
	
	
/**
 * 按月份获取票房
 */
public List<MouthStatist> findByDateMouthOrderMouthMoneyDesc(String dateMouth){
	return msr.findByDateMouthOrderMouthMoneyDesc(dateMouth);
}
/**
 * 获取所有月份
 */
@Override
public List<String> findDateMouth() {
	
	return msr.findDateMouth();
}

	
	
	
}
