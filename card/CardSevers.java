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
	// 存放纸牌的花色集合用于后面纸牌的比较
	private List<String> cardBreed;
	// 存放纸牌的点数集合用于后面纸牌的比较
	private List<String> cardNumber;

	// 按顺序生成扑克牌
	public CardSevers()
	{
		this.list = new ArrayList<Card>();
		this.cardBreed = new ArrayList<String>();
		this.cardNumber = new ArrayList<String>();
		// 纸牌的花色
		String[] str1 = { "方块", "梅花", "红桃", "黑桃" };
		this.cardBreed.addAll(Arrays.asList(str1));
		// 纸牌的点数
		String[] str2 = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		this.cardNumber.addAll(Arrays.asList(str2));

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
	public Player[] compareCard(Player[] players)
	{
		Player[] playerList = new Player[players.length+1];
		int i = 0;
		Card maxCard, maxAllCard;
		playerList[players.length] = new Player(players[0].getId(), players[0].getName());
		
		//找出玩家所持最大的纸牌
		for( Player player : players )
		{
			maxCard = maxAllCard = player.getCards().get(0);
			
			for( Card card : player.getCards() )
			{
				if( this.cardNumber.indexOf(maxCard.getValue()) < this.cardNumber.indexOf(card.getValue()) )
				{
					maxCard = card;
				}
				else if( this.cardBreed.indexOf(maxCard.getName()) < this.cardBreed.indexOf(card.getName()) )
				{
					maxCard = card;
				}
			}
			
			if(  this.cardNumber.indexOf(maxCard.getValue()) > this.cardNumber.indexOf(maxAllCard.getValue()) )
			{
				if( this.cardBreed.indexOf(maxCard.getName()) > this.cardBreed.indexOf(maxAllCard.getName()) )
				{
					maxAllCard = maxCard;
					playerList[players.length].setId(player.getId());
					playerList[players.length].setName(player.getName());
					playerList[players.length].addCard(maxAllCard);
				}
			}
			
			playerList[i] = new Player(player.getId(), player.getName());
			playerList[i++].addCard(maxCard);
		}
		
		return playerList;
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
		for( int i = 0; i < players.length-1; i++ )
		{
			System.out.print(players[i].getName() + "所持的最大纸牌：");
			System.out.println(players[i].getCards().get(0).toString());
		}
	}
}
