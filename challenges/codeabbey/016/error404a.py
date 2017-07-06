"""This function calculate the average of an array
input data:
3
2 3 7 0
20 10 0
1 0"""


def avg(data):
    """Capture the input data an calculate the average"""
    temp = data.split("\n")
    res = ""
    tlist = []
    acum = 0
    for icont in range(0,int(temp[0])):
        tlist = temp[icont+1].split(" ")
        for numb in tlist:
            acum += int(numb)
        acum = round(acum / (len(tlist) - 1), 0)
        res += str(int(acum)) + " "
        acum = 0
    print res
