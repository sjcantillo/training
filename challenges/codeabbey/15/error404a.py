"""This functions find the max and min of array"""


def maxmin(data):
    """Find the maximun and minimum number in the input data"""
    res = ""
    temp = data.split(" ")
    mini = 9999999999999999999999999999999999999999999
    maxi = -999999999999999999999999999999999999999999
    for i in range(0, len(temp)):
        if int(temp[i]) < mini:
            mini = int(temp[i])
        if int(temp[i]) > maxi:
            maxi = int(temp[i])
    res = str(maxi) + " " + str(mini)
    print res
