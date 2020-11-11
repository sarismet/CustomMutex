package com.company;

public class ModifiedSwap {
    int isInCS = 0;
    int isCSFree = 1;

    int turn = -1;


    public synchronized void swap(int isCSFree,int isInCS){
        int temp = isCSFree;
        this.isCSFree = isInCS;
        this.isInCS = temp;
    }

        public synchronized boolean isNotFreeToEnterCS(int request,int release,int i) {


            if (turn == -1) {
                turn = (i+1)%2;
                swap(1,0);
                return false;
            }
            else if (i%2==turn&&request==1&&release==0&&isCSFree==1&&isInCS==0){
                swap(1,0);
                turn = (i+1)%2;
                return false;
            }


            return true;
            }
}
