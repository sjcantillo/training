def sumaWsdLoop(data):
        temp = data.split("\n");
        res = "";
        t=[];
        n=0;
        for i in range(0,int(temp[0])):
                t = temp[1].split(" ");
                for l in range(0,len(t[i])):
                        n += (int(t[i][l]) * (l+1));                        
                res += str(n) + " ";
                n = 0;
        print(res);
