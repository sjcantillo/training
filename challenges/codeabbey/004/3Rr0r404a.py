def menor(data):
    t = data.split("\n");
    temp = [];
    res = "";
    for i in range(0,int(t[0])):
        temp = t[i+1].split(" ");
        if (int(temp[0]) < int(temp[1])):
            res += temp[0] + " ";
        else:
            res += temp[1] + " ";
    print (res);
