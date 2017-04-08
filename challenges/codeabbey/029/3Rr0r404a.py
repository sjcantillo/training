def sortWithIndex(data):
  temp = data.split("\n");
  repets = int(temp[0]);
  temp = temp[1].split(" ");
  res = "";
  for i in range(0,repets):
    temp[i] = [temp[i],(i+1)];
  disorderFlg = True;
  swapFlg = False;
  while(disorderFlg):
    swapFlg = False;
    for i in range(0,(repets-1)):
      if(int(temp[i+1][0]) < int(temp [i][0])):
        swapFlg = True;
        t = temp[i];
        temp[i] = temp[i+1];
        temp[i+1] = t;
    if not(swapFlg):
      disorderFlg = False;
  for n in temp:
    res += str(n[1]) + " ";
  print(res);
