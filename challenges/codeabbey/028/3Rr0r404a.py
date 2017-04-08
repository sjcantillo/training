def BMI(data):
  temp = data.split("\n")
  res=""
  t=[]
  bmi = 0
  for i in range(0,int(temp[0])):
    t = temp[i+1].split(" ")
    bmi = float(t[0]) / pow(float(t[1]),2)
    if (bmi < 18.5):
      res += "under "
    elif ( bmi >= 18.5 and bmi < 25.0):
      res += "normal "
    elif ( bmi >=25.0 and bmi < 30.0):
      res += "over "
    else:
      res += "obese "
  print(res)
