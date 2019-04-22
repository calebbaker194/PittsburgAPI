package xtuple;

import java.math.BigDecimal;
import java.util.HashMap;

public class XItem extends Object{
	
	private int id;
	private String number;
	private String descrip1;
	private String descrip2;
	private int classcode_id;
	private String comments;
	private boolean isSold;
	private boolean isFractional;
	private boolean isActive;
	private char type;
	private float prodweight;
	private int prodcat_id;
	private float listprice;
	private String extdescrip;
	private String upccode;
	private int inv_uom_id;
	private int price_uom_id;
	
	public XItem()
	{
		
	}
	
	public XItem(HashMap<String, Object> item)
	{
		if(item.containsKey("item_id"))
		{
			setId((Integer) item.get("item_id"));
		}
		if(item.containsKey("item_number"))
		{
			setNumber((String) item.get("item_number"));
		}
		if(item.containsKey("item_descrip1"))
		{
			setDescrip1((String) item.get("item_descrip1"));
		}
		if(item.containsKey("item_descrip2"))
		{
			setDescrip2((String) item.get("item_descrip2"));
		}
		if(item.containsKey("item_classcode_id"))
		{
			setClasscode_id((Integer) item.get("item_classcode_id"));
		}
		if(item.containsKey("item_comments"))
		{
			setComments((String) item.get("item_comments"));
		}
		if(item.containsKey("item_isSold"))
		{
			setSold((Boolean) item.get("item_isSold"));
		}
		if(item.containsKey("item_isFractional"))
		{
			setFractional((Boolean) item.get("item_isFractional"));
		}
		if(item.containsKey("item_isActive"))
		{
			setActive((Boolean) item.get("item_isActive"));
		}
		if(item.containsKey("item_type"))
		{
			setType(((String) item.get("item_type")).charAt(0));
		}
		if(item.containsKey("item_prodweight"))
		{
			setProdweight(((BigDecimal) item.get("item_prodweight")).floatValue());
		}
		if(item.containsKey("item_prodcat_id"))
		{
			setProdcat_id((Integer) item.get("item_prodcat_id"));
		}
		if(item.containsKey("item_listprice"))
		{
			setListprice(((BigDecimal) item.get("item_listprice")).floatValue());
		}
		if(item.containsKey("extdescrip"))
		{
			setExtdescrip((String) item.get("extdescrip"));
		}
		if(item.containsKey("upccode"))
		{
			setUpccode((String) item.get("upccode"));
		}
		if(item.containsKey("inv_uom_id"))
		{
			setInv_uom_id((Integer) item.get("inv_uom_id"));
		}
		if(item.containsKey("price_uom_id"))
		{
			setPrice_uom_id((Integer) item.get("price_uom_id"));
		}
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getDescrip1()
	{
		return descrip1;
	}

	public void setDescrip1(String descrip1)
	{
		this.descrip1 = descrip1;
	}

	public int getClasscode_id()
	{
		return classcode_id;
	}

	public void setClasscode_id(int classcode_id)
	{
		this.classcode_id = classcode_id;
	}

	public String getDescrip2()
	{
		return descrip2;
	}

	public void setDescrip2(String descrip2)
	{
		this.descrip2 = descrip2;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public boolean isSold()
	{
		return isSold;
	}

	public void setSold(boolean isSold)
	{
		this.isSold = isSold;
	}

	public boolean isFractional()
	{
		return isFractional;
	}

	public void setFractional(boolean isFractional)
	{
		this.isFractional = isFractional;
	}

	public boolean isActive()
	{
		return isActive;
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public char getType()
	{
		return type;
	}

	public void setType(char type)
	{
		this.type = type;
	}

	public float getProdweight()
	{
		return prodweight;
	}

	public void setProdweight(float prodweight)
	{
		this.prodweight = prodweight;
	}

	public int getProdcat_id()
	{
		return prodcat_id;
	}

	public void setProdcat_id(int prodcat_id)
	{
		this.prodcat_id = prodcat_id;
	}

	public float getListprice()
	{
		return listprice;
	}

	public void setListprice(float listprice)
	{
		this.listprice = listprice;
	}

	public String getExtdescrip()
	{
		return extdescrip;
	}

	public void setExtdescrip(String extdescrip)
	{
		this.extdescrip = extdescrip;
	}

	public String getUpccode()
	{
		return upccode;
	}

	public void setUpccode(String upccode)
	{
		this.upccode = upccode;
	}

	public int getInv_uom_id()
	{
		return inv_uom_id;
	}

	public void setInv_uom_id(int inv_uom_id)
	{
		this.inv_uom_id = inv_uom_id;
	}

	public int getPrice_uom_id()
	{
		return price_uom_id;
	}

	public void setPrice_uom_id(int price_uom_id)
	{
		this.price_uom_id = price_uom_id;
	}
}
