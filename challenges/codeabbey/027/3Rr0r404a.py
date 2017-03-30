def bubbleSort(data):
        temp = data.split("\n");
        repets = int(temp[0]);
        temp = temp[1].split(" ");
        disorderFlg = True;
        swapFlg = False;
        contSwap = 0;
        contPasses = 0;
        while(disorderFlg):
                swapFlg = False;
                for i in range(0,(repets-1)):
                        if(int(temp[i+1]) < int(temp [i])):
                                swapFlg = True;
                                contSwap += 1;
                                t = temp[i];
                                temp[i] = temp[i+1];
                                temp[i+1] = t;
                contPasses += 1;
                if not(swapFlg):
                        disorderFlg = False;
        print(str(contPasses) + " " + str(contSwap)); 
