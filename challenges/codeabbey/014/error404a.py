"""This function get the modulo of consecutive operations
input data:
5
+ 3
* 7
+ 10
* 2
* 3
+ 1
% 11"""


def modularcalculator(data):
    """Calculate the modulo"""
    temp = data.split("\n")
    seed = int(temp[0])
    tlist = []
    res = 0
    for i in range(1, len(temp)):
        tlist = temp[i].split(" ")
        if tlist[0] == "+":
            seed += int(tlist[1])
        elif tlist[0] == "*":
            seed *= int(tlist[1])
        else:
            res = seed % int(tlist[1])
    print str(res)
