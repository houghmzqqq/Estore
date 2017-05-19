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
	//�ļ���
	private String[] imgFileName;
	//�ļ�����
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
	 *�����û��ϴ����ļ����������ڷ�������
	 *@param name
	 *@return
	 */
	public String addCommodity() throws Exception
	{
		List<CommodityImg> commodityImgs = new ArrayList<CommodityImg>();
		
		//����ͼƬ�ļ���Ϣ
		for(int i=0; i<img.length; i++)
		{
			//���ɶ�һ�޶���UUID����Ϊ�ļ���
			String uuidname = UUID.randomUUID().toString() + "_" + getImgFileName()[i];
			//��Ŀ¼�洢����ֹһ���ļ������ļ�����
			String savepath = "upload";
			String hash = Integer.toHexString(uuidname.hashCode());
			for(char c : hash.toCharArray())
			{
				savepath += "/"+c;
			}
			
			//��װͼƬ��Ϣ
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
