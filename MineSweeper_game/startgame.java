package MineSweeper;

import java.util.Scanner;

public class startgame extends board {
    public void startgame(){
        System.out.println("\n\n================Welcome to Minesweeper ! ================\n");
        setupField(1);

        boolean flag = true;
        while(flag){
            displayVisible();
            flag = playMove();
            if(checkWin())
            {
                displayHidden();
                System.out.println("\n================You WON!!!================");
                break;
            }
        }
    }
    public boolean playMove()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter Row Number: ");
        int i= sc.nextInt();
        System.out.print("Enter Column Number: ");
        int j= sc.nextInt();

        if(i<0 || i>16 || j<0 || j>16 || grid[i][j]!=0)
        {
            System.out.print("\nIncorrect Input!!\n");
            return true;
        }

        if(hidGrid[i][j]==256)
        {
            displayHidden();
            System.out.print("Oops! You stepped on a mine!\n============GAME OVER============");
            return false;
        }
        else if(hidGrid[i][j]==0)
        {
            fixVisible(i, j);
        }
        else
        {
            fixNeighbours(i, j);
        }

        return true;
    }
    
    public boolean checkWin()
    {
        for(int i=0; i<16; i++)
        {
            for(int j=0; j<16; j++)
            {
                if(grid[i][j]==0)
                {
                    if(hidGrid[i][j]!=256)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}