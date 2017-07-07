"""This function determine which triplets it is possible
to build triangle and for which it is not"""


def triangles(data):
    """Determine if is possible to build triangle""" 
    temp = data.split("\n")
    res = ""
    tlist = []
    flag1 = False
    flag2 = False
    flag3 = False
    for i in range(0, int(temp[0])):
        tlist = temp[i+1].split(" ")
        flag1 = (int(tlist[0]) + int(tlist[1])) > int(tlist[2])
        flag2 = (int(tlist[0]) + int(tlist[2])) > int(tlist[1])
        flag3 = (int(tlist[1]) + int(tlist[2])) > int(tlist[0])
        if flag1 and flag2 and flag3:
            res += "1 "
        else:
            res += "0 "
    print res
