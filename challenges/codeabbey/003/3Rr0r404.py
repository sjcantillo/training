def sumaLoop(data):
    temp = data.split("\n");
    res = "";
    t=[];
    n=0;
    for i in range(0,int(temp[0])):
        t = temp[i+1].split(" ");
        n = int(t[0]) + int(t[1]);
        res += str(n) + " ";
    print(res)
