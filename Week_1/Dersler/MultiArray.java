package Week_1.Dersler;

import java.util.Scanner;

public class MultiArray {
    public static void main(String[] args) {
        int[][] matrix = new int[2][3];
        int Input;

        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=3;

        matrix[1][0]=4;
        matrix[1][1]=5;
        matrix[1][2]=6;

        int[][] Matrix2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] Matrix3 = {
                {10,20,30},
                {40,50,60},
                {70,80,90},
                {100,110,120}
        };

        for(int i =0; i<matrix.length;i++)
        {
            for (int j=0; j<matrix[i].length;j++)
            {
                System.out.println("["+i+"] ["+j+"] =" + matrix[i][j]);
            }

        }
        System.out.println("------------------------");
        int Total =0;
        for (int i =0; i<Matrix2.length;i++)
        {
            for(int j = 0; j<Matrix2[i].length; j++)
            {
                if(i==j)
                {
                    System.out.println("["+i+"] ["+j+"] =" + Matrix2[i][j]);
                    Total+=Matrix2[i][j];
                }

            }
        }
        System.out.println("[0,0]+[1,1]+[2,2] = "+Total);

        System.out.println("------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir deger giriniz : ");
        Input=scanner.nextInt();

        for(int i=0; i<Matrix3.length;i++)
        {
            for(int j=0; j<Matrix3[i].length;j++)
            {
                if(Matrix3[i][j]==Input)
                {
                    System.out.print("Aradanız Sayı  Matrix : "+"["+i+"]"+"["+j+"]"+" Bulundu!!" );
                    break;
                }
            }

        }
    }
}
