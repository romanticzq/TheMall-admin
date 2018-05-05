package com.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.project.model.Express;
import com.project.model.Orders;
import com.project.service.ExpressService;
import com.project.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ExpressService expressService;
	
	/**
	 * 查询订单
	 */
	@RequestMapping(value="order_list")
	public ModelAndView orderList(String status,String userName){
		System.out.println("进入显示");
		ModelAndView modelAndView=new ModelAndView("order/orderList");
		
		List<Orders> orderList=this.orderService.orderList(status,userName);
		modelAndView.addObject("num",orderList.size());
		modelAndView.addObject("sta",status);
		modelAndView.addObject("userName",userName);
		int size=orderList.size();
		if(size>5){
			orderList=orderList.subList(0, 5);
		}
		
		modelAndView.addObject("orderList", orderList);
		return modelAndView;
	}
	
	/**
	 * 分页插件查询订单
	 */
	@RequestMapping(value="order_list_page_plug")
	@ResponseBody
	public String orderListPagePlug(String status,String userName,int index){
		
		List<Orders> orderList=this.orderService.orderListPage(status, userName, index);
		
		JSONObject jo=new JSONObject();
		jo.put("orderList", orderList);
		return JSON.toJSONString(jo, SerializerFeature.DisableCircularReferenceDetect);
	}
	
	/**
	 * 发货页面
	 */
	@RequestMapping(value="order_to_delivery")
	public ModelAndView orderToSend(int id){
		
		ModelAndView modelAndView=new ModelAndView("order/delivery");
		List<Express> express=expressService.expressList();
		modelAndView.addObject("express", express);
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	/**
	 * 发货
	 */
	@RequestMapping(value="order_delivery",method=RequestMethod.POST)
	public ModelAndView orderSend(int id,String companyName,String deliveryNo){
		
		Orders order=orderService.findOrdersById(id);
		order.setDeliveryNo(deliveryNo);
		Express express=expressService.findExpressByName(companyName);
		order.setExpress(express);
		order.setOrderStatus("待收货");
		orderService.saveOrders(order);
		System.out.println(order.toString());
		return orderList(null,null);
	}
	
	
	/**
	 * 详情页面
	 */
	@RequestMapping(value="order_to_detail")
	public ModelAndView orderToDetail(int id){
		
		ModelAndView modelAndView=new ModelAndView("order/detail");
		Orders orders=orderService.findOrdersById(id);
		modelAndView.addObject("orders", orders);
		return modelAndView;
	}
	
	
	/**
	 * 物流页面
	 * @throws Exception 
	 */
	@RequestMapping(value="checkLog")
	public ModelAndView checkLog(int id) throws Exception{
		
		ModelAndView modelAndView=new ModelAndView("order/checkLog");
		Orders orders=orderService.findOrdersById(id);
		modelAndView.addObject("orders", orders);
		String log=(String) logistics(orders.getExpress().getCompanyNo(),orders.getDeliveryNo());
		
		JSONObject jo=JSON.parseObject(log);
		modelAndView.addObject("tra", jo.get("Traces"));
		return modelAndView;
	}
	
	/*********************物流相关*******************************/
	
//	private String EBusinessID="请到快递鸟官网申请http://www.kdniao.com/ServiceApply.aspx";
    private String EBusinessID="1328519";
    //电商加密私钥，快递鸟提供，注意保管，不要泄漏
//	private String AppKey="请到快递鸟官网申请http://www.kdniao.com/ServiceApply.aspx";
    private String AppKey="5c61e09a-44e4-4ac0-ae29-9c524f2e7551";
    //请求url
    private String ReqURL="http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";
    
    /**
     * 查看物流
     * @return
     */
    @RequestMapping(value = "/logistics",method = RequestMethod.POST)
    @ResponseBody
    public Object logistics(String expCode, String expNo) throws Exception{
        String requestData= "{'OrderCode':'','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", "1002");
        String dataSign=encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result=sendPost(ReqURL, params);

        //根据公司业务处理返回的信息......

        return result;
    }


    private String urlEncoder(String str, String charset) throws UnsupportedEncodingException {
        String result = URLEncoder.encode(str, charset);
        return result;
    }

    /**
     * 电商Sign签名生成
     * @param content 内容
     * @param keyValue Appkey
     * @param charset 编码方式
     * @throws UnsupportedEncodingException ,Exception
     * @return DataSign签名
     */
//    @SuppressWarnings("unused")
    private String encrypt (String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception
    {
        if (keyValue != null)
        {
            return base64(MD5(content + keyValue, charset), charset);
        }
        return base64(MD5(content, charset), charset);
    }

    /**
     * MD5加密
     * @param str 内容
     * @param charset 编码方式
     * @throws Exception
     */
//    @SuppressWarnings("unused")
    private String MD5(String str, String charset) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer(32);
        for (int i = 0; i < result.length; i++) {
            int val = result[i] & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param params 请求的参数集合
     * @return 远程资源的响应结果
     */
    private String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            if (params != null) {
                StringBuilder param = new StringBuilder();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if(param.length()>0){
                        param.append("&");
                    }
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    //System.out.println(entry.getKey()+":"+entry.getValue());
                }
                //System.out.println("param:"+param.toString());
                out.write(param.toString());
            }
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * base64编码
     * @param str 内容
     * @param charset 编码方式
     * @throws UnsupportedEncodingException
     */
    private String base64(String str, String charset) throws UnsupportedEncodingException{
        String encoded = base64Encode(str.getBytes(charset));
        return encoded;
    }

    private static char[] base64EncodeChars = new char[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/' };

    public static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }
}
