package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView itemList(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws MessageException{
		IteamService  IteamServiceImpl = new Service.IteamServiceImpl();
		List<Iteam> list = IteamServiceImpl.select();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList",list);
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
	@RequestMapping(value="updateitem.action")
	public ModelAndView update(Iteam iteam,MultipartFile pictureFile) throws Exception{//MultipartFile的名字只能为jsp中图片的name
		//保存图片到 
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		//jpg
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());		
		pictureFile.transferTo(new File("D:\\upload\\" + name + "." + ext));
		iteam.setPic(name+"."+ext);
		IteamService  IteamServiceImpl = new Service.IteamServiceImpl();
		//iteam.setCreatetime(new Date());
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
