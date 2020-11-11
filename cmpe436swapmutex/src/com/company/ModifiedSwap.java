package com.company;

public class ModifiedSwap {
    int isInCS = 0;
    int isCSFree = 1;

    public synchronized void swap(int isCSFree,int isInCS){
        int temp = isCSFree;
        this.isCSFree = isInCS;
        this.isInCS = temp;
    }

    public synchronized boolean isNotFreeToEnterCS(int requestCS, int releaseCS) {
        if (requestCS == 1 && releaseCS == 0 && this.isInCS == 0 && this.isCSFree == 1) {
            this.swap(1,0);
            return false;
        }
        else if (requestCS == 0 && releaseCS == 1 && this.isInCS == 1 && this.isCSFree == 0){
            this.swap(0,1);
            return false;
        }

        return true;
    }
}
