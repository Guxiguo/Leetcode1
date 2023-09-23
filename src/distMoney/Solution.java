package distMoney;

class Solution {
    public int distMoney(int money, int children) {
        if(money<children){
            return -1;
        }
        int max = 0;
        while(money>=children + 7&&children>0){
            max++;
            money-=8;
            children--;

        }
        if ((children == 1 && money == 4 && max > 0) || (children == 0 && money > 0)) {
            max--;
        }
        return max;
    }
}