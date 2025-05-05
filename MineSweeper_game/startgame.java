package MineSweeper;

import java.util.Scanner;

public class startgame extends board {
    public void startgame(){
        System.out.println("\n\n================Welcome to Minesweeper ! ================\n");
        loadDiff();

        System.out.println("Enter the Difficulty Level");
        System.out.println("Press 0 for BEGINNER (9 * 9 Cells and 10 Mines)");
        System.out.println("Press 1 for INTERMEDIATE (16 * 16 Cells and 40 Mines)");
        System.out.println("Press 2 for ADVANCED (24 * 24 Cells and 99 Mines)\n");

        
        Scanner sc= new Scanner(System.in);
        int diff = sc.nextInt();
        setupDiff(diff);
        setupField();

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

        if(i<0 || i>=super.x || j<0 || j>=super.y || grid[i][j]!=0)
        {
            System.out.print("\nIncorrect Input!!\n");
            return true;
        }

        if(hidGrid[i][j]==super.lose)
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
        for(int i=0; i<=super.x; i++)
        {
            for(int j=0; j<=super.y; j++)
            {
                if(grid[i][j]==0)
                {
                    if(hidGrid[i][j]!=super.lose)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}