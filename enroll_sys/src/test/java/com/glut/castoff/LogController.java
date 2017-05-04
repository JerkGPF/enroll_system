package com.glut.castoff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Caizhf
 * @date 2017年4月17日下午10:41:10
 * @version v.0.1
 * <p>Description: 测试logger,此类已经被抛弃，留作参考。</p>
 *
 */
@Deprecated

@RestController
@RequestMapping("/log")
public class LogController {
	private static Logger logger = LoggerFactory.getLogger(LogController.class);
	
	@ResponseBody
	@GetMapping("/{id}")
	public String testLog(@PathVariable int id){
		try{
			logger.debug("获取到id="+id);
			logger.info("尝试写入日志="+id);
			logger.warn("准备抛出异常");
			throw new RuntimeException("异常异常！");
		}catch(Exception e){
			logger.error("异常出现！！："+e.getMessage());
		}
		return "success";
	}
	
	@GetMapping("/ex")
	public void testLog2(){
		throw new RuntimeException("cuowu");
	}
}