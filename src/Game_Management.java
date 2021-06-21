package homework2;

import java.util.Random;

public class Game_Management {
	//the player who reaches the first or last letters wins to Birinci cinko in the game.
	//if both players win Birinci cinko at the same time ,they share the money.
	public void the_game() {
	//My stacks
	Stack Bag = new Stack(26);
	Stack Bag2 = new Stack(26);
	Stack Bag_temp = new Stack(26);
	Stack Bag_temp2 = new Stack(26);
	Stack Player_1 = new Stack(8);
	Stack Player_2 = new Stack(8);
	Random random = new Random();
	Stack player1_a_n = new Stack(14);
	Stack player1_o_z = new Stack(12);
	Stack player2_a_n = new Stack(14);
	Stack player2_o_z = new Stack(12);
	Stack player1_a_n_temp = new Stack(14);
	Stack player1_o_z_temp = new Stack(12);
	Stack player2_a_n_temp = new Stack(14);
	Stack player2_o_z_temp = new Stack(12);
	//Player 1 and Player 2's lottos fill randomly.
	for (int i = 78; i >= 65; i--) {
		player1_a_n.push((char) i);
		player2_a_n.push((char) i);
	}
	for (int i = 79; i <= 90; i++) {
		player1_o_z.push((char) i);
		player2_o_z.push((char) i);
	}
	for (int i = 0; i < 4; i++) {
		int rnd = random.nextInt(13 - i);
		for (int j = 0; j < rnd-1; j++) {
			player1_o_z_temp.push(player1_o_z.pop());
		}
		Player_1.push(player1_o_z.pop());
		while (!player1_o_z_temp.isEmpty()) {
			player1_o_z.push(player1_o_z_temp.pop());
		}
	}
	for (int i = 0; i < 4; i++) {
		int rnd = random.nextInt(15 - i);
		for (int j = 0; j < rnd-1; j++) {
			player1_a_n_temp.push(player1_a_n.pop());
		}
		Player_1.push(player1_a_n.pop());
		while (!player1_a_n_temp.isEmpty()) {
			player1_a_n.push(player1_a_n_temp.pop());
		}
	}
	for (int i = 0; i < 4; i++) {
		int rnd2 = random.nextInt(13 - i);
		for (int j = 0; j < rnd2-1; j++) {
			player2_o_z_temp.push(player2_o_z.pop());
		}
		Player_2.push(player2_o_z.pop());
		while (!player2_o_z_temp.isEmpty()) {
			player2_o_z.push(player2_o_z_temp.pop());
		}
	}
	for (int i = 0; i < 4; i++) {
		int rnd2 = random.nextInt(15 - i);
		for (int j = 0; j < rnd2-1; j++) {
			player2_a_n_temp.push(player2_a_n.pop());
		}
		Player_2.push(player2_a_n.pop());
		while (!player2_a_n_temp.isEmpty()) {
			player2_a_n.push(player2_a_n_temp.pop());
		}
	}
	//Bag are filled by using ASCII character.
	for (int i = 90; i >= 65; i--) {
		Bag.push((char) i);
		Bag_temp.push((char) i);
	}
	int random_count = 0;
	int player1_a_n_counter = 0;
	int player1_o_z_counter = 0;
	int player2_a_n_counter = 0;
	int player2_o_z_counter = 0;
	int player1_money = 0;
	int player2_money = 0;
	int space_temp=5;
	int space_temp2=5;
	//The game's loop. 
	while (true) {
		Stack temp_bag_random = new Stack(26);
		Stack temp2_bag_random = new Stack(26);
		Stack Player1_A_N_temp = new Stack(14);
		Stack Player1_O_Z_temp = new Stack(12);
		Stack Player2_A_N_temp = new Stack(14);
		Stack Player2_O_Z_temp = new Stack(12);
		for (int i = 78; i >= 65; i--) {
			Player1_A_N_temp.push((char) i);
			Player2_A_N_temp.push((char) i);
		}
		for (int i = 79; i <= 90; i++) {
			Player1_O_Z_temp.push((char) i);
			Player2_O_Z_temp.push((char) i);
		}
		int rnd = random.nextInt(27 - random_count);
		for (int i = 0; i < rnd-1; i++) {
			temp_bag_random.push(Bag_temp.pop());
		}
		//the part of display. 
		System.out.println("**********************************************************");
		System.out.println();
		System.out.print("Player1: ");
		for (int i = Player_1.size(); i > 0; i--) {
			temp2_bag_random.push(Player_1.peek());
			System.out.print(Player_1.pop() + " ");
		}
		while (!temp2_bag_random.isEmpty()) {
			Player_1.push(temp2_bag_random.pop());
		}
		for (int i = 0; i < space_temp; i++) {
			System.out.print(" ");
		}
		System.out.print("Bag1 ");
		while (!Bag.isEmpty()) {
			temp2_bag_random.push(Bag.peek());
			System.out.print(Bag.pop() + " ");
		}
		while (!temp2_bag_random.isEmpty()) {
			Bag.push(temp2_bag_random.pop());
		}
		System.out.println();
		System.out.print("Player2: ");
		for (int i = Player_2.size(); i > 0; i--) {
			temp2_bag_random.push(Player_2.peek());
			System.out.print(Player_2.pop() + " ");
		}
		while (!temp2_bag_random.isEmpty()) {
			Player_2.push(temp2_bag_random.pop());
		}
		for (int i = 0; i < space_temp2; i++) {
			System.out.print(" ");
		}
		System.out.print("Bag2 ");
		while (!Bag2.isEmpty()) {
			temp2_bag_random.push(Bag2.peek());
			Bag2.pop();
		}
		while (!temp2_bag_random.isEmpty()) {
			System.out.print(temp2_bag_random.peek()+" ");
			Bag2.push(temp2_bag_random.pop());
		}
		System.out.println();
		System.out.println();
		//Birinci cinko situation.
		if ((player1_a_n_counter == 4 || player1_o_z_counter == 4) && (player2_a_n_counter == 4 || player2_o_z_counter == 4)) {
			System.out.println("Both players won 'Birinci Çinko' at the same time.Therefore,they share the money.");
			System.out.println();
			System.out.println("Player1 gets $5 (Birinci Çinko) ");
			System.out.println("Player2 gets $5 (Birinci Çinko) ");
			System.out.println();
			player1_money += 5;
			player2_money += 5;
			player2_a_n_counter = 10;
			player2_o_z_counter = 10;
			player1_a_n_counter = 10;
			player1_o_z_counter = 10;
		}
		else if (player1_a_n_counter == 4 || player1_o_z_counter == 4) {
			System.out.println("Player1 gets $10 (Birinci Çinko) ");
			System.out.println();
			player1_money += 10;
			player1_a_n_counter = 10;
			player1_o_z_counter = 10;
			player2_a_n_counter = 10;
			player2_o_z_counter = 10;
		} else if (player2_a_n_counter == 4 || player2_o_z_counter == 4) {
			System.out.println("Player2 gets $10 (Birinci Çinko) ");
			System.out.println();
			player2_money += 10;
			player2_a_n_counter = 10;
			player2_o_z_counter = 10;
			player1_a_n_counter = 10;
			player1_o_z_counter = 10;
		}
		//the part of termination of the game 
		if (Player_1.size() == 0 && Player_2.size() == 0) {
			player1_money += 15;
			player2_money += 15;
			System.out.println("The game drew.Therefore,they share the money. ");
			System.out.println();
			System.out.println("Player1 gets $" + player1_money);
			System.out.println("Player2 gets $" + player2_money);
			break;
		} else if (Player_1.size() == 0) {
			System.out.println("Player1 is the winner");
			player1_money += 30;
			System.out.println();
			System.out.println("Player1 gets $" + player1_money);
			System.out.println("Player2 gets $" + player2_money);
			break;
		} else if (Player_2.size() == 0) {
			System.out.println("Player2 is the winner");
			player2_money += 30;
			System.out.println();
			System.out.println("Player1 gets $" + player1_money);
			System.out.println("Player2 gets $" + player2_money);
			break;
		}
		//the part of the all operations.
		for (int i = Player_1.size(); i > 0; i--) {
			temp2_bag_random.push(Player_1.peek());
			Player_1.pop();
		}
		while (!temp2_bag_random.isEmpty()) {
			if (temp2_bag_random.peek() == Bag_temp.peek()) {
				while (!Player1_A_N_temp.isEmpty()) {
					if (Player1_A_N_temp.peek() == Bag_temp.peek()) {
						player1_a_n_counter++;
						break;
					}
					Player1_A_N_temp.pop();
				}
				while (!Player1_O_Z_temp.isEmpty()) {
					if (Player1_O_Z_temp.peek() == Bag_temp.peek()) {
						player1_o_z_counter++;
						break;
					}
					Player1_O_Z_temp.pop();
				}
				temp2_bag_random.pop();
				space_temp+=2;
			}
			if (temp2_bag_random.isEmpty()) {
				break;
			}
			Player_1.push(temp2_bag_random.pop());
		}
		for (int i = Player_2.size(); i > 0; i--) {
			temp2_bag_random.push(Player_2.peek());
			Player_2.pop();
		}
		while (!temp2_bag_random.isEmpty()) {
			if (temp2_bag_random.peek() == Bag_temp.peek()) {
				while (!Player2_A_N_temp.isEmpty()) {
					if (Player2_A_N_temp.peek() == Bag_temp.peek()) {
						player2_a_n_counter++;
						break;
					}
					Player2_A_N_temp.pop();
				}
				while (!Player2_O_Z_temp.isEmpty()) {
					if (Player2_O_Z_temp.peek() == Bag_temp.peek()) {
						player2_o_z_counter++;
						break;
					}
					Player2_O_Z_temp.pop();
				}
				temp2_bag_random.pop();
				space_temp2+=2;
			}
			if (temp2_bag_random.isEmpty()) {
				break;
			}
			Player_2.push(temp2_bag_random.pop());
		}
		while (!Bag.isEmpty()) {
			temp2_bag_random.push(Bag.peek());
			Bag.pop();
		}
		while (!temp2_bag_random.isEmpty()) {
			Bag.push(temp2_bag_random.pop());
		}
		while (!Bag.isEmpty()) {
			if (Bag.peek() == Bag_temp.peek()) {
				Bag2.push(Bag.pop());
			}
			if (Bag.isEmpty()) {
				break;
			}
			Bag_temp2.push(Bag.pop());
		}
		while (!Bag_temp2.isEmpty()) {
			Bag.push(Bag_temp2.pop());
		}
		System.out.println("selected number: " + Bag_temp.peek());
		System.out.println();
		Bag_temp.pop();
		while (!temp_bag_random.isEmpty()) {
			Bag_temp.push(temp_bag_random.pop());
		}
		random_count++;
	}
	}
}
