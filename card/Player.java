package com.imooc.card;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏的玩家类
 * 玩家具有ID， 姓名， 手中所持的牌属性
 * @author jianquan
 */
public class Player
{
	//玩家的ID
	private int id;
	//玩家的姓名
	private String name;
	//玩家手中的牌
	private List<Card> cards;
	
	public Player()
	{
		
	}
	
	public Player(int id, String name)
	{
		this.id = id;
		this.name = name;
		this.cards = new ArrayList<Card>();
	}
	
	
	/**
	 *玩家获取纸牌
	 * @param card
	 */
	public void addCard(Card card)
	{
		cards.add(card);
	}
	
	/**
	 * 遍历玩家手中的纸牌
	 */
	public void traversalList()
	{
		System.out.println(cards.toString());
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Card> getCards()
	{
		return cards;
	}

	public void setCards(List<Card> cards)
	{
		this.cards = cards;
	}
}
