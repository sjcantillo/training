def sumaLoop1(data):
  temp = data.split("\n");
  t=[];
  n=0;
  for i in range(0,int(temp[0])):
    t = temp[1].split(" ");
    n += int(t[i]);
  print(n);
