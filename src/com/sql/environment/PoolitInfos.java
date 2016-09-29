package com.sql.environment;

import java.util.ArrayList;  
import java.util.List;

import com.sql.common.bean.DBbean;  
/** 
 * 初始化，模拟加载所有的配置文件 
 * @author Ran 
 * 
 */  
public class PoolitInfos { 
	
	private static List<DBbean> beans =  new ArrayList<DBbean>(); 
	private static int i=0;
	   
    public static List<DBbean> getBeans() throws Exception {
    	if(beans==null)
    		addBean(1);
		return beans;
	}

    
	/**
	 * @Description:获得单个DBbean
	 * @auther: wutongpeng 2016年9月28日 
	 * @return: DBbean
	 * @throws Exception 
	 */
	public static DBbean getBean(int databaseId) throws Exception{  
        DBbean bean = PropertiesReader.getDBbean(databaseId);    
        bean.setDriverName("com.mysql.jdbc.Driver");  
        bean.setUrl("jdbc:mysql://192.168.0.121:3306/test");  
        bean.setUserName("root");  
        bean.setPassword("123456");  
          
        bean.setMinConnections(5);  
        bean.setMaxConnections(100);  
        bean.setPoolName(String.valueOf(databaseId)+"Pool");
        return bean;
    } 
    
    /**
     * @Description:添加一个连接数据库信息
     * @auther: wutongpeng 2016年9月28日 
     * @param databaseId: void
     * @throws Exception 
     */
    public static void addBean(int databaseId) throws Exception{ 
    	
    	System.out.println("add"+"PoolitInfos.addBean(1)");
    	         
        DBbean bean = PropertiesReader.getDBbean(databaseId);       
       /* bean.setDriverName("com.mysql.jdbc.Driver");  
        bean.setUrl("jdbc:mysql://192.168.0.121:3306/test");  
        bean.setUserName("root");  
        bean.setPassword("123456"); */ 
        
        bean.setMinConnections(5);  
        bean.setMaxConnections(100);
        String poolname = String.valueOf(databaseId+i)+"Pool";
        System.out.println("poolname:"+poolname);
        bean.setPoolName(poolname);
        i++;
        beans.add(bean);
    }  
}  
