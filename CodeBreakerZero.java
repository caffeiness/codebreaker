package net.codebreaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeBreakerZero {
	public static void main(String[] args) {
		String title="***CodeBreaker***";
		String rule="隠された3つの数字をあてます。\n"
                + "1つの数字は1から10の間です。\n"
                + "3つの答えの中に同じ数字はありません。\n"
                + "入力した数字の、"
                + "位置と数字が当たってたらヒット、\n"
                + "数字だけあってたらブローとカウントします。\n"
                + "全部当てたら(3つともヒットになったら)"
                + "終了です\n\n";
		int[] answer = new int[3];
		int[] input =new int[3];
		int hit=0,blow=0,count=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(title);
		System.out.println(rule);

		for(int i=0;i < answer.length;i++) {
			boolean flag = false;
			answer[i] = (int)(Math.random()*10+1);
			do {
				flag = false;
				for(int j = i-1;j >= 0;j--) {
					if(answer[i] == answer[j]) {
						flag = true;
						answer[i] = (int)(Math.random()*6+1);
					}
				}
			}while(flag == true);
		}
		while(true) {
			count++;
			System.out.println("***"+count+"回目**");
			for(int i=0;i <answer.length;i++) {
				System.out.print((i+1)+"個目：");
				try {
					input[i] = Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException e) {
					System.err.println("数値を入力してください");
					i--;
				}catch(IOException e) {
					System.out.println("もう一度入力してください");
					i--;
				}
			}
			hit = 0;
			blow = 0;
			for(int i = 0;i < answer.length;i++) {
				for(int j = 0;j < answer.length;j++) {
					if(i == j && input[i] == answer[j]) {
						hit++;
					}else if(input[i] == answer[j]) {
						blow++;
					}
				}
			}
			System.out.println("ヒット"+hit+"ブロー"+blow);
			if(hit ==3) {
				System.out.println("おめでとー");
			}else {
				System.out.println();
			}
			if(hit == 3) {
				count = 0;
			}
		}
	}
}
