package com.imooc.card;
/**
 * 扑克牌的牌面类
 * 纸牌具有种类，点数属性
 * @author jianquan
 */
public class Card
{
	//扑克牌的种类
	private String name;
	//扑克牌的点数
	private String value;
	
	public Card()
	{
		
	}
	/**
	 * 有参构造方法
	 * @param name	纸牌花色
	 * @param value	纸牌点数
	 */
	public Card(String name, String value)
	{
		this.name = name;
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return name + value;
	}
}
