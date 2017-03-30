def randomGenerator(data):
        temp = data.split("\n");
        numSec = 0;
        sec = [];
        cont = 1;
        res = "";
        seeds = temp[1].split(" ");
        loopFlg = True;
        for i in range(0,int(temp[0])):
                cont = 1;
                loopFlg = True;
                numSec = int(seeds[i]);
                sec.append(numSec);
                while(loopFlg):
                        numSec = int(str(pow(numSec,2)).zfill(8)[2:6]);
                        if (numSec in sec):
                                loopFlg = False;
                        else:
                                sec.append(numSec);
                                cont += 1;
                res += str(cont) + " ";
                sec = [];
        print(res);
