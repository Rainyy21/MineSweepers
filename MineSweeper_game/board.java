package MineSweeper;
import java.util.Random;
import java.util.random.*;

public class board {
    //for diffcuilty
    private int x = 16, y = 16;
    private int field = x*y;
    private int mines = 40;

    //grid size
    protected int[][] grid = new int[x][y];
    protected int[][] hidGrid = new int[x][y];


    //set up the field
    public void setupField(int diff)
    {
        int var=0;
        while(var!=mines)
        {
            Random random = new Random();
            int i = random.nextInt(x);
            int j = random.nextInt(y);
            //System.out.println("i: " + i + " j: " + j);
            hidGrid[i][j] = field;
            var++;
        }
        buildHidden();
    }

    //the hiddend field with mine and open space
    public void buildHidden(){
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                int cnt=0;
                if(hidGrid[i][j]!=field)
                {
                    if(i!=0)
                    {
                        if(hidGrid[i-1][j]==field) cnt++;
                        if(j!=0)
                        {
                            if(hidGrid[i-1][j-1]==field) cnt++;
                        }
                    }
                    if(i!= x-1)
                    {
                        if(hidGrid[i+1][j]==field) cnt++;
                        if(j!=y-1)
                        {
                            if(hidGrid[i+1][j+1]==field) cnt++;
                        }
                    }
                    if(j!=0)
                    {
                        if(hidGrid[i][j-1]==field) cnt++;
                        if(i!=x-1)
                        {
                            if(hidGrid[i+1][j-1]==field) cnt++;
                        }
                    }
                    if(j!=y-1)
                    {
                        if(hidGrid[i][j+1]==field) cnt++;
                        if(i!=0)
                        {
                            if(hidGrid[i-1][j+1]==field) cnt++;
                        }
                    }

                    hidGrid[i][j] = cnt;
                }
            }
        }
    }

    //what the plater will see 

    public void displayVisible()
    {
        System.out.print("\t ");
        for(int i=0; i<x; i++)
        {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<y; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<y; j++)
            {
                if(grid[i][j]==0)
                {
                    System.out.print("?");
                }
                else if(grid[i][j]==(field/2))
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(grid[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }

    //what the player will see
    public void fixVisible(int i, int j)
    {
        grid[i][j] = 128;
        if(i!=0)
        {
            grid[i-1][j] = hidGrid[i-1][j];
            if(grid[i-1][j]==0) grid[i-1][j] = field/2;
            if(j!=0)
            {
                grid[i-1][j-1] = hidGrid[i-1][j-1];
                if(grid[i-1][j-1]==0) grid[i-1][j-1]= field/2;

            }
        }
        if(i!=x-1)
        {
            grid[i+1][j]=hidGrid[i+1][j];
            if(grid[i+1][j]==0) grid[i+1][j]= field/2;
            if(j!=y-1)
            {
                grid[i+1][j+1]= hidGrid[i+1][j+1];
                if(grid[i+1][j+1]==0) grid[i+1][j+1] = field/2;
            }
        }
        if(j!=0)
        {
            grid[i][j-1]=hidGrid[i][j-1];
            if(grid[i][j-1]==0) grid[i][j-1] = field/2;
            if(i!=x-1)
            {
                grid[i+1][j-1]=hidGrid[i+1][j-1];
                if(grid[i+1][j-1]==0) grid[i+1][j-1] = field/2;
            }
        }
        if(j!=y-1)
        {
            grid[i][j+1]=hidGrid[i][j+1];
            if(grid[i][j+1]==0) grid[i][j+1] = field/2;
            if(i!=0)
            {
                grid[i-1][j+1]=hidGrid[i-1][j+1];
                if(grid[i-1][j+1]==0) grid[i-1][j+1] = field/2;
            }
        }
    }

    public void fixNeighbours(int i, int j)
    {
        Random random = new Random();
        int x = random.nextInt()%4;

        grid[i][j] = hidGrid[i][j];

        if(x==0)
        {
            if(i!=0)
            {
                if(hidGrid[i-1][j]!=field)
                {
                    grid[i-1][j] = hidGrid[i-1][j];
                    if(grid[i-1][j]==0)  grid[i-1][j] = field/2;
                }
            }
            if(j!=0)
            {
                if(hidGrid[i][j-1]!=field)
                {
                    grid[i][j-1] = hidGrid[i][j-1];
                    if(grid[i][j-1]==0)  grid[i][j-1] = field/2;
                }

            }
            if(i!=0 && j!=0)
            {
                if(hidGrid[i-1][j-1]!=field)
                {
                    grid[i-1][j-1] = hidGrid[i-1][j-1];
                    if(grid[i-1][j-1]==0)  grid[i-1][j-1] = field/2;
                }

            }
        }
        else if(x==1)
        {
            if(i!=0)
            {
                if(hidGrid[i-1][j]!=field)
                {
                    grid[i-1][j] = hidGrid[i-1][j];
                    if(grid[i-1][j]==0)  grid[i-1][j] = field/2;
                }
            }
            if(j!=9)
            {
                if(hidGrid[i][j+1]!=field)
                {
                    grid[i][j+1] = hidGrid[i][j+1];
                    if(grid[i][j+1]==0)  grid[i][j+1] = field/2;
                }

            }
            if(i!=0 && j!=9)
            {
                if(hidGrid[i-1][j+1]!=field)
                {
                    grid[i-1][j+1] = hidGrid[i-1][j+1];
                    if(grid[i-1][j+1]==0)  grid[i-1][j+1] = field/2;
                }
            }
        }
        else if(x==2)
        {
            if(i!=9)
            {
                if(hidGrid[i+1][j]!=field)
                {
                    grid[i+1][j] = hidGrid[i+1][j];
                    if(grid[i+1][j]==0)  grid[i+1][j] = field/2;
                }
            }
            if(j!=9)
            {
                if(hidGrid[i][j+1]!=field)
                {
                    grid[i][j+1] = hidGrid[i][j+1];
                    if(grid[i][j+1]==0)  grid[i][j+1] = field/2;
                }

            }
            if(i!=9 && j!=9)
            {
                if(hidGrid[i+1][j+1]!=field)
                {
                    grid[i+1][j+1] = hidGrid[i+1][j+1];
                    if(grid[i+1][j+1]==0)  grid[i+1][j+1] = field/2;
                }
            }
        }
        else
        {
            if(i!=9)
            {
                if(hidGrid[i+1][j]!=field)
                {
                    grid[i+1][j] = hidGrid[i+1][j];
                    if(grid[i+1][j]==0)  grid[i+1][j] = field/2;
                }
            }
            if(j!=0)
            {
                if(hidGrid[i][j-1]!=field)
                {
                    grid[i][j-1] = hidGrid[i][j-1];
                    if(grid[i][j-1]==0)  grid[i][j-1] = field/2;
                }

            }
            if(i!=9 && j!=0)
            {
                if(hidGrid[i+1][j-1]!=field)
                {
                    grid[i+1][j-1] = hidGrid[i+1][j-1];
                    if(grid[i+1][j-1]==0)  grid[i+1][j-1] = field/2;
                }
            }
        }
    }

    public void displayHidden()
    {
        System.out.print("\t ");
        for(int i=0; i<x; i++)
        {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<x; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<y; j++)
            {
                if(hidGrid[i][j]==0)
                {
                    System.out.print(" ");
                }
                else if(hidGrid[i][j]==field)
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print(hidGrid[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }


}