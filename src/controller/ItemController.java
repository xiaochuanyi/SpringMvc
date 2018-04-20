package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
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
import exception.MessageException;

/*
 * 商品管理
 */
@Controller
public class ItemController {

	@RequestMapping(value="/item/itemlist.action")
	public void itemList(Model mav,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws MessageException{
		if(null == null){
			throw new MessageException("已知的错误");
		}
		IteamService  IteamServiceImpl = new Service.IteamServiceImpl();
		List<Iteam> list = IteamServiceImpl.select();
		mav.addAttribute("itemList", list);//itemList是jsp中的，即把list值赋给itemList
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	@RequestMapping(value="updateitem.action")
	public ModelAndView update(Iteam iteam){
		IteamService  IteamServiceImpl = new Service.IteamServiceImpl();
		iteam.setCreatetime(new Date());
		IteamServiceImpl.update(iteam);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		return mav;
	}
	@RequestMapping(value="/delete.action")
	public ModelAndView delete(int[] ids){
	ModelAndView mav = new ModelAndView();
	mav.setViewName("/WEB-INF/jsp/itemList.jsp");
	return mav;
	}
}
