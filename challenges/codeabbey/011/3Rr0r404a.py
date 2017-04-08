def sumaDigitLoop(data):
  temp = data.split("\n");
  res = "";
  t=[];
  n=0;
  r=0;
  for i in range(0,int(temp[0])):
    t = temp[i+1].split(" ");
    n = (int(t[0]) * int(t[1])) + int(t[2]);
    for i in str(n):
      r +=  int(i);
    res += str(r) + " ";
    r = 0;
  print(res);
