package com.example.demo2;

public class Check {
    protected int[][] winner;
    protected int win;

    public Check()
    {
        winner = new int[4][4];
        for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                winner[i][j] = 0;
            }
        }
    }

    public int Win_plus()
    {
        int win = 0;
        int[] c = new int[10];
        for (int i = 0; i < 10; i++)
        {
            c[i] = 0;
        }
        for(int j = 0; j < 4; j++)
        {
            if(winner[0][j] == 1) c[0]++;
            if(winner[1][j] == 1) c[1]++;
            if(winner[2][j] == 1) c[2]++;
            if(winner[3][j] == 1) c[3]++;
            if(winner[j][0] == 1) c[4]++;
            if(winner[j][1] == 1) c[5]++;
            if(winner[j][2] == 1) c[6]++;
            if(winner[j][3] == 1) c[7]++;
            if(winner[j][j] == 1) c[8]++;
            if(winner[3-j][j] == 1) c[9]++;
        }

        for(int i = 0; i < 10; i++)
        {
            if(c[i] >= 4) win = 1;
        }
        return win;
    }

    public int Win_minus()
    {
        int win = 0;
        int[] c = new int[10];
        for (int i = 0; i < 10; i++)
        {
            c[i] = 0;
        }
        for(int j = 0; j < 4; j++)
        {
            if(winner[0][j] == -1) c[0]++;
            if(winner[1][j] == -1) c[1]++;
            if(winner[2][j] == -1) c[2]++;
            if(winner[3][j] == -1) c[3]++;
            if(winner[j][0] == -1) c[4]++;
            if(winner[j][1] == -1) c[5]++;
            if(winner[j][2] == -1) c[6]++;
            if(winner[j][3] == -1) c[7]++;
            if(winner[j][j] == -1) c[8]++;
            if(winner[3-j][j] == -1) c[9]++;
        }

        for(int i = 0; i < 10; i++)
        {
            if(c[i] >= 4) win = 1;
        }
        return win;
    }

    public void add(int i, int j, int count) {
        winner[i][j] = count;
    }
}
