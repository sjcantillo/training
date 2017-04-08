def numOfVowels(data):
  temp = data.split("\n");
  c=0;
  res="";
  vowels="a,o,u,i,e,y";
  t=[];
  for i in range(0,int(temp[0])):
    for letter in temp[i+1]:
      if (letter in vowels):
        c += 1;
    res += str(c) + " ";
    c = 0;
  print(res);
