def triangles(data):
  temp = data.split("\n");
  res = "";
  t = [];
  for i in range(0, int(temp[0])):
    t = temp[i+1].split(" ");
    if (((int(t[0])+int(t[1]))>int(t[2])) and ((int(t[0])+int(t[2]))>int(t[1])) and ((int(t[1])+int(t[2]))>int(t[0]))):
      res += "1 ";
    else:
      res += "0 ";
  print(res);
