def gcd(data):
  temp = data.split("\n");
  t = [];
  lcm = 0;
  res = "";
  for i in range(0,int(temp[0])):
    t = temp[i+1].split(" ");
    if int(t[0]) > int(t[1]):
      a = int(t[0]);
      b = int(t[1]);
    else:
      a = int(t[1]);
      b = int(t[0]);
    while(b != 0):
      tmp = b;
      b = a % b;
      a = tmp;
    lcm = (int(t[0]) * int(t[1])) // a;
    res += "(" + str(a) + " " + str(lcm) + ") ";
  print(res);
