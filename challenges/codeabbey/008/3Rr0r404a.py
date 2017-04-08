def arithmeticProgression(data):
  temp = data.split("\n");
  res = "";
  t = [];
  n = 0;
  for i in range(0,int(temp[0])):
    t = temp[i+1].split(" ");
    for x in range(0,int(t[2])):
      n += int(t[0]) + (x * int(t[1]));
    res += str(n) + " ";
    n=0;
  print(res);
