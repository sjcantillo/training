def farToCel(data):
    temp = data.split(" ");
    c=0;
    res="";
    for i in range(0,int(temp[0])):
        c = round(((int(temp[i+1]) - 32) * (5/9)));
        res += str(c) + " ";
    print(res);
