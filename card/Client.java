package com.imooc.card;

import java.util.Scanner;

/** * 一、创建一副扑克牌 * 包括四种花色： 黑桃、红桃、梅花、方片 * 十三种点数：2——10，J、Q、K、A，不考虑大小王 
 *  二、创建两名玩家 * 玩家至少要有ID、姓名、手牌等属性，手牌为扑克牌的集合  
 *  三、洗牌 * 将之前创建的“一副扑克牌”打乱顺序 *
 *  四、发牌 * 将洗牌之后的扑克牌集合，从第一张开始，发给两名玩家，按照一人一张的方式，每人发两张  
 *  五、游戏 * 比较两名玩家手中的扑克牌，规则为：取两人各自手中点数最大的牌进行比较，点数大的赢；
 * 	若两人各自的点数最大的牌相等，则再按花色（黑红梅方）比较。
*/

public class Client
{
	/**
	 * 创建纸牌服务类
	 * @return 纸牌服务对象
	 */
	public static CardSevers createCard()
	{
		System.out.println("创建扑克牌");
		CardSevers cs = new CardSevers();
		System.out.println("扑克牌创建成功");
		cs.traversalList();
		System.out.println("洗牌开始");
		cs.shuffleList();
		System.out.println("洗牌结束");
		return cs;
	}
	/**
	 * 创建玩家对象
	 * @return 玩家对象数组
	 */
	public static Player[] createPlayer(int cnt)
	{
		Player[] players = new Player[cnt];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("创建玩家");
		
		for( int i = 0; i < cnt; i++ )
		{
			try
			{
				System.out.print("请输入第"+(i+1)+"个玩家的ID：");
				int id = Integer.parseInt(sc.next());
				System.out.print("请输入第"+(i+1)+"个玩家的姓名：");
				String name = sc.next();
				players[i] = new Player(id, name);
			}
			catch(NumberFormatException e)
			{
				System.out.println("ID不正确，请输入数字!");
				i--;
			}
		}
		
		sc.close();
		
		return players;
	}
	
	public static void main(String[] args)
	{
		//创建纸牌服务对象
		CardSevers cs = createCard();
		//创建玩家数组, 参数设置玩家个数
		Player[] players = createPlayer(3);
		//游戏开始，进行发牌，参数设置玩家可以拿到的纸牌数量
		cs.dealCard(players, 3);
		//获得所有玩家最大的牌
		Player maxPlayer = cs.compareCard(players);
		//遍历所有玩家的最大牌
		cs.traversalAllPlayerMaxCards(players);
		//遍历所有玩家的所持牌
		cs.traversalAllPlayerCards(players);
		
		System.out.println("最后获胜的是：" + maxPlayer.getName());
	}
}
