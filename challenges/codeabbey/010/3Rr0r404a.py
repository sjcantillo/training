def linearFunction(data):
        temp = data.split("\n");
        t = [];
        a = 0;
        b = 0;
        res = "";
        for i in range(0,int(temp[0])):
                t = temp[i+1].split(" ");
                a = (int(t[3]) - int(t[1])) / (int(t[2]) - int(t[0]));
                b = int(t[1]) - (a * int(t[0]));
                res += "(" + str(int(a)) + " " + str(int(b)) + ") ";
        print(res);
