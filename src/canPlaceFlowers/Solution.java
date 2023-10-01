package canPlaceFlowers;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 1;
        int m = flowerbed.length;
        if(m>=2&&flowerbed[0]==0&&flowerbed[1]==0&&n!=0){
            flowerbed[0] = 1;
            n--;
        }
        else if(m<2&&flowerbed[0]==0&&n!=0){
            flowerbed[0] = 1;
            n--;
        }

        while(i<flowerbed.length-1){
            if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0&&n!=0){
                flowerbed[i] = 1;
                n--;
            }
            i++;
            if(n==0){
                break;
            }
        }

        if(m>=2&&flowerbed[m-2]==0&&flowerbed[m-1]==0&&n!=0){
            flowerbed[m-1] = 1;
            n--;

        }

        return n == 0;


    }
}