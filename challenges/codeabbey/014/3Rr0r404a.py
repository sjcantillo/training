def modularCalculator(data):
        temp = data.split("\n");
        seed = int(temp[0]);
        t=[];
        res = 0;
        for i in range(1,len(temp)):
                t = temp[i].split(" ");
                if (t[0] == "+"):
                        seed += int(t[1]);
                elif (t[0] == "*"):
                        seed *= int(t[1]);
                else:
                        res = seed % int(t[1]);
        print(str(res));
