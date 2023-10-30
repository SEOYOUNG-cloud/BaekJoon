import java.util.*;
import java.io.*;

class Solution {
	public String[] solution(String[] players, String[] callings) {
		HashMap<String, Integer> grade = new HashMap<>();

		// 1. 등수 넣음
		int i = 0;
		for(String player : players){
			grade.put(player, i++);
		}


		// 2. 부르자
		for(String winner : callings){
			int pre = grade.get(winner); // 현재 등수
			int next = pre - 1; // 다음 등수

			String loser = players[next]; // 추월당한 선수 이름

			// 2-1. grade hashmap에 있는 애들 등수 변경
			grade.put(winner, next);
			grade.put(loser, pre);

			// 2-2. 찐 자리 변경
			players[next] = winner;
			players[pre] = loser;
		}

		return players;
	}
}