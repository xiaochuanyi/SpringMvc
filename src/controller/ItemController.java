package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Iteam;

/*
 * ��Ʒ����
 */
@Controller
public class ItemController {
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList(){
		List<Iteam> list = new ArrayList<Iteam>();
		list.add(new Iteam(1,"����note6",1099f,new Date(),"����"));
		list.add(new Iteam(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�1"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);//itemList��jsp�еģ�����listֵ����itemList
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		return mav;
	}

}
