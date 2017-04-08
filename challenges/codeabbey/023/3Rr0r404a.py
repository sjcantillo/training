def bubbleInArray(data):
  temp = data.split(" ");
  temp.pop(len(temp)-1);
  disorderFlg = True;
  contSwap = 0;
  arrayHash = 0;
  for i in range(0,(len(temp)-1)):
    if(int(temp[i+1]) < int(temp [i])):
      swapFlg = True;
      contSwap += 1;
      t = temp[i];
      temp[i] = temp[i+1];
      temp[i+1] = t;
  for num in temp:
    arrayHash = ((arrayHash + int(num))*113) % 10000007;
  print(str(contSwap) + " " + str(arrayHash));
