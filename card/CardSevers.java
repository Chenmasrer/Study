package com.imooc.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 扑克牌服务类
 * 
 * @author jianquan
 */
public class CardSevers
{
	// 扑克牌集合
	private List<Card> list;
	// 存放纸牌的点数和花色集合用于后面纸牌的比较
	private List<String> cardNumber;

	// 按顺序生成扑克牌
	public CardSevers()
	{
		this.list = new ArrayList<Card>();
		this.cardNumber = new ArrayList<String>();
		// 纸牌的花色
		String[] str1 = { "方块", "梅花", "红桃", "黑桃" };
		this.cardNumber.addAll(Arrays.asList(str1));
		// 纸牌的点数
		String[] str2 = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		this.cardNumber.addAll(Arrays.asList(str2));
		//生成一副扑克牌
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 13; j++)
			{
				list.add(new Card(str1[i], str2[j]));
			}
		}
	}

	/**
	 * 打乱列表中的顺序
	 * 
	 * @param list
	 */
	public void shuffleList()
	{
		Collections.shuffle(this.list);
	}

	/**
	 * 遍历扑克牌
	 */
	public void traversalList()
	{
		System.out.println(list.toString());
	}

	/**
	 * 对游戏玩家进行发牌
	 * 
	 * @param players
	 */
	public void dealCard(Player[] players, int cnt)
	{
		System.out.println("开始发牌");
		for (int i = 0; i < cnt; i++)
		{
			for (Player player : players)
			{
				System.out.println(player.getName() + "获得一张牌");
				player.addCard(list.remove(0));
			}
		}
		System.out.println("发牌结束");
	}

	/**
	 * 找出所有玩家所持最大的纸牌和所持最大纸牌的玩家
	 * @param players
	 */
	public Player compareCard(Player[] players)
	{
		//存放所持牌最大的玩家
		Player maxPlayer = new Player();
		//每个玩家的最大牌和所有玩家中最大的牌
		Card maxCard, maxAllCard;
		//初始化最大牌和玩家
		maxAllCard = players[0].getCards().get(0);
		maxPlayer.setName(players[0].getName());
		
		//找出玩家所持最大的纸牌
		for( Player player : players )
		{
			maxCard = player.getCards().get(0);
			//找出玩家手中最大的牌
			for( Card card : player.getCards() )
			{
				//比较点数，点数相同再比较花色
				if( getNumber(card.getValue()) > getNumber(maxCard.getValue()) )
				{
					maxCard = card;
				}
				else if( getNumber(card.getValue()) == getNumber(maxCard.getValue()))
				{
					if( getNumber(card.getName()) > getNumber(maxCard.getName()) )
					{
						maxCard = card;
					}
				}
			}
			
			player.setCard(maxCard);
			//比较点数，点数相同再比较花色， 找出所有玩家最大的牌
			if( getNumber(maxCard.getValue()) > getNumber(maxAllCard.getValue()) )
			{
				maxAllCard = maxCard;
				maxPlayer.setName(player.getName());	
			}
			else if( getNumber(maxCard.getValue()) == getNumber(maxAllCard.getValue()) )
			{
				if( getNumber(maxCard.getName()) > getNumber(maxAllCard.getName()) )
				{
					maxAllCard = maxCard;
					maxPlayer.setName(player.getName());	
				}
			}
		}
		
		return maxPlayer;
	}
	
	/**
	 * 获取比较的点数，通过扑克牌在集合的位置来比较大小
	 * @param str 扑克牌属性
	 * @return 点数
	 */
	public int getNumber(String str)
	{
		return this.cardNumber.indexOf(str);
	}
	
	/**
	 * 遍历所有玩家所持的纸牌
	 * @param players
	 */
	public void traversalAllPlayerCards(Player[] players)
	{
		for( Player player : players )
		{
			System.out.print(player.getName() + "所持的纸牌：");
			System.out.println(player.getCards().toString());
		}
	}
	
	/**
	 * 遍历所有玩家所持的最大纸牌
	 * @param players
	 */
	public void traversalAllPlayerMaxCards(Player[] players)
	{
		for( Player player : players )
		{
			System.out.print(player.getName() + "所持的最大纸牌：");
			System.out.println(player.getCard().toString());
		}
	}
}
