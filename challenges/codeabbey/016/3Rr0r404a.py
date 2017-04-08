def avg(data):
  temp = data.split("\n");
  res = "";
  t=[];
  n=0;
  for i in range(0,int(temp[0])):
    t = temp[i+1].split(" ");
    for x in t:
      n += int(x);
    n = round(n / (len(t)-1),0);
    res += str(int(n)) + " ";
    n = 0;
  print(res);
