"""This function find the minimum of three numbers"""


def menortriple(data):
    """Calculate the minimum"""
    tlist = data.split("\n")
    temp = []
    res = ""
    for i in range(0, int(tlist[0])):
        temp = tlist[i+1].split(" ")
        if int(temp[0]) < int(temp[1]):
            if int(temp[0]) < int(temp[2]):
                res += temp[0] + " "
            else:
                res += temp[2] + " "
        elif int(temp[1]) < int(temp[0]):
            if int(temp[1]) < int(temp[2]):
                res += temp[1] + " "
            else:
                res += temp[2] + " "
    print res
