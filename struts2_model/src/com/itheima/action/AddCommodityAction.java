package com.itheima.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.File;

import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;
import com.itheima.factory.CommodityService;
import com.itheima.service.CommodityServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddCommodityAction extends ActionSupport implements ModelDriven<Commodity>
{
	private Commodity commodity;
	private String[] img;
	//文件名
	private String[] imgFileName;
	//文件类型
	private String[] imgContentType;
	
	public String[] getImg() {
		return img;
	}

	public void setImg(String[] img) {
		this.img = img;
	}

	public String[] getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String[] imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String[] getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String[] imgContentType) {
		this.imgContentType = imgContentType;
	}

	/**
	 *接受用户上传的文件，并保存在服务器端
	 *@param name
	 *@return
	 */
	public String addCommodity() throws Exception
	{
		List<CommodityImg> commodityImgs = new ArrayList<CommodityImg>();
		
		//保存图片文件信息
		for(int i=0; i<img.length; i++)
		{
			//生成独一无二的UUID码作为文件名
			String uuidname = UUID.randomUUID().toString() + "_" + getImgFileName()[i];
			//分目录存储，防止一个文件夹中文件过多
			String savepath = "upload";
			String hash = Integer.toHexString(uuidname.hashCode());
			for(char c : hash.toCharArray())
			{
				savepath += "/"+c;
			}
			
			//封装图片信息
			CommodityImg comImg = new CommodityImg();
			comImg.setUuidname(uuidname);
			comImg.setRealname(getImgFileName()[i]);
			comImg.setSavepath(savepath);
			comImg.setIp(ServletActionContext.getRequest().getRemoteAddr());
			System.out.println(comImg);
			commodityImgs.add(comImg);
		}
		
		CommodityService commodityService = new CommodityServiceImpl();
		commodityService.addComm_service(commodity, commodityImgs, getImg());
		
		System.out.println(commodity);
		System.out.println(img);
		return SUCCESS;
			
	}

	@Override
	public Commodity getModel()
	{
		if(commodity == null)
		{
			commodity = new Commodity();
		}
		return commodity;
	}
}
