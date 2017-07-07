"""This function calculate the difference between tow date
of the same month
input data:
3
1 0 0 0 2 3 4 5
5 3 23 22 24 4 20 45
8 4 6 47 9 11 51 13"""


def moduletimediference(data):
    """Calculate the difference between tow dates of the same month"""
    temp = data.split("\n")
    tlist = []
    nuday = 0
    nuhour = 0
    numin = 0
    tdif = 0
    res = ""
    daytime = 60 * 60 * 24
    hourtime = 60 * 60
    for i in range(0, int(temp[0])):
        tlist = temp[i+1].split(" ")
        nuday = int(tlist[4]) * daytime
        nuhour = int(tlist[5]) * hourtime
        numin = int(tlist[6]) * 60
        tdif = nuday + nuhour + numin + int(tlist[7])
        nuday = int(tlist[0]) * daytime
        nuhour = int(tlist[1]) * hourtime
        numin = int(tlist[2]) * 60
        tdif = tdif - nuday + nuhour + numin + int(tlist[3])
        nuday = tdif // daytime
        nuhour = (tdif % daytime) // hourtime
        numin = (tdif % hourtime) // 60
        res += "(" + str(nuday) + " " + str(nuhour)
        res += " " + str(numin) + " " + str(tdif % 60) + ") "
    print res
