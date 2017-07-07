"""This function find the minimum of tow numbers"""


def menor(data):
    """Find the minimum"""
    tlist = data.split("\n")
    temp = []
    res = ""
    for i in range(0, int(tlist[0])):
        temp = tlist[i+1].split(" ")
        if int(temp[0]) < int(temp[1]):
            res += temp[0] + " "
        else:
            res += temp[1] + " "
    print res
