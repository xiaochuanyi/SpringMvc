package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Service.IteamService;
import bean.Iteam;

/*
 * ��Ʒ����
 */
@Controller
public class ItemController {

	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList(){
		IteamService  IteamServiceImpl = new Service.IteamServiceImpl();
		List<Iteam> list = IteamServiceImpl.select();
		//list.add(new Iteam(1,"����note6",1099f,new Date(),"����"));
		//list.add(new Iteam(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�1"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);//itemList��jsp�еģ�����listֵ����itemList
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		return mav;
	}
	@RequestMapping(value="/itemEdit.action")
	public ModelAndView toEdit(Integer id,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
		IteamService  IteamServiceImpl = new Service.IteamServiceImpl();
		Iteam i = IteamServiceImpl.selectbyid(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", i);
		mav.setViewName("/WEB-INF/jsp/editItem.jsp");
		return mav;
		
	}
}
