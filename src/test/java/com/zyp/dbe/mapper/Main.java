package com.zyp.dbe.mapper;

/*
 * @Author: Ferapont
 * @Date: 2021/10/15 11:19
 * @PackageName: com.zyp.dbe.mapper
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int n = scanner.nextInt();
        int[] dp = new int[20005];
        for (int j = 0; j < n; ++j) {
            int coin = scanner.nextInt();
            for (int i = target; i >= coin; --i) {
                dp[i] = Math.max(dp[i], dp[i - coin] + coin);
            }
        }
        int res = target - dp[target];
        System.out.println(res);
    }
}
