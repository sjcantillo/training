def ModuleTimeDiference(data):
  temp = data.split("\n");
  time = 0;
  t = [];
  timeDif = 0;
  res = "";
  days = 0;
  hours = 0;
  minutes = 0;
  segs = 0;
  for i in range(0,int(temp[0])):
    t = temp[i+1].split(" ");
    timeDif = ((int(t[4])*60*60*24) + (int(t[5])*60*60) + (int(t[6])*60) + int(t[7])) - ((int(t[0])*60*60*24) + (int(t[1])*60*60) + (int(t[2])*60) + int(t[3]));
    days = timeDif // (60*60*24);
    hours = (timeDif % (60*60*24)) // (60*60);
    minutes = (timeDif % (60*60)) // 60;
    segs = timeDif % 60;
    res += "(" + str(days) + " " + str(hours) + " " + str(minutes) + " " + str(segs) + ") ";
  print(res);
