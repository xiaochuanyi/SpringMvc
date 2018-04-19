package Service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import bean.Iteam;
import mapper.MapperIteam;
@Service
public class IteamServiceImpl implements IteamService {
		
	public List<Iteam> select(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MapperIteam u = (MapperIteam) ac.getBean("MapperIteam");
		List<Iteam> list = u.selectList();
		return list;
	}
}
