def squareRoot(data):
        temp = data.split("\n");
        res = "";
        r = 1;
        cases = [];
        for i in range(0,int(temp[0])):
                cases = temp[i+1].split(" ");
                r = 1;
                for x in range(0,int(cases[1])):
                        r = (r + (int(cases[0])/r))/2;
                res += str(round(r,7)) + " ";
        print(res);
